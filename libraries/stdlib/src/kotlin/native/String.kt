/*
 * Copyright 2010-2016 JetBrains s.r.o.
 * Copyright 2021-2022 Wilko Manger
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

@file:Suppress(
    "NON_ABSTRACT_FUNCTION_WITH_NO_BODY",
    "MUST_BE_INITIALIZED_OR_BE_ABSTRACT",
    "UNUSED_PARAMETER",
    "EXTERNAL_TYPE_EXTENDS_NON_EXTERNAL_TYPE" // TODO: Fix in analyzer?
)

package kotlin

/**
 * The `String` class represents character strings. All string literals in Kotlin programs, such as `"abc"`, are
 * implemented as instances of this class.
 */
external class String : Comparable<String>, CharSequence {
    companion object {}
    
    /**
     * Returns a string obtained by concatenating this string with the string representation of the given [other] object.
     */
    operator fun plus(other: Any?): String

    override val length: Int

    /**
     * Returns the character of this string at the specified [index].
     *
     * If the [index] is out of bounds of this string, throws an [IndexOutOfBoundsException] except in Kotlin/JS
     * where the behavior is unspecified.
     */
    override fun get(index: Int): Char

    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence

    override fun compareTo(other: String): Int
}
