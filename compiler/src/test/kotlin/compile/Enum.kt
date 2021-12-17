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
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Compile: Enum")
class Enum : BaseTest {
    @Test
    fun `enum`() = assertCompile {
        kotlin(
            """
            enum class Test {
                ALPHA,
                BETA,
            }
            """
        )

        dart(
            """
            import 'dart:core' hide Enum, List;
            import 'dart:core' as core;
            import 'package:meta/meta.dart';

            @sealed
            class Test extends Enum<Test> {
              const Test._(
                String name,
                int ordinal,
              ) : super(name, ordinal);
              static const Test ALPHA = Test._('ALPHA', 0);
              static const Test BETA = Test._('BETA', 1);
              static core.List<Test> values() {
                return <Test>[Test.ALPHA, Test.BETA];
              }

              static Test valueOf(String value) {
                return values().firstWhere((v) => v.name == value);
              }
            }
            """
        )
    }

    @Test
    fun `enum with one extra value`() = assertCompile {
        kotlin(
            """
            enum class Test(val lowercase: String) {
                ALPHA("α"),
                BETA("β"),
            }
            """
        )

        dart(
            """
            import 'dart:core' hide Enum, List;
            import 'dart:core' as core;
            import 'package:meta/meta.dart';

            @sealed
            class Test extends Enum<Test> {
              const Test._(
                String name,
                int ordinal,
                this.lowercase,
              ) : super(name, ordinal);
              @nonVirtual
              final String lowercase;
              static const Test ALPHA = Test._('ALPHA', 0, 'α');
              static const Test BETA = Test._('BETA', 1, 'β');
              static core.List<Test> values() {
                return <Test>[Test.ALPHA, Test.BETA];
              }

              static Test valueOf(String value) {
                return values().firstWhere((v) => v.name == value);
              }
            }
            """
        )
    }

    @Test
    fun `enum with two extra values`() = assertCompile {
        kotlin(
            """
            enum class Test(val lowercase: String, val uppercase: String) {
                ALPHA("α", "Α"),
                BETA("β", "Β"),
            }
            """
        )

        dart(
            """
            import 'dart:core' hide Enum, List;
            import 'dart:core' as core;
            import 'package:meta/meta.dart';

            @sealed
            class Test extends Enum<Test> {
              const Test._(
                String name,
                int ordinal,
                this.lowercase,
                this.uppercase,
              ) : super(name, ordinal);
              @nonVirtual
              final String lowercase;
              @nonVirtual
              final String uppercase;
              static const Test ALPHA = Test._('ALPHA', 0, 'α', 'Α');
              static const Test BETA = Test._('BETA', 1, 'β', 'Β');
              static core.List<Test> values() {
                return <Test>[Test.ALPHA, Test.BETA];
              }

              static Test valueOf(String value) {
                return values().firstWhere((v) => v.name == value);
              }
            }
            """
        )
    }

    @Test
    fun `get enum value`() = assertCompile {
        kotlin(
            """
            enum class Test {
                ALPHA,
                BETA,
            }

            fun main() {
                Test.ALPHA
            }
            """
        )

        dart(
            """
            import 'dart:core' hide Enum, List;
            import 'dart:core' as core;
            import 'package:meta/meta.dart';

            @sealed
            class Test extends Enum<Test> {
              const Test._(
                String name,
                int ordinal,
              ) : super(name, ordinal);
              static const Test ALPHA = Test._('ALPHA', 0);
              static const Test BETA = Test._('BETA', 1);
              static core.List<Test> values() {
                return <Test>[Test.ALPHA, Test.BETA];
              }

              static Test valueOf(String value) {
                return values().firstWhere((v) => v.name == value);
              }
            }

            void main() {
              Test.ALPHA;
            }
            """
        )
    }
}