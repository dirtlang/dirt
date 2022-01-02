/*
 * Copyright 2010-2021 JetBrains s.r.o.
 * Copyright 2021 Wilko Manger
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
    "DIVISION_BY_ZERO",
    "WRONG_EXTERNAL_DECLARATION", // TODO: Fix in analyzer
    "WRONG_INITIALIZER_OF_EXTERNAL_DECLARATION", // TODO: Fix in analyzer
    "EXTERNAL_DELEGATED_CONSTRUCTOR_CALL", // TODO: Fix in analyzer
    "WRONG_BODY_OF_EXTERNAL_DECLARATION", // TODO: Fix in analyzer
)

package kotlin

/**
 * Represents a 8-bit signed integer.
 *
 * In Dart, values of this type are represented as values of the primitive type `int`.
 */
@DartName("int")
external class Byte private constructor() : Number(), Comparable<Byte> {
    @DartName("Byte\$Companion")
    companion object {
        /**
         * A constant holding the minimum value an instance of Byte can have.
         */
        const val MIN_VALUE: Byte = -128

        /**
         * A constant holding the maximum value an instance of Byte can have.
         */
        const val MAX_VALUE: Byte = 127

        /**
         * The number of bytes used to represent an instance of Byte in a binary form.
         */
        @SinceKotlin("1.3")
        const val SIZE_BYTES: Int = 1

        /**
         * The number of bits used to represent an instance of Byte in a binary form.
         */
        @SinceKotlin("1.3")
        const val SIZE_BITS: Int = 8
    }

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    override operator fun compareTo(other: Byte): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Short): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Int): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Long): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Float): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Double): Int

    /** Adds the other value to this value. */
    operator fun plus(other: Byte): Int
    /** Adds the other value to this value. */
    operator fun plus(other: Short): Int
    /** Adds the other value to this value. */
    operator fun plus(other: Int): Int
    /** Adds the other value to this value. */
    operator fun plus(other: Long): Long
    /** Adds the other value to this value. */
    operator fun plus(other: Float): Float
    /** Adds the other value to this value. */
    operator fun plus(other: Double): Double

    /** Subtracts the other value from this value. */
    operator fun minus(other: Byte): Int
    /** Subtracts the other value from this value. */
    operator fun minus(other: Short): Int
    /** Subtracts the other value from this value. */
    operator fun minus(other: Int): Int
    /** Subtracts the other value from this value. */
    operator fun minus(other: Long): Long
    /** Subtracts the other value from this value. */
    operator fun minus(other: Float): Float
    /** Subtracts the other value from this value. */
    operator fun minus(other: Double): Double

    /** Multiplies this value by the other value. */
    operator fun times(other: Byte): Int
    /** Multiplies this value by the other value. */
    operator fun times(other: Short): Int
    /** Multiplies this value by the other value. */
    operator fun times(other: Int): Int
    /** Multiplies this value by the other value. */
    operator fun times(other: Long): Long
    /** Multiplies this value by the other value. */
    operator fun times(other: Float): Float
    /** Multiplies this value by the other value. */
    operator fun times(other: Double): Double

    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    operator fun div(other: Byte): Int
    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    operator fun div(other: Short): Int
    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    operator fun div(other: Int): Int
    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    operator fun div(other: Long): Long
    /** Divides this value by the other value. */
    operator fun div(other: Float): Float
    /** Divides this value by the other value. */
    operator fun div(other: Double): Double

    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Byte): Int
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Short): Int
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Int): Int
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Long): Long
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Float): Float
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Double): Double

    /**
     * Returns this value incremented by one.
     *
     * @sample samples.misc.Builtins.inc
     */
    operator fun inc(): Byte

    /**
     * Returns this value decremented by one.
     *
     * @sample samples.misc.Builtins.dec
     */
    operator fun dec(): Byte

    /** Returns this value. */
    operator fun unaryPlus(): Int
    /** Returns the negative of this value. */
    operator fun unaryMinus(): Int

     /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Byte): IntRange
     /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Short): IntRange
     /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Int): IntRange
     /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Long): LongRange

    /** Returns this value. */
    @DartExtension
    override fun toByte(): Byte = this
    /**
     * Converts this [Byte] value to [Char].
     *
     * If this value is non-negative, the resulting `Char` code is equal to this value.
     *
     * The least significant 8 bits of the resulting `Char` code are the same as the bits of this `Byte` value,
     * whereas the most significant 8 bits are filled with the sign bit of this value.
     */
    @Deprecated("Direct conversion to Char is deprecated. Use toInt().toChar() or Char constructor instead.", ReplaceWith("this.toInt().toChar()"))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @DartExtension
    override fun toChar(): Char = clampToChar()
    /**
     * Converts this [Byte] value to [Short].
     *
     * The resulting `Short` value represents the same numerical value as this `Byte`.
     *
     * The least significant 8 bits of the resulting `Short` value are the same as the bits of this `Byte` value,
     * whereas the most significant 8 bits are filled with the sign bit of this value.
     */
    @DartExtension
    override fun toShort(): Short = this as Short
    /**
     * Converts this [Byte] value to [Int].
     *
     * The resulting `Int` value represents the same numerical value as this `Byte`.
     *
     * The least significant 8 bits of the resulting `Int` value are the same as the bits of this `Byte` value,
     * whereas the most significant 24 bits are filled with the sign bit of this value.
     */
    @DartExtension
    override fun toInt(): Int = this as Int
    /**
     * Converts this [Byte] value to [Long].
     *
     * The resulting `Long` value represents the same numerical value as this `Byte`.
     *
     * The least significant 8 bits of the resulting `Long` value are the same as the bits of this `Byte` value,
     * whereas the most significant 56 bits are filled with the sign bit of this value.
     */
    @DartExtension
    override fun toLong(): Long = this as Long
    /**
     * Converts this [Byte] value to [Float].
     *
     * The resulting `Float` value represents the same numerical value as this `Byte`.
     */
    @DartExtension
    override fun toFloat(): Float = intToFloat()
    /**
     * Converts this [Byte] value to [Double].
     *
     * The resulting `Double` value represents the same numerical value as this `Byte`.
     */
    @DartExtension
    override fun toDouble(): Double = intToDouble()
}

