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

package compile

import BaseTest
import assertCompile
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Compile: Expression")
class Expression : BaseTest {
    @Test
    fun `constructor call`() = assertCompile {
        kotlin(
            """
            class Test

            fun main() {
                Test()
            }
            """
        )

        dart(
            """
            class Test {
              Test() : super();
            }
            
            void main() {
              Test();
            }
            """
        )
    }

    @Test
    fun `private constructor call`() = assertCompile {
        kotlin(
            """
            class Test private constructor() {
                fun main() {
                    Test()
                }
            }
            """
        )

        dart(
            """
            class Test {
              Test._() : super();
              void main() {
                Test._();
              }
            }
            """
        )
    }


    @Test
    fun `method call`() = assertCompile {
        kotlin(
            """
            class Test {
                fun doIt() {}
            }

            fun main() {
                Test().doIt()
            }
            """
        )

        dart(
            """
            class Test {
              Test() : super();
              void doIt() {}
            }
            
            void main() {
              Test().doIt();
            }
            """
        )
    }

    @Test
    fun `if else`() = assertCompile {
        kotlin(
            """
            fun main() {
                val x = if (0 == 1) 0 else 1
            }
            """
        )

        dart(
            """
            void main() {
              final int x = 0 == 1 ? 0 : 1;
            }
            """
        )
    }

    @Test
    fun `if else if`() = assertCompile {
        kotlin(
            """
            fun test() = 3

            fun main() {
                val x = if (1 + 1 == 3) {
                    test()
                } else if (3 + 3 == 7){
                    test()
                } else {
                    test()
                }
            }
            """
        )

        dart(
            """
            int test() {
              return 3;
            }

            void main() {
              final int x = 1 + 1 == 3
                  ? test()
                  : 3 + 3 == 7
                      ? test()
                      : test();
            }
            """
        )
    }


    @Test
    fun `when`() = assertCompile {
        kotlin(
            """
            fun test() = 3

            fun main() {
                val x = when {
                    1 + 1 == 3 -> test()
                    3 + 3 == 7 -> test()
                    else -> test()
                }
            }
            """
        )

        dart(
            """
            int test() {
              return 3;
            }

            void main() {
              final int x = 1 + 1 == 3
                  ? test()
                  : 3 + 3 == 7
                      ? test()
                      : test();
            }
            """
        )
    }

    @Test
    fun `when with subject`() = assertCompile {
        kotlin(
            """
            fun test(x: Int): Int = x

            fun main() {
                val x = 34

                val y = when(x) {
                    4 -> test(2)
                    12 -> test(6)
                    else -> 0
                }
            }
            """
        )

        dart(
            """
            int test(int x) {
              return x;
            }
            
            void main() {
              final int x = 34;
              final int y = () {
                final int tmp0_subject = x;
                return tmp0_subject == 4
                    ? test(2)
                    : tmp0_subject == 12
                        ? test(6)
                        : 0;
              }.call();
            }
            """
        )
    }

    @Test
    fun `local anonymous function call`() = assertCompile {
        kotlin(
            """
            fun main() {
                val x = fun (): Int {
                    return 68
                }()
            }
            """
        )

        dart(
            """
            void main() {
              final int x = () {
                return 68;
              }.call();
            }
            """
        )
    }

    @Test
    fun `local anonymous function call with one argument`() = assertCompile {
        kotlin(
            """
            fun main() {
                val x = fun (y: Int): Int {
                    return 68 * y
                }(34)
            }
            """
        )

        dart(
            """
            void main() {
              final int x = (int y) {
                return 68 * y;
              }.call(34);
            }
            """
        )
    }

    @Test
    fun `null safe method call`() = assertCompile {
        kotlin(
            """
            class Gondor {
                fun callForAid() {}
            }

            fun main() {
                val gondor: Gondor? = null
                gondor?.callForAid()
            }
            """
        )

        dart(
            """
            class Gondor {
              Gondor() : super();
              void callForAid() {}
            }
            
            void main() {
              final Gondor? gondor = null;
              gondor?.callForAid();
            }
            """
        )
    }

    @Test
    fun `null safe chained method call`() = assertCompile {
        kotlin(
            """
            class Gondor {
                fun callForAid(): Answer? = Answer()
            }

            class Answer

            fun main() {
                val gondor: Gondor? = null
                gondor?.callForAid()?.toString()
            }
            """
        )

        dart(
            """
            class Gondor {
              Gondor() : super();
              Answer? callForAid() {
                return Answer();
              }
            }
            
            class Answer {
              Answer() : super();
            }
            
            void main() {
              final Gondor? gondor = null;
              gondor?.callForAid()?.toString();
            }
            """
        )
    }
}