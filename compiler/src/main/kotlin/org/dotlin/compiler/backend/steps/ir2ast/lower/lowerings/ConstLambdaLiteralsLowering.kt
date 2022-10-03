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

import org.dotlin.compiler.backend.steps.ir2ast.ir.IrExpressionContext
import org.dotlin.compiler.backend.steps.ir2ast.ir.deepCopyWith
import org.dotlin.compiler.backend.steps.ir2ast.lower.DartLoweringContext
import org.dotlin.compiler.backend.steps.ir2ast.lower.IrExpressionLowering
import org.dotlin.compiler.backend.steps.ir2ast.lower.Transformation
import org.dotlin.compiler.backend.steps.ir2ast.lower.noChange
import org.jetbrains.kotlin.backend.common.ir.addChild
import org.jetbrains.kotlin.descriptors.DescriptorVisibilities
import org.jetbrains.kotlin.ir.UNDEFINED_OFFSET
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.expressions.IrFunctionAccessExpression
import org.jetbrains.kotlin.ir.expressions.IrFunctionExpression
import org.jetbrains.kotlin.ir.expressions.impl.IrFunctionReferenceImpl
import org.jetbrains.kotlin.ir.util.fileOrNull
import org.jetbrains.kotlin.name.Name

/**
 * In Dart, lambda literals cannot be passed to const constructors. However, top-level/static function references can.
 * This lowering creates a named function of a lambda literal, making it passable to a const constructor.
 * Only applies to lambda literals that do not capture closure values, and only have local returns.
 */
@Suppress("UnnecessaryVariable")
class ConstLambdaLiteralsLowering(override val context: DartLoweringContext) : IrExpressionLowering {
    override fun DartLoweringContext.transform(
        expression: IrExpression,
        context: IrExpressionContext
    ): Transformation<IrExpression>? = context.run {
        if (expression !is IrFunctionAccessExpression ||
            !expression.isDartConst(initializedIn = initializerContainer?.declaration)
        ) {
            return noChange()
        }

        val file = container.fileOrNull ?: return noChange()
        for (i in 0 until expression.valueArgumentsCount) {
            val arg = expression.getValueArgument(i)
            if (arg !is IrFunctionExpression) continue

            val namedFunction = arg.function.deepCopyWith {
                visibility = DescriptorVisibilities.PRIVATE
                name = Name.identifier(
                    // Generate name based on the position in the file.
                    "$" + listOf(arg.startOffset, arg.endOffset)
                        .hashCode()
                        .toUInt()
                        .toString(radix = 16)
                )
            }

            expression.putValueArgument(
                i, IrFunctionReferenceImpl(
                    UNDEFINED_OFFSET, UNDEFINED_OFFSET,
                    type = arg.type,
                    namedFunction.symbol,
                    typeArgumentsCount = 0,
                    valueArgumentsCount = 0,
                )
            )

            file.addChild(namedFunction)
        }

        return noChange()
    }
}