/**
 * Represents a 16-bit signed integer.
 *
 * In Dart, values of this type are represented as values of the primitive type `int`.
 */
@DartName("int")
external class Short private constructor() : Number(), Comparable<Short> {
    @DartName("Short\$Companion")
    companion object {
        /**
         * A constant holding the minimum value an instance of Short can have.
         */
        const val MIN_VALUE: Short = -32768

        /**
         * A constant holding the maximum value an instance of Short can have.
         */
        const val MAX_VALUE: Short = 32767

        /**
         * The number of bytes used to represent an instance of Short in a binary form.
         */
        @SinceKotlin("1.3")
        const val SIZE_BYTES: Int = 2

        /**
         * The number of bits used to represent an instance of Short in a binary form.
         */
        @SinceKotlin("1.3")
        const val SIZE_BITS: Int = 16
    }

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Byte): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    override operator fun compareTo(other: Short): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Int): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Long): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Float): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Double): Int

    /** Adds the other value to this value. */
    operator fun plus(other: Byte): Int
    /** Adds the other value to this value. */
    operator fun plus(other: Short): Int
    /** Adds the other value to this value. */
    operator fun plus(other: Int): Int
    /** Adds the other value to this value. */
    operator fun plus(other: Long): Long
    /** Adds the other value to this value. */
    operator fun plus(other: Float): Float
    /** Adds the other value to this value. */
    operator fun plus(other: Double): Double

    /** Subtracts the other value from this value. */
    operator fun minus(other: Byte): Int
    /** Subtracts the other value from this value. */
    operator fun minus(other: Short): Int
    /** Subtracts the other value from this value. */
    operator fun minus(other: Int): Int
    /** Subtracts the other value from this value. */
    operator fun minus(other: Long): Long
    /** Subtracts the other value from this value. */
    operator fun minus(other: Float): Float
    /** Subtracts the other value from this value. */
    operator fun minus(other: Double): Double

    /** Multiplies this value by the other value. */
    operator fun times(other: Byte): Int
    /** Multiplies this value by the other value. */
    operator fun times(other: Short): Int
    /** Multiplies this value by the other value. */
    operator fun times(other: Int): Int
    /** Multiplies this value by the other value. */
    operator fun times(other: Long): Long
    /** Multiplies this value by the other value. */
    operator fun times(other: Float): Float
    /** Multiplies this value by the other value. */
    operator fun times(other: Double): Double

    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    operator fun div(other: Byte): Int
    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    operator fun div(other: Short): Int
    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    operator fun div(other: Int): Int
    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    operator fun div(other: Long): Long
    /** Divides this value by the other value. */
    operator fun div(other: Float): Float
    /** Divides this value by the other value. */
    operator fun div(other: Double): Double

    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Byte): Int
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Short): Int
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Int): Int
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Long): Long
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Float): Float
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Double): Double

    /**
     * Returns this value incremented by one.
     *
     * @sample samples.misc.Builtins.inc
     */
    operator fun inc(): Short

    /**
     * Returns this value decremented by one.
     *
     * @sample samples.misc.Builtins.dec
     */
    operator fun dec(): Short

    /** Returns this value. */
    operator fun unaryPlus(): Int
    /** Returns the negative of this value. */
    operator fun unaryMinus(): Int

     /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Byte): IntRange
     /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Short): IntRange
     /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Int): IntRange
     /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Long): LongRange

    /**
     * Converts this [Short] value to [Byte].
     *
     * If this value is in [Byte.MIN_VALUE]..[Byte.MAX_VALUE], the resulting `Byte` value represents
     * the same numerical value as this `Short`.
     *
     * The resulting `Byte` value is represented by the least significant 8 bits of this `Short` value.
     */
    @DartExtension
    override fun toByte(): Byte = clampToByte()
    /**
     * Converts this [Short] value to [Char].
     *
     * The resulting `Char` code is equal to this value reinterpreted as an unsigned number,
     * i.e. it has the same binary representation as this `Short`.
     */
    @Deprecated("Direct conversion to Char is deprecated. Use toInt().toChar() or Char constructor instead.", ReplaceWith("this.toInt().toChar()"))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @DartExtension
    override fun toChar(): Char = clampToChar()
    /** Returns this value. */
    @DartExtension
    override fun toShort(): Short = this
    /**
     * Converts this [Short] value to [Int].
     *
     * The resulting `Int` value represents the same numerical value as this `Short`.
     *
     * The least significant 16 bits of the resulting `Int` value are the same as the bits of this `Short` value,
     * whereas the most significant 16 bits are filled with the sign bit of this value.
     */
    @DartExtension
    override fun toInt(): Int = this as Int
    /**
     * Converts this [Short] value to [Long].
     *
     * The resulting `Long` value represents the same numerical value as this `Short`.
     *
     * The least significant 16 bits of the resulting `Long` value are the same as the bits of this `Short` value,
     * whereas the most significant 48 bits are filled with the sign bit of this value.
     */
    @DartExtension
    override fun toLong(): Long = this as Long
    /**
     * Converts this [Short] value to [Float].
     *
     * The resulting `Float` value represents the same numerical value as this `Short`.
     */
    @DartExtension
    override fun toFloat(): Float = intToFloat()
    /**
     * Converts this [Short] value to [Double].
     *
     * The resulting `Double` value represents the same numerical value as this `Short`.
     */
    @DartExtension
    override fun toDouble(): Double = intToDouble()
}

