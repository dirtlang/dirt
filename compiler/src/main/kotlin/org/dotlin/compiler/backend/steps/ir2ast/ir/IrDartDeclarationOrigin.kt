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

package org.dotlin.compiler.backend.steps.ir2ast.ir

import org.jetbrains.kotlin.ir.declarations.IrDeclarationOrigin
import org.jetbrains.kotlin.ir.types.IrType

@Suppress("ClassName")
sealed class IrDartDeclarationOrigin(private val name: String) : IrDeclarationOrigin {
    /**
     * Dart does not support parameters with complex (non-const) default values. This origin marks the class
     * to use for an instance as a default value for such a parameter. Then in the body, if the parameter is indeed
     * equal to the instance value, the real complex value (e.g. a function call) will be used.
     *
     * The `DefaultValue` class has two forms: One for Dart core built-ins which cannot be implemented, and any other
     * type. For other types, for example a `Vector`, it will take the form of `DefaultVectorValue`.
     */
    object COMPLEX_PARAM_DEFAULT_VALUE : IrDartDeclarationOrigin("COMPLEX_PARAM_DEFAULT_VALUE_MARKER")

    data class COMPLEX_PARAM(val originalType: IrType)
        : IrDartDeclarationOrigin("COMPLEX_PARAM")

    object SYNTHETIC_OPERATOR : IrDartDeclarationOrigin("SYNTHETIC_OPERATOR")

    object EXTENSION : IrDartDeclarationOrigin("EXTENSION")

    object OBJECT : IrDartDeclarationOrigin("OBJECT")

    object OBJECT_INSTANCE_FIELD : IrDartDeclarationOrigin("OBJECT_INSTANCE_FIELD")

    /**
     * References an element only present in Dart code.
     */
    object EXTERNAL_DART_REFERENCE : IrDartDeclarationOrigin("EXTERNAL_DART_REFERENCE")

    /**
     * The constructor was made a factory in Dart, as to initialize complex parameters in its body,
     * to then pass the correctly initialized parameters to the real constructor.
     */
    object FACTORY_REDIRECT : IrDartDeclarationOrigin("FACTORY_REDIRECT")

    /**
     * The actual constructor used in a factory redirect. See [FACTORY_REDIRECT].
     */
    object FACTORY_REDIRECT_ACTUAL : IrDartDeclarationOrigin("FACTORY_REDIRECT_ACTUAL")

    /**
     * A parameter that is used in a constructor where a complex parameter was passed to a super constructor call.
     * The parameter is now in the actual constructor of the factory redirect.
     * See [FACTORY_REDIRECT] and [FACTORY_REDIRECT_ACTUAL].
     */
    object FACTORY_REDIRECT_ACTUAL_PARAM : IrDartDeclarationOrigin("FACTORY_REDIRECT_ACTUAL_PARAM")

    override fun toString() = name
}