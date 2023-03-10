/*
 * Copyright 2023 Wilko Manger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dotlin.intrinsics

// TODO: Kotlin-only internal (@DartPublic)

internal sealed interface `$Jump` {
    val target: Int
}

internal class `$Return`<T> const constructor(val value: T, override val target: Int) : `$Jump`
internal class `$Break` const constructor(override val target: Int) : `$Jump`
internal class `$Continue` const constructor(override val target: Int) : `$Jump`