/**
 * Represents a 32-bit signed integer.
 *
 * In Dart, values of this type are represented as values of the primitive type `int`.
 */
@DartName("int")
external class Int private constructor() : Number(), Comparable<Int> {
    @DartName("Int\$Companion")
    companion object {
        /**
         * A constant holding the minimum value an instance of Int can have.
         */
        const val MIN_VALUE: Int = -2147483648

        /**
         * A constant holding the maximum value an instance of Int can have.
         */
        const val MAX_VALUE: Int = 2147483647

        /**
         * The number of bytes used to represent an instance of Int in a binary form.
         */
        @SinceKotlin("1.3")
        const val SIZE_BYTES: Int = 4

        /**
         * The number of bits used to represent an instance of Int in a binary form.
         */
        @SinceKotlin("1.3")
        const val SIZE_BITS: Int = 32
    }

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Byte): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Short): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    override operator fun compareTo(other: Int): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Long): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Float): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Double): Int

    /** Adds the other value to this value. */
    operator fun plus(other: Byte): Int
    /** Adds the other value to this value. */
    operator fun plus(other: Short): Int
    /** Adds the other value to this value. */
    operator fun plus(other: Int): Int
    /** Adds the other value to this value. */
    operator fun plus(other: Long): Long
    /** Adds the other value to this value. */
    operator fun plus(other: Float): Float
    /** Adds the other value to this value. */
    operator fun plus(other: Double): Double

    /** Subtracts the other value from this value. */
    operator fun minus(other: Byte): Int
    /** Subtracts the other value from this value. */
    operator fun minus(other: Short): Int
    /** Subtracts the other value from this value. */
    operator fun minus(other: Int): Int
    /** Subtracts the other value from this value. */
    operator fun minus(other: Long): Long
    /** Subtracts the other value from this value. */
    operator fun minus(other: Float): Float
    /** Subtracts the other value from this value. */
    operator fun minus(other: Double): Double

    /** Multiplies this value by the other value. */
    operator fun times(other: Byte): Int
    /** Multiplies this value by the other value. */
    operator fun times(other: Short): Int
    /** Multiplies this value by the other value. */
    operator fun times(other: Int): Int
    /** Multiplies this value by the other value. */
    operator fun times(other: Long): Long
    /** Multiplies this value by the other value. */
    operator fun times(other: Float): Float
    /** Multiplies this value by the other value. */
    operator fun times(other: Double): Double

    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    operator fun div(other: Byte): Int
    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    operator fun div(other: Short): Int
    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    operator fun div(other: Int): Int
    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    operator fun div(other: Long): Long
    /** Divides this value by the other value. */
    operator fun div(other: Float): Float
    /** Divides this value by the other value. */
    operator fun div(other: Double): Double

    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Byte): Int
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Short): Int
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Int): Int
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Long): Long
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Float): Float
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Double): Double

    /**
     * Returns this value incremented by one.
     *
     * @sample samples.misc.Builtins.inc
     */
    operator fun inc(): Int

    /**
     * Returns this value decremented by one.
     *
     * @sample samples.misc.Builtins.dec
     */
    operator fun dec(): Int

    /** Returns this value. */
    operator fun unaryPlus(): Int
    /** Returns the negative of this value. */
    operator fun unaryMinus(): Int

     /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Byte): IntRange
     /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Short): IntRange
     /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Int): IntRange
     /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Long): LongRange

    /**
     * Shifts this value left by the [bitCount] number of bits.
     *
     * Note that only the five lowest-order bits of the [bitCount] are used as the shift distance.
     * The shift distance actually used is therefore always in the range `0..31`.
     */
    infix fun shl(bitCount: Int): Int

    /**
     * Shifts this value right by the [bitCount] number of bits, filling the leftmost bits with copies of the sign bit.
     *
     * Note that only the five lowest-order bits of the [bitCount] are used as the shift distance.
     * The shift distance actually used is therefore always in the range `0..31`.
     */
    infix fun shr(bitCount: Int): Int

    /**
     * Shifts this value right by the [bitCount] number of bits, filling the leftmost bits with zeros.
     *
     * Note that only the five lowest-order bits of the [bitCount] are used as the shift distance.
     * The shift distance actually used is therefore always in the range `0..31`.
     */
    infix fun ushr(bitCount: Int): Int

    /** Performs a bitwise AND operation between the two values. */
    infix fun and(other: Int): Int
    /** Performs a bitwise OR operation between the two values. */
    infix fun or(other: Int): Int
    /** Performs a bitwise XOR operation between the two values. */
    infix fun xor(other: Int): Int
    /** Inverts the bits in this value. */
    fun inv(): Int

    /**
     * Converts this [Int] value to [Byte].
     *
     * If this value is in [Byte.MIN_VALUE]..[Byte.MAX_VALUE], the resulting `Byte` value represents
     * the same numerical value as this `Int`.
     *
     * The resulting `Byte` value is represented by the least significant 8 bits of this `Int` value.
     */
    @DartExtension
    override fun toByte(): Byte = clampToByte()
    /**
     * Converts this [Int] value to [Char].
     *
     * If this value is in the range of `Char` codes `Char.MIN_VALUE..Char.MAX_VALUE`,
     * the resulting `Char` code is equal to this value.
     *
     * The resulting `Char` code is represented by the least significant 16 bits of this `Int` value.
     */
    @DartExtension
    override fun toChar(): Char = clampToChar()
    /**
     * Converts this [Int] value to [Short].
     *
     * If this value is in [Short.MIN_VALUE]..[Short.MAX_VALUE], the resulting `Short` value represents
     * the same numerical value as this `Int`.
     *
     * The resulting `Short` value is represented by the least significant 16 bits of this `Int` value.
     */
    @DartExtension
    override fun toShort(): Short = clampToShort()
    /** Returns this value. */
    @DartExtension
    override fun toInt(): Int = this
    /**
     * Converts this [Int] value to [Long].
     *
     * The resulting `Long` value represents the same numerical value as this `Int`.
     *
     * The least significant 32 bits of the resulting `Long` value are the same as the bits of this `Int` value,
     * whereas the most significant 32 bits are filled with the sign bit of this value.
     */
    @DartExtension
    override fun toLong(): Long = this as Long
    /**
     * Converts this [Int] value to [Float].
     *
     * The resulting value is the closest `Float` to this `Int` value.
     * In case when this `Int` value is exactly between two `Float`s,
     * the one with zero at least significant bit of mantissa is selected.
     */
    @DartExtension
    override fun toFloat(): Float = intToFloat()
    /**
     * Converts this [Int] value to [Double].
     *
     * The resulting `Double` value represents the same numerical value as this `Int`.
     */
    @DartExtension
    override fun toDouble(): Double = intToDouble()
}

