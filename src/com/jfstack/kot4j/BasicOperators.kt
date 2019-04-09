package com.jfstack.kot4j

fun main(args: Array<String>) {

    /**
     * Not-null assertion Operator (!!) converts any value to a non-null type
     * and throw an exception (kotlin.KotlinNullPointerException) if the value is null
     */
    val text: String? = null //? makes a type nullable meaning variable of this type can hold null
    val text2: String = "abcd"
    val length = text2!!.length
    println(length)

    /**
     * == or != structural equality
     * === or !== referential equality
     */
    data class Gbs(val v1: Int, val v2: String)
    val str1 = Gbs(1, "chandan")
    val str2 = Gbs(1, "chandan")

    println(str1 == str2)   //both objects are structurally identical
    println(str1 === str2)  // both variables are pointing to two different object

    /**
     * Safe call (?.) operator
     *
     * Elvis (?:) operator - In general Elvis operator is a binary operator that returns its
     * first operand if that operand is true, otherwise evaluates and returns its second operand.
     * It's a variant of the ternary conditional operator (? :) with its second operand omitted.
     * In Kotlin, instead of first operand having to result in a boolean, it must result in an object
     * reference. If the reference is not NULL, it's returned. Otherwise the value of the second operand
     * (which can be NULL also) is returned.
     *
     * Spread (*) operator - (prefix an array with *) required to pass an array to vararg parameter
     *
     * Named function (::) useful to pass an function reference as argument to other function
     *
     * Smart cast (is) operator is used to check if an object is of a particular type. If an
     * object passes a type check then it can be used as that type without explicitly casting it.
     */

    val name: String? = null
    val value: String? = "11311"
    println( name ?: "Name is null")
    println( value ?: "Value is null")

    /**
     * Creating custom operator by overloading the built-in kotlin operator and using
     * OPERATOR keyword. Below is an example
     */
    data class SomeClass(var savedValue: Int = 0)

    // instance += valueToAdd
    operator fun SomeClass.plusAssign(valueToAdd: Int) {
        this.savedValue += valueToAdd
    }

    // instance()
    operator fun SomeClass.invoke() {
        println("instace invoked by invoker")
    }

}