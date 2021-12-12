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

package compile.builtins

import BaseTest
import assertCompile
import assertCompileFiles
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Compile: Built-ins: Dotlin")
class Dotlin : BaseTest {
    @Test
    fun `@DartName`() = assertCompile {
        kotlin(
            """
            @DartName("Dar")
            class Kot

            fun main() {
                Kot()
            }
            """
        )

        dart(
            """
            class Dar {}
            
            void main() {
              Dar();
            }
            """
        )
    }

    @Test
    fun `@DartName on primary constructor`() = assertCompile {
        kotlin(
            """
            class Human @DartName("withName") constructor(val name: String)

            fun main() {
                Human("Faramir")
            }
            """
        )

        dart(
            """
            class Human {
              Human.withName(this.name) : super();
              final String name;
            }

            void main() {
              Human.withName('Faramir');
            }
            """
        )
    }

    @Test
    fun `@DartName on secondary constructor`() = assertCompile {
        kotlin(
            """
            class Human(val name: String) {
                @DartName("nameless")
                constructor() : this("")
            }

            fun main() {
                Human()
            }
            """
        )

        dart(
            """
            class Human {
              Human(this.name) : super();
              final String name;
              Human.nameless() : this('');
            }

            void main() {
              Human.nameless();
            }
            """
        )
    }

    @Test
    fun `@DartConst constructor`() = assertCompile {
        kotlin(
            """
            class Test @DartConst constructor()

            fun main() {
                Test()
            }
            """
        )

        dart(
            """
            class Test {
              const Test() : super();
            }
            
            void main() {
              Test();
            }
            """
        )
    }

    @Test
    fun `@DartConst constructor call`() = assertCompile {
        kotlin(
            """
            class Test @DartConst constructor()

            fun main() {
                @DartConst Test()
            }
            """
        )

        dart(
            """
            class Test {
              const Test() : super();
            }

            void main() {
              const Test();
            }
            """
        )
    }

    @Test
    fun `@DartBuiltIn`() = assertCompile {
        kotlin(
            """
            @file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

            @DartBuiltIn
            class Test

            fun main() {
                Test()
            }
            """
        )

        dart(
            """
            void main() {
              Test();
            }
            """
        )
    }


    @Test
    fun `@DartBuiltInGetter`() = assertCompile {
        kotlin(
            """
            @file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

            class Hobbit {
                @DartBuiltIn.Getter
                fun isProudfoot(): Boolean = true
            }

            fun main() {
                Hobbit().isProudfoot()
            }
            """
        )

        dart(
            """
            class Hobbit {
              bool get isProudfoot {
                return true;
              }
            }

            void main() {
              Hobbit().isProudfoot;
            }
            """
        )
    }

    @Test
    fun `@DartBuiltInGetter override`() = assertCompile {
        kotlin(
            """
            @file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

            open class Hobbit {
                @DartBuiltIn.Getter
                open fun isProudfoot(): Boolean = false
            }

            class Proudfoot : Hobbit() {
                override fun isProudfoot(): Boolean = true
            }

            fun main() {
                Proudfoot().isProudfoot()
            }
            """
        )

        dart(
            """
            class Hobbit {
              bool get isProudfoot {
                return false;
              }
            }

            class Proudfoot extends Hobbit {
              @override
              bool get isProudfoot {
                return true;
              }
            }

            void main() {
              Proudfoot().isProudfoot;
            }
            """
        )
    }

    @Test
    fun `@DartBuiltInImportAlias`() = assertCompile {
        kotlin(
            """
            @file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

            @DartBuiltIn
            @DartBuiltIn.ImportAlias("dart:core")
            class List

            fun main() {
                List()
            }
            """
        )

        dart(
            """
            import 'dart:core' hide List;
            import 'dart:core' as core;

            void main() {
              core.List();
            }
            """
        )
    }

    @Test
    fun `@DartBuiltInImportAlias separate input files`() = assertCompileFiles {
        kotlin(
            """
            @file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

            package test

            @DartBuiltIn
            @DartBuiltIn.ImportAlias("dart:core")
            class List
            """
        )

        kotlin(
            """
            @file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

            package test

            fun main() {
                List()
            }
            """
        )

        dart(
            """
            import 'dart:core' hide List;
            import 'dart:core' as core;

            void main() {
              core.List();
            }
            """
        )
    }

    @Test
    fun `@DartBuiltInImportAlias type reference only`() = assertCompile {
        kotlin(
            """
            @file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

            @DartBuiltIn
            @DartBuiltIn.ImportAlias("dart:core")
            class List

            fun test(list: List) {}
            """
        )

        dart(
            """
            import 'dart:core' hide List;
            import 'dart:core' as core;

            void test(core.List list) {}
            """
        )
    }

    @Test
    fun `@DartBuiltInHideImport`() = assertCompile {
        kotlin(
            """
            @file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

            @DartBuiltIn.HideImport("dart:core")
            class Enum

            fun main() {
                Enum()
            }
            """
        )

        dart(
            """
            import 'dart:core' hide Enum;

            class Enum {}

            void main() {
              Enum();
            }
            """
        )
    }

    @Test
    fun `@DartBuiltInHideImport twice`() = assertCompile {
        kotlin(
            """
            @file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

            @DartBuiltIn.HideImport("dart:core")
            class Enum

            @DartBuiltIn.HideImport("dart:core")
            class List

            fun main() {
                Enum()
            }
            """
        )

        dart(
            """
            import 'dart:core' hide Enum, List;

            class Enum {}

            class List {}

            void main() {
              Enum();
            }
            """
        )
    }

    @Test
    fun `@DartBuiltInHideImport twice, multiple files`() = assertCompileFiles {
        kotlin(
            """
            @file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

            package test

            @DartBuiltIn.HideImport("dart:core")
            class Something

            @DartBuiltIn.HideImport("dart:core")
            class SomethingElse
            """
        )

        kotlin(
            """
            package test

            fun main() {
                Something()
            }
            """
        )

        dart(
            """
            import 'dart:core' hide Something, SomethingElse;

            class Something {}

            class SomethingElse {}

            void main() {
              Something();
            }
            """
        )
    }
}