/**
 * Represents a 64-bit signed integer.
 *
 * In Dart, values of this type are represented as values of the primitive type `long`.
 */
@DartName("int")
external class Long private constructor() : Number(), Comparable<Long> {
    @DartName("Long\$Companion")
    companion object {
        /**
         * A constant holding the minimum value an instance of Long can have.
         */
        const val MIN_VALUE: Long = -9223372036854775807L - 1L

        /**
         * A constant holding the maximum value an instance of Long can have.
         */
        const val MAX_VALUE: Long = 9223372036854775807L

        /**
         * The number of bytes used to represent an instance of Long in a binary form.
         */
        @SinceKotlin("1.3")
        const val SIZE_BYTES: Int = 8

        /**
         * The number of bits used to represent an instance of Long in a binary form.
         */
        @SinceKotlin("1.3")
        const val SIZE_BITS: Int = 64
    }

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Byte): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Short): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Int): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    override operator fun compareTo(other: Long): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Float): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Double): Int

    /** Adds the other value to this value. */
    operator fun plus(other: Byte): Long
    /** Adds the other value to this value. */
    operator fun plus(other: Short): Long
    /** Adds the other value to this value. */
    operator fun plus(other: Int): Long
    /** Adds the other value to this value. */
    operator fun plus(other: Long): Long
    /** Adds the other value to this value. */
    operator fun plus(other: Float): Float
    /** Adds the other value to this value. */
    operator fun plus(other: Double): Double

    /** Subtracts the other value from this value. */
    operator fun minus(other: Byte): Long
    /** Subtracts the other value from this value. */
    operator fun minus(other: Short): Long
    /** Subtracts the other value from this value. */
    operator fun minus(other: Int): Long
    /** Subtracts the other value from this value. */
    operator fun minus(other: Long): Long
    /** Subtracts the other value from this value. */
    operator fun minus(other: Float): Float
    /** Subtracts the other value from this value. */
    operator fun minus(other: Double): Double

    /** Multiplies this value by the other value. */
    operator fun times(other: Byte): Long
    /** Multiplies this value by the other value. */
    operator fun times(other: Short): Long
    /** Multiplies this value by the other value. */
    operator fun times(other: Int): Long
    /** Multiplies this value by the other value. */
    operator fun times(other: Long): Long
    /** Multiplies this value by the other value. */
    operator fun times(other: Float): Float
    /** Multiplies this value by the other value. */
    operator fun times(other: Double): Double

    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    operator fun div(other: Byte): Long
    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    operator fun div(other: Short): Long
    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    operator fun div(other: Int): Long
    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    operator fun div(other: Long): Long
    /** Divides this value by the other value. */
    operator fun div(other: Float): Float
    /** Divides this value by the other value. */
    operator fun div(other: Double): Double

    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Byte): Long
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Short): Long
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Int): Long
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Long): Long
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Float): Float
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Double): Double

    /**
     * Returns this value incremented by one.
     *
     * @sample samples.misc.Builtins.inc
     */
    operator fun inc(): Long

    /**
     * Returns this value decremented by one.
     *
     * @sample samples.misc.Builtins.dec
     */
    operator fun dec(): Long

    /** Returns this value. */
    operator fun unaryPlus(): Long
    /** Returns the negative of this value. */
    operator fun unaryMinus(): Long

     /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Byte): LongRange
     /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Short): LongRange
     /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Int): LongRange
     /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Long): LongRange

    /**
     * Shifts this value left by the [bitCount] number of bits.
     *
     * Note that only the six lowest-order bits of the [bitCount] are used as the shift distance.
     * The shift distance actually used is therefore always in the range `0..63`.
     */
    infix fun shl(bitCount: Int): Long

    /**
     * Shifts this value right by the [bitCount] number of bits, filling the leftmost bits with copies of the sign bit.
     *
     * Note that only the six lowest-order bits of the [bitCount] are used as the shift distance.
     * The shift distance actually used is therefore always in the range `0..63`.
     */
    infix fun shr(bitCount: Int): Long

    /**
     * Shifts this value right by the [bitCount] number of bits, filling the leftmost bits with zeros.
     *
     * Note that only the six lowest-order bits of the [bitCount] are used as the shift distance.
     * The shift distance actually used is therefore always in the range `0..63`.
     */
    infix fun ushr(bitCount: Int): Long

    /** Performs a bitwise AND operation between the two values. */
    infix fun and(other: Long): Long
    /** Performs a bitwise OR operation between the two values. */
    infix fun or(other: Long): Long
    /** Performs a bitwise XOR operation between the two values. */
    infix fun xor(other: Long): Long
    /** Inverts the bits in this value. */
    fun inv(): Long

    /**
     * Converts this [Long] value to [Byte].
     *
     * If this value is in [Byte.MIN_VALUE]..[Byte.MAX_VALUE], the resulting `Byte` value represents
     * the same numerical value as this `Long`.
     *
     * The resulting `Byte` value is represented by the least significant 8 bits of this `Long` value.
     */
    @DartExtension
    override fun toByte(): Byte = clampToByte()
    /**
     * Converts this [Long] value to [Char].
     *
     * If this value is in the range of `Char` codes `Char.MIN_VALUE..Char.MAX_VALUE`,
     * the resulting `Char` code is equal to this value.
     *
     * The resulting `Char` code is represented by the least significant 16 bits of this `Long` value.
     */
    @Deprecated("Direct conversion to Char is deprecated. Use toInt().toChar() or Char constructor instead.", ReplaceWith("this.toInt().toChar()"))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @DartExtension
    override fun toChar(): Char = clampToChar()
    /**
     * Converts this [Long] value to [Short].
     *
     * If this value is in [Short.MIN_VALUE]..[Short.MAX_VALUE], the resulting `Short` value represents
     * the same numerical value as this `Long`.
     *
     * The resulting `Short` value is represented by the least significant 16 bits of this `Long` value.
     */
    @DartExtension
    override fun toShort(): Short = clampToShort()
    /**
     * Converts this [Long] value to [Int].
     *
     * If this value is in [Int.MIN_VALUE]..[Int.MAX_VALUE], the resulting `Int` value represents
     * the same numerical value as this `Long`.
     *
     * The resulting `Int` value is represented by the least significant 32 bits of this `Long` value.
     */
    @DartExtension
    override fun toInt(): Int = clampToInt()
    /** Returns this value. */
    @DartExtension
    override fun toLong(): Long = this
    /**
     * Converts this [Long] value to [Float].
     *
     * The resulting value is the closest `Float` to this `Long` value.
     * In case when this `Long` value is exactly between two `Float`s,
     * the one with zero at least significant bit of mantissa is selected.
     */
    @DartExtension
    override fun toFloat(): Float = intToFloat()
    /**
     * Converts this [Long] value to [Double].
     *
     * The resulting value is the closest `Double` to this `Long` value.
     * In case when this `Long` value is exactly between two `Double`s,
     * the one with zero at least significant bit of mantissa is selected.
     */
    @DartExtension
    override fun toDouble(): Double = intToDouble()
}

