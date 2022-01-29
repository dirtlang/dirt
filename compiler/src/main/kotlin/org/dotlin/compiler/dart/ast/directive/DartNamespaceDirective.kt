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

package org.dotlin.compiler.dart.ast.directive

import org.dotlin.compiler.dart.ast.DartAstNodeVisitor
import org.dotlin.compiler.dart.ast.accept
import org.dotlin.compiler.dart.ast.annotation.DartAnnotation
import org.dotlin.compiler.dart.ast.expression.identifier.DartSimpleIdentifier
import org.dotlin.compiler.dart.ast.expression.literal.DartStringLiteral

sealed interface DartNamespaceDirective : DartUriBasedDirective {
    val combinators: List<DartCombinator>

    override fun <R, C> accept(visitor: DartAstNodeVisitor<R, C>, data: C) =
        visitor.visitNamespaceDirective(this, data)
}

data class DartImportDirective(
    override val uri: DartStringLiteral,
    val alias: DartSimpleIdentifier? = null,
    override val annotations: List<DartAnnotation> = emptyList(),
    override val combinators: List<DartCombinator> = emptyList(),
    override val documentationComment: String? = null,
) : DartNamespaceDirective {
    override fun <D> acceptChildren(visitor: DartAstNodeVisitor<Nothing?, D>, data: D) {
        uri.accept(visitor, data)
        alias?.accept(visitor, data)
        annotations.accept(visitor, data)
        combinators.accept(visitor, data)
    }
}

data class DartExportDirective(
    override val uri: DartStringLiteral,
    override val annotations: List<DartAnnotation> = emptyList(),
    override val combinators: List<DartCombinator> = emptyList(),
    override val documentationComment: String? = null,
) : DartNamespaceDirective {
    override fun <D> acceptChildren(visitor: DartAstNodeVisitor<Nothing?, D>, data: D) {
        uri.accept(visitor, data)
        annotations.accept(visitor, data)
        combinators.accept(visitor, data)
    }
}