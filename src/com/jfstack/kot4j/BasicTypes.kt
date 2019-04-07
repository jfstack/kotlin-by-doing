package com.jfstack.kot4j

fun main(args: Array<String>) {

    /**
     * val -> makes variable read-only/immutable/final
     *
     * var -> makes variable read-write/mutable/non-final
     *
     *
     **/

    val any: Any /** Any is super type of all types in Kotlin like Object in java */
    val nothing: Nothing /** Nothing is subclass of all types in Kotlin */

    /**
     * Nothing has no instance. We can use Nothing to represent "a value that never exists"
     * For example, if a function has a return type as Nothing, it means that it never returns
     * (always throw exception)
     */
    fun alwaysThrowException(): Nothing {
        throw IllegalArgumentException()
    }

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

    /**
     * Since Void is a non-instantiable final class in Java, we can only return null
     * from such a function
     */
    fun voidReturnType(): Void? {
        return null
    }

}