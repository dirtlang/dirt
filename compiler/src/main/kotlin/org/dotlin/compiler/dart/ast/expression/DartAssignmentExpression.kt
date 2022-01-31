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

package org.dotlin.compiler.dart.ast.expression

import org.dotlin.compiler.dart.ast.DartAstNodeVisitor


data class DartAssignmentExpression(
    val left: DartExpression,
    val operator: DartAssignmentOperator = DartAssignmentOperator.ASSIGN,
    val right: DartExpression,
) : DartExpression {
    override fun <R, C> accept(visitor: DartAstNodeVisitor<R, C>, data: C) =
        visitor.visitAssignmentExpression(this, data)

    override fun <D> acceptChildren(visitor: DartAstNodeVisitor<Nothing?, D>, data: D) {
        left.accept(visitor, data)
        right.accept(visitor, data)
    }
}

enum class DartAssignmentOperator {
    ASSIGN,
    NULL_SHORTED,
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,
    INTEGER_DIVIDE
}