/**
 * Represents a single-precision 32-bit IEEE 754 floating point number.
 *
 * In Dart, values of this type are represented as values of the primitive type `double`.
 */
@DartName("double")
external class Float private constructor() : Number(), Comparable<Float> {
    @DartName("Float\$Companion")
    companion object {
        /**
         * A constant holding the smallest *positive* nonzero value of Float.
         */
        const val MIN_VALUE: Float = 1.4E-45F

        /**
         * A constant holding the largest positive finite value of Float.
         */
        const val MAX_VALUE: Float = 3.4028235E38F

        /**
         * A constant holding the positive infinity value of Float.
         */
        const val POSITIVE_INFINITY: Float = 1.0F/0.0F

        /**
         * A constant holding the negative infinity value of Float.
         */
        const val NEGATIVE_INFINITY: Float = -1.0F/0.0F

        /**
         * A constant holding the "not a number" value of Float.
         */
        const val NaN: Float = -(0.0F/0.0F)

        /**
         * The number of bytes used to represent an instance of Float in a binary form.
         */
        @SinceKotlin("1.4")
        const val SIZE_BYTES: Int = 4

        /**
         * The number of bits used to represent an instance of Float in a binary form.
         */
        @SinceKotlin("1.4")
        const val SIZE_BITS: Int = 32
    }

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Byte): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Short): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Int): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Long): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    override operator fun compareTo(other: Float): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Double): Int

    /** Adds the other value to this value. */
    operator fun plus(other: Byte): Float
    /** Adds the other value to this value. */
    operator fun plus(other: Short): Float
    /** Adds the other value to this value. */
    operator fun plus(other: Int): Float
    /** Adds the other value to this value. */
    operator fun plus(other: Long): Float
    /** Adds the other value to this value. */
    operator fun plus(other: Float): Float
    /** Adds the other value to this value. */
    operator fun plus(other: Double): Double

    /** Subtracts the other value from this value. */
    operator fun minus(other: Byte): Float
    /** Subtracts the other value from this value. */
    operator fun minus(other: Short): Float
    /** Subtracts the other value from this value. */
    operator fun minus(other: Int): Float
    /** Subtracts the other value from this value. */
    operator fun minus(other: Long): Float
    /** Subtracts the other value from this value. */
    operator fun minus(other: Float): Float
    /** Subtracts the other value from this value. */
    operator fun minus(other: Double): Double

    /** Multiplies this value by the other value. */
    operator fun times(other: Byte): Float
    /** Multiplies this value by the other value. */
    operator fun times(other: Short): Float
    /** Multiplies this value by the other value. */
    operator fun times(other: Int): Float
    /** Multiplies this value by the other value. */
    operator fun times(other: Long): Float
    /** Multiplies this value by the other value. */
    operator fun times(other: Float): Float
    /** Multiplies this value by the other value. */
    operator fun times(other: Double): Double

    /** Divides this value by the other value. */
    operator fun div(other: Byte): Float
    /** Divides this value by the other value. */
    operator fun div(other: Short): Float
    /** Divides this value by the other value. */
    operator fun div(other: Int): Float
    /** Divides this value by the other value. */
    operator fun div(other: Long): Float
    /** Divides this value by the other value. */
    operator fun div(other: Float): Float
    /** Divides this value by the other value. */
    operator fun div(other: Double): Double

    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Byte): Float
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Short): Float
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Int): Float
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Long): Float
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Float): Float
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Double): Double

    /**
     * Returns this value incremented by one.
     *
     * @sample samples.misc.Builtins.inc
     */
    operator fun inc(): Float

    /**
     * Returns this value decremented by one.
     *
     * @sample samples.misc.Builtins.dec
     */
    operator fun dec(): Float

    /** Returns this value. */
    operator fun unaryPlus(): Float
    /** Returns the negative of this value. */
    operator fun unaryMinus(): Float


    /**
     * Converts this [Float] value to [Byte].
     *
     * The resulting `Byte` value is equal to `this.toInt().toByte()`.
     */
    @Deprecated("Unclear conversion. To achieve the same result convert to Int explicitly and then to Byte.", ReplaceWith("toInt().toByte()"))
    @DeprecatedSinceKotlin(warningSince = "1.3", errorSince = "1.5")
    @DartExtension
    override fun toByte(): Byte = clampToByte()
    /**
     * Converts this [Float] value to [Char].
     *
     * The resulting `Char` value is equal to `this.toInt().toChar()`.
     */
    @Deprecated("Direct conversion to Char is deprecated. Use toInt().toChar() or Char constructor instead.", ReplaceWith("this.toInt().toChar()"))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @DartExtension
    override fun toChar(): Char = clampToChar()
    /**
     * Converts this [Float] value to [Short].
     *
     * The resulting `Short` value is equal to `this.toInt().toShort()`.
     */
    @Deprecated("Unclear conversion. To achieve the same result convert to Int explicitly and then to Short.", ReplaceWith("toInt().toShort()"))
    @DeprecatedSinceKotlin(warningSince = "1.3", errorSince = "1.5")
    @DartExtension
    override fun toShort(): Short = clampToShort()
    /**
     * Converts this [Float] value to [Int].
     *
     * The fractional part, if any, is rounded down towards zero.
     * Returns zero if this `Float` value is `NaN`, [Int.MIN_VALUE] if it's less than `Int.MIN_VALUE`,
     * [Int.MAX_VALUE] if it's bigger than `Int.MAX_VALUE`.
     */
    @DartExtension
    override fun toInt(): Int = clampToInt()
    /**
     * Converts this [Float] value to [Long].
     *
     * The fractional part, if any, is rounded down towards zero.
     * Returns zero if this `Float` value is `NaN`, [Long.MIN_VALUE] if it's less than `Long.MIN_VALUE`,
     * [Long.MAX_VALUE] if it's bigger than `Long.MAX_VALUE`.
     */
    @DartExtension
    override fun toLong(): Long = clampToLong()
    /** Returns this value. */
    @DartExtension
    override fun toFloat(): Float = this
    // TODO: Fix "cast can never succeed" in analyzer
    /**
     * Converts this [Float] value to [Double].
     *
     * The resulting `Double` value represents the same numerical value as this `Float`.
     */
    @DartExtension
    override fun toDouble(): Double = this as Double
}

/**
 * Represents a double-precision 64-bit IEEE 754 floating point number.
 *
 * In Dart, values of this type are represented as values of the primitive type `double`.
 */
@DartName("double")
external class Double private constructor() : Number(), Comparable<Double> {
    @DartName("Double\$Companion")
    companion object {
        /**
         * A constant holding the smallest *positive* nonzero value of Double.
         */
        const val MIN_VALUE: Double = 4.9E-324

        /**
         * A constant holding the largest positive finite value of Double.
         */
        const val MAX_VALUE: Double = 1.7976931348623157E308

        /**
         * A constant holding the positive infinity value of Double.
         */
        const val POSITIVE_INFINITY: Double = 1.0/0.0

        /**
         * A constant holding the negative infinity value of Double.
         */
        const val NEGATIVE_INFINITY: Double = -1.0/0.0

        /**
         * A constant holding the "not a number" value of Double.
         */
        const val NaN: Double = -(0.0/0.0)

        /**
         * The number of bytes used to represent an instance of Double in a binary form.
         */
        @SinceKotlin("1.4")
        const val SIZE_BYTES: Int = 8

        /**
         * The number of bits used to represent an instance of Double in a binary form.
         */
        @SinceKotlin("1.4")
        const val SIZE_BITS: Int = 64
    }

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Byte): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Short): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Int): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Long): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Float): Int

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    override operator fun compareTo(other: Double): Int

    /** Adds the other value to this value. */
    operator fun plus(other: Byte): Double
    /** Adds the other value to this value. */
    operator fun plus(other: Short): Double
    /** Adds the other value to this value. */
    operator fun plus(other: Int): Double
    /** Adds the other value to this value. */
    operator fun plus(other: Long): Double
    /** Adds the other value to this value. */
    operator fun plus(other: Float): Double
    /** Adds the other value to this value. */
    operator fun plus(other: Double): Double

    /** Subtracts the other value from this value. */
    operator fun minus(other: Byte): Double
    /** Subtracts the other value from this value. */
    operator fun minus(other: Short): Double
    /** Subtracts the other value from this value. */
    operator fun minus(other: Int): Double
    /** Subtracts the other value from this value. */
    operator fun minus(other: Long): Double
    /** Subtracts the other value from this value. */
    operator fun minus(other: Float): Double
    /** Subtracts the other value from this value. */
    operator fun minus(other: Double): Double

    /** Multiplies this value by the other value. */
    operator fun times(other: Byte): Double
    /** Multiplies this value by the other value. */
    operator fun times(other: Short): Double
    /** Multiplies this value by the other value. */
    operator fun times(other: Int): Double
    /** Multiplies this value by the other value. */
    operator fun times(other: Long): Double
    /** Multiplies this value by the other value. */
    operator fun times(other: Float): Double
    /** Multiplies this value by the other value. */
    operator fun times(other: Double): Double

    /** Divides this value by the other value. */
    operator fun div(other: Byte): Double
    /** Divides this value by the other value. */
    operator fun div(other: Short): Double
    /** Divides this value by the other value. */
    operator fun div(other: Int): Double
    /** Divides this value by the other value. */
    operator fun div(other: Long): Double
    /** Divides this value by the other value. */
    operator fun div(other: Float): Double
    /** Divides this value by the other value. */
    operator fun div(other: Double): Double

    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Byte): Double
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Short): Double
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Int): Double
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Long): Double
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Float): Double
    /**
     * Calculates the remainder of truncating division of this value by the other value.
     * 
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Double): Double

    /**
     * Returns this value incremented by one.
     *
     * @sample samples.misc.Builtins.inc
     */
    operator fun inc(): Double

    /**
     * Returns this value decremented by one.
     *
     * @sample samples.misc.Builtins.dec
     */
    operator fun dec(): Double

    /** Returns this value. */
    operator fun unaryPlus(): Double
    /** Returns the negative of this value. */
    operator fun unaryMinus(): Double

    /**
     * Converts this [Double] value to [Byte].
     *
     * The resulting `Byte` value is equal to `this.toInt().toByte()`.
     */
    @Deprecated("Unclear conversion. To achieve the same result convert to Int explicitly and then to Byte.", ReplaceWith("toInt().toByte()"))
    @DeprecatedSinceKotlin(warningSince = "1.3", errorSince = "1.5")
    @DartExtension
    override fun toByte(): Byte = clampToByte()
    /**
     * Converts this [Double] value to [Char].
     *
     * The resulting `Char` value is equal to `this.toInt().toChar()`.
     */
    @Deprecated("Direct conversion to Char is deprecated. Use toInt().toChar() or Char constructor instead.", ReplaceWith("this.toInt().toChar()"))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @DartExtension
    override fun toChar(): Char = clampToChar()
    /**
     * Converts this [Double] value to [Short].
     *
     * The resulting `Short` value is equal to `this.toInt().toShort()`.
     */
    @Deprecated("Unclear conversion. To achieve the same result convert to Int explicitly and then to Short.", ReplaceWith("toInt().toShort()"))
    @DeprecatedSinceKotlin(warningSince = "1.3", errorSince = "1.5")
    @DartExtension
    override fun toShort(): Short = clampToShort()
    /**
     * Converts this [Double] value to [Int].
     *
     * The fractional part, if any, is rounded down towards zero.
     * Returns zero if this `Double` value is `NaN`, [Int.MIN_VALUE] if it's less than `Int.MIN_VALUE`,
     * [Int.MAX_VALUE] if it's bigger than `Int.MAX_VALUE`.
     */
    @DartExtension
    override fun toInt(): Int = clampToInt()
    /**
     * Converts this [Double] value to [Long].
     *
     * The fractional part, if any, is rounded down towards zero.
     * Returns zero if this `Double` value is `NaN`, [Long.MIN_VALUE] if it's less than `Long.MIN_VALUE`,
     * [Long.MAX_VALUE] if it's bigger than `Long.MAX_VALUE`.
     */
    @DartExtension
    override fun toLong(): Long = clampToLong()
    /**
     * Converts this [Double] value to [Float].
     *
     * The resulting value is the closest `Float` to this `Double` value.
     * In case when this `Double` value is exactly between two `Float`s,
     * the one with zero at least significant bit of mantissa is selected.
     */
    @DartExtension
    override fun toFloat(): Float = clampToFloat()
    /** Returns this value. */
    @DartExtension
    override fun toDouble(): Double = this
}

// TODO: Fix in analyzer
@Suppress("UNCHECKED_CAST")
private fun <T> T.clampToByte(): Byte where T : Comparable<T>, T : Number =
    clamp(Byte.MIN_VALUE as T, Byte.MAX_VALUE as T) as Byte

@Suppress("UNCHECKED_CAST")
private fun <T> T.clampToChar(): Char where T : Comparable<T>, T : Number =
    clamp(Char.MIN_VALUE as T, Char.MAX_VALUE as T) as Char

@Suppress("UNCHECKED_CAST")
private fun <T> T.clampToShort(): Short where T : Comparable<T>, T : Number =
    clamp(Short.MIN_VALUE as T, Short.MAX_VALUE as T) as Short

@Suppress("UNCHECKED_CAST")
private fun <T> T.clampToInt(): Int where T : Comparable<T>, T : Number =
    clamp(Int.MIN_VALUE as T, Int.MAX_VALUE as T) as Int

@Suppress("UNCHECKED_CAST")
private fun <T> T.clampToLong(): Long where T : Comparable<T>, T : Number =
    clamp(Long.MIN_VALUE as T, Long.MAX_VALUE as T) as Long

@Suppress("UNCHECKED_CAST")
private fun Double.clampToFloat(): Float =
    clamp(-Float.MIN_VALUE as Double, Float.MAX_VALUE as Double) as Float

@Suppress("UNCHECKED_CAST")
private fun <T> T.intToFloat(): Float where T : Comparable<T>, T : Number =
    intToDouble() as Float

@Suppress("UNCHECKED_CAST")
private fun <T> T.intToDouble(): Double where T : Comparable<T>, T : Number = dart("(this as int).toDouble()")

private fun <T> T.clamp(min: T, max: T): T where T : Comparable<T>, T : Number {
    val clamped = when {
        this >= min && this <= max -> this
        this < min -> max
        else -> min // this > max
    }

    return when (clamped) {
        is Double -> dart("(clamped as double).toInt()")
        else -> clamped
    }
}