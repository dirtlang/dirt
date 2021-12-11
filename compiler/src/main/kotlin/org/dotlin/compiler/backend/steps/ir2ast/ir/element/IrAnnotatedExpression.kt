/*
 * Copyright 2021 Wilko Manger
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

package org.dotlin.compiler.backend.steps.ir2ast.ir.element

import org.jetbrains.kotlin.ir.UNDEFINED_OFFSET
import org.jetbrains.kotlin.ir.declarations.IrAnnotationContainer
import org.jetbrains.kotlin.ir.expressions.IrConstructorCall
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.types.IrType
import org.jetbrains.kotlin.ir.visitors.IrElementVisitor

class IrAnnotatedExpression(
    val expression: IrExpression,
    override val annotations: List<IrConstructorCall>,
) : IrExpression(), IrAnnotationContainer {
    override var type: IrType = expression.type

    override val startOffset = UNDEFINED_OFFSET
    override val endOffset = UNDEFINED_OFFSET

    override fun <R, D> accept(visitor: IrElementVisitor<R, D>, data: D) = visitor.visitExpression(this, data)

    override fun <D> acceptChildren(visitor: IrElementVisitor<Unit, D>, data: D) {
        expression.accept(visitor, data)
    }
}

val IrExpression.annotations: List<IrConstructorCall>
    get() = when (this) {
        is IrAnnotatedExpression -> annotations
        else -> emptyList()
    }