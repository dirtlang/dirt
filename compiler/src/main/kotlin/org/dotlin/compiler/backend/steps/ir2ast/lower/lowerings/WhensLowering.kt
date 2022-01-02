/*
 * Copyright 2021-2022 Wilko Manger
 *
 * This file is part of Dotlin.
 *
 * Dotlin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Dotlin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Dotlin.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.dotlin.compiler.backend.steps.ir2ast.lower.lowerings

import org.dotlin.compiler.backend.steps.ir2ast.ir.IrCustomElementTransformerVoid
import org.dotlin.compiler.backend.steps.ir2ast.ir.IrDartStatementOrigin
import org.dotlin.compiler.backend.steps.ir2ast.ir.valueArguments
import org.dotlin.compiler.backend.steps.ir2ast.lower.*
import org.jetbrains.kotlin.ir.IrStatement
import org.jetbrains.kotlin.ir.builders.irCall
import org.jetbrains.kotlin.ir.declarations.IrDeclaration
import org.jetbrains.kotlin.ir.declarations.IrDeclarationParent
import org.jetbrains.kotlin.ir.declarations.IrVariable
import org.jetbrains.kotlin.ir.expressions.*
import org.jetbrains.kotlin.ir.expressions.impl.IrBlockImpl
import org.jetbrains.kotlin.ir.types.makeNotNull

/**
 * Since a temporary subject is used, smart cast does not work, so explicit casts are added.
 */
class WhensWithSubjectCastToNonNullLowering(override val context: DartLoweringContext) : IrExpressionLowering {
    override fun <D> DartLoweringContext.transform(
        expression: IrExpression,
        container: D
    ): Transformation<IrExpression>? where D : IrDeclaration, D : IrDeclarationParent {
        if (expression !is IrBlock || expression.origin != IrStatementOrigin.WHEN) return noChange()

        val originalSubject = (expression.statements.first() as IrVariable).initializer as? IrGetValue
            ?: return noChange()

        val whenExpression = expression.statements.last() as IrWhen

        var mustAssertNotNull = false
        for (branch in whenExpression.branches) {
            if (branch.condition.isEqualsNull()) {
                mustAssertNotNull = true
                continue
            }

            if (mustAssertNotNull) {
                branch.result = branch.result.transform(
                    object : IrCustomElementTransformerVoid() {
                        override fun visitExpression(expression: IrExpression): IrExpression {
                            expression.transformChildrenVoid()
                            if (expression !is IrGetValue || expression.symbol != originalSubject.symbol) {
                                return expression
                            }

                            return buildStatement(container.symbol) {
                                irCall(
                                    irBuiltIns.checkNotNullSymbol.owner,
                                    origin = IrStatementOrigin.EXCLEXCL
                                ).apply {
                                    type = expression.type.makeNotNull()
                                    putValueArgument(0, expression)
                                }
                            }
                        }
                    },
                    data = null
                )
            }
        }

        return noChange()
    }

    private fun IrExpression.isEqualsNull(): Boolean {
        if (this !is IrCall || origin != IrStatementOrigin.EQEQ) return false

        val argument = valueArguments.lastOrNull() ?: return false
        return argument is IrConst<*> && argument.kind == IrConstKind.Null
    }
}

/**
 * Changes the origin so that [WhensWithSubjectExpressionsLowering] doesn't change anything.
 */
class WhensWithSubjectStatementsLowering(override val context: DartLoweringContext) : IrStatementLowering {
    override fun DartLoweringContext.transform(
        statement: IrStatement,
        container: IrStatementContainer
    ): Transformations<IrStatement> {
        if (statement !is IrBlock || statement.origin != IrStatementOrigin.WHEN) return noChange()

        return just {
            statement.let { irBlock ->
                replaceWith(
                    IrBlockImpl(
                        startOffset = irBlock.startOffset,
                        endOffset = irBlock.endOffset,
                        type = irBlock.type,
                        statements = irBlock.statements,
                        origin = IrDartStatementOrigin.WHEN_STATEMENT
                    )
                )
            }
        }
    }
}

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class WhensWithSubjectExpressionsLowering(override val context: DartLoweringContext) : IrExpressionLowering {
    override fun <D> DartLoweringContext.transform(
        expression: IrExpression,
        container: D
    ): Transformation<IrExpression>? where D : IrDeclaration, D : IrDeclarationParent {
        if (expression !is IrBlock || expression.origin != IrStatementOrigin.WHEN) return noChange()

        val whenExpression = expression.statements.last() as IrWhen

        return replaceWith(
            wrapInAnonymousFunctionInvocation(whenExpression, container) {
                expression.statements.withLastAsReturn(at = it)
            }
        )
    }
}