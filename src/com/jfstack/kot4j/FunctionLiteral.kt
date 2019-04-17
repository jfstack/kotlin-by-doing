package com.jfstack.kot4j

/**
 *
 * Special form of function literal i.e. function literal with receiver
 *
 * example: A.(B) -> C
 *
 * Inside the body of the function literal, the receiver object becomes an
 * implicit "this".  The behavior is similar to extension function
 *
 *
 */

fun main(args: Array<String>) {

    /** example of function literal with receiver. plus is called on the receiver object */
    val sum: Int.(Int) -> Int = {other -> plus(other)}


    println(sum(1,2))
}