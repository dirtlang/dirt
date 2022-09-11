/*
 * Copyright 2022 Wilko Manger
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

package dart.typeddata

/**
 * Describes endianness to be used when accessing or updating a
 * sequence of bytes.
 */
external interface Endian {
    companion object {
        // TODO: const
        @DartStatic
        @DartName("big")
        external val BIG: Endian = definedExternally

        // TODO: const
        @DartStatic
        @DartName("little")
        external val LITTLE: Endian = definedExternally

        // TODO: const
        @DartStatic
        @DartName("host")
        external val HOST: Endian = definedExternally
    }
}