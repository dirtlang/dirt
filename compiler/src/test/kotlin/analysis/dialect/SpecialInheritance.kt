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

package analysis.dialect

import BaseTest
import assertCanCompile
import assertCompilesWithError
import assertCompilesWithErrors
import assertCompilesWithWarning
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Analysis: Dialect: Special Inheritance")
class SpecialInheritance : BaseTest {
    @Test
    fun `implement multiple implicit interfaces`() = assertCanCompile {
        kotlin(
            """
            @file:Suppress("WRONG_BODY_OF_EXTERNAL_DECLARATION") // TODO: Fix in analyzer

            external open class Pigeon {
                constructor(implement: Interface)
            
                open fun fly(): Unit = definedExternally
            }

            external open class Carrier {
                constructor(implement: Interface)
            
                constructor(message: String)
            
                open fun send(): Unit = definedExternally
            }

            class CarrierPigeon : Pigeon(Interface), Carrier(Interface) {
                override fun send() {}
                override fun fly() {}
            }
            """
        )
    }

    @Test
    fun `implement multiple implicit interfaces that can be mixed in`() = assertCanCompile {
        kotlin(
            """
            @file:Suppress("WRONG_BODY_OF_EXTERNAL_DECLARATION") // TODO: Fix in analyzer

            external open class Pigeon {
                constructor(implement: Interface)
            
                open fun fly(): Unit = definedExternally
            }

            external open class Carrier {
                constructor(implement: Interface)
            
                constructor(message: String)
            
                open fun send(): Unit = definedExternally
            }

            class CarrierPigeon : Pigeon(Interface), Carrier(Interface) {
                override fun send() {}
                override fun fly() {}
            }
            """
        )
    }

    // TODO: Raise more specific error ("class should be first in super type list")
    @Test
    fun `raise error if regular class inheritance is not first in list`() =
        assertCompilesWithError("MANY_CLASSES_IN_SUPERTYPE_LIST") {
            kotlin(
                """
                @file:Suppress("WRONG_BODY_OF_EXTERNAL_DECLARATION") // TODO: Fix in analyzer
    
                external open class Pigeon {
                    constructor(implement: Interface)
                
                    open fun fly(): Unit = definedExternally
                }
    
                external open class Carrier {
                    constructor(implement: Interface)
                
                    constructor(message: String)
                
                    open fun send(): Unit = definedExternally
                }
    
                class CarrierPigeon : Pigeon(Interface), Carrier("Test") {
                    override fun send() {}
                    override fun fly() {}
                }
                """
            )
    }

    @Test
    fun `raise error if fake interface marker is used`() =
        assertCompilesWithError("MANY_CLASSES_IN_SUPERTYPE_LIST") {
            kotlin(
                """
                @file:Suppress("WRONG_BODY_OF_EXTERNAL_DECLARATION") // TODO: Fix in analyzer
    
                object Interface

                external open class Pigeon {
                    constructor(implement: Interface)
                
                    open fun fly(): Unit = definedExternally
                }
    
                external open class Carrier {
                    constructor(implement: Interface)
                
                    constructor(message: String)
                
                    open fun send(): Unit = definedExternally
                }
    
                class CarrierPigeon : Pigeon(Interface), Carrier(Interface) {
                    override fun send() {}
                    override fun fly() {}
                }
                """
            )
        }

    @Test
    fun `raise errors when missing implementations from implicit interface`() =
        assertCompilesWithError("ABSTRACT_MEMBER_NOT_IMPLEMENTED") {
            kotlin(
                """
                @file:Suppress("WRONG_BODY_OF_EXTERNAL_DECLARATION") // TODO: Fix in analyzer

                external open class Pigeon {
                    constructor(implement: InterfaceOrMixin)
                
                    open fun fly(): Unit = definedExternally
                }
    
                class CarrierPigeon : Pigeon(Interface)
                """
            )
        }

    @Test
    fun `raise errors when missing implementations from transitive implicit interface`() =
        assertCompilesWithError("ABSTRACT_MEMBER_NOT_IMPLEMENTED") {
            kotlin(
                """
                @file:Suppress("WRONG_BODY_OF_EXTERNAL_DECLARATION") // TODO: Fix in analyzer

                external open class Pigeon {
                    constructor(implement: InterfaceOrMixin)
                
                    open fun fly(): Unit = definedExternally
                }

                interface Carrier : Pigeon(Interface)
    
                class CarrierPigeon : Carrier
                """
            )
        }

    @Test
    fun `interface can implement implicit interface`() =
        assertCanCompile {
            kotlin(
                """
                @file:Suppress("WRONG_BODY_OF_EXTERNAL_DECLARATION") // TODO: Fix in analyzer

                external open class Pigeon {
                    constructor(implement: InterfaceOrMixin)
                
                    open fun fly(): Unit = definedExternally
                }
    
                interface CarrierPigeon : Pigeon(Interface)
                """
            )
        }
}