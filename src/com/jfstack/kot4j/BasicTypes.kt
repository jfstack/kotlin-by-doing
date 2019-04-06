package com.jfstack.kot4j

fun main(args: Array<String>) {

    /**
     * val -> makes variable read-only/immutable/final
     *
     * var -> makes variable read-write/mutable/non-final
     *
     *
     **/

    val num1: Int = 20
    val letter: Char = 'A'
    val name: String = "chandan"
    var age: Int = 30
    var price: Double = 10.3
    val large: Long = 1212121212

    val numbers = intArrayOf(1,2,3,4,5,6)

    val days = IntArray(4) /** declare an int array of size 4 */

    /** declaring an int array of size 4 and all elements initialized with 1990 */
    val years = IntArray(4) { i -> 1990 }

}