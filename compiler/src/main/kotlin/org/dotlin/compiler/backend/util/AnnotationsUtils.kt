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

package org.dotlin.compiler.backend.util

import org.jetbrains.kotlin.ir.declarations.IrAnnotationContainer
import org.jetbrains.kotlin.ir.declarations.IrDeclaration
import org.jetbrains.kotlin.ir.declarations.IrOverridableDeclaration
import org.jetbrains.kotlin.ir.expressions.IrConst
import org.jetbrains.kotlin.ir.util.getAnnotation
import org.jetbrains.kotlin.ir.util.hasAnnotation
import org.jetbrains.kotlin.name.FqName

@Suppress("UNCHECKED_CAST")
fun IrAnnotationContainer.getSingleAnnotationStringArgumentOf(name: String) = getAnnotation(name)
    ?.getValueArgument(0)
    ?.let { it as? IrConst<String> }
    ?.value

@Suppress("UNCHECKED_CAST")
fun IrAnnotationContainer.getSingleAnnotationTypeArgumentOf(name: String) =
    getAnnotation(name)?.getTypeArgument(0)

fun IrAnnotationContainer.getAnnotation(name: String) = getAnnotation(FqName(name))

fun IrAnnotationContainer.hasAnnotation(name: String) = hasAnnotation(FqName(name))

fun IrDeclaration.hasOverriddenAnnotation(name: String): Boolean =
    hasAnnotation(name) || when (this) {
        is IrOverridableDeclaration<*> -> overriddenSymbols.any {
            (it.owner as? IrDeclaration)?.hasOverriddenAnnotation(name) == true
        }
        else -> false
    }
