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

package org.dotlin.compiler.dart.ast.declaration.classormixin.member.constructor

import org.dotlin.compiler.dart.ast.DartAstNodeVisitor
import org.dotlin.compiler.dart.ast.annotation.DartAnnotation
import org.dotlin.compiler.dart.ast.declaration.classormixin.member.DartClassMember
import org.dotlin.compiler.dart.ast.declaration.function.DartFunctionDeclaration
import org.dotlin.compiler.dart.ast.expression.DartFunctionExpression
import org.dotlin.compiler.dart.ast.expression.identifier.DartSimpleIdentifier
import org.dotlin.compiler.dart.ast.type.DartNamedType

data class DartConstructorDeclaration(
    override val returnType: DartNamedType,
    val name: DartSimpleIdentifier? = null,
    override val function: DartFunctionExpression = DartFunctionExpression(),
    val initializers: List<DartConstructorInitializer> = listOf(),
    override val isExternal: Boolean = false,
    val isConst: Boolean = false,
    val isFactory: Boolean = false,
    override val annotations: List<DartAnnotation> = listOf(),
    override val documentationComment: String? = null,
) : DartClassMember, DartFunctionDeclaration {

    override val isGetter: Boolean = false
    override val isSetter: Boolean = false

    override fun <R, C> accept(visitor: DartAstNodeVisitor<R, C>, context: C): R =
        visitor.visitConstructorDeclaration(this, context)
}