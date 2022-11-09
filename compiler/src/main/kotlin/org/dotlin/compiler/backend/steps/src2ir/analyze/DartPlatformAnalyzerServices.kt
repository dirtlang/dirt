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

package org.dotlin.compiler.backend.steps.src2ir.analyze

import org.dotlin.compiler.backend.dart
import org.dotlin.compiler.backend.kotlin
import org.jetbrains.kotlin.resolve.ImportPath
import org.jetbrains.kotlin.resolve.PlatformDependentAnalyzerServices
import org.jetbrains.kotlin.storage.StorageManager

object DartPlatformAnalyzerServices : PlatformDependentAnalyzerServices() {
    override fun computePlatformSpecificDefaultImports(
        storageManager: StorageManager,
        result: MutableList<ImportPath>
    ) {
        result.addAll(
            listOf(
                ImportPath.fromString("dart.core.*"),
                ImportPath.fromString("dotlin.*"),
            )
        )
    }

    override val platformConfigurator = DartPlatformConfigurator
    override val excludedImports = listOf(
        kotlin.collections.Iterator, dart.core.Iterable,
        dart.core.List, dart.core.Set,
        dart.core.Map, dart.core.MapEntry,
    )
}