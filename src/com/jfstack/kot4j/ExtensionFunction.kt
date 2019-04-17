package com.jfstack.kot4j

import java.lang.StringBuilder

/**
 * Notes from https://kotlinlang.org
 *
 * Kotlin, similar to C# and Gosu, provides the ability to extend a class
 * with new functionality without having to inherit from the class or use
 * any type of design pattern such as Decorator. This is done via special
 * declarations called extensions.
 *
 * Kotlin supports extension functions and extension properties.
 *
 *
 */

fun main(args: Array<String>) {
    val key = "a1  b e g"
    println(removeWhiteSpace(key))

    println(key.removeWhiteSpaceExt())

    printShowOff(View())

    printShowOff(Button())
}

/** normal top-level function */
fun removeWhiteSpace(str: String): String {
    val regex = Regex("\\s+")
    return regex.replace(str, "-")
}

/**
 * To write an extension function, we need to prefix
 * its name with a receiver type, i.e. the type being extended. E.g. here
 * Receiver type = String
 * Receiver object = this
 */
fun String.removeWhiteSpaceExt(): String {
    val regex = Regex("\\s+")
    return regex.replace(this, "#")
}

/**
 * Receiver object member can be accessed without 'this'
 * keyword as if it's defined in the receiver type. Perfectly
 * legal to call another extension function
 */
fun String.lastChar(): Char {
    return this.removeWhiteSpaceExt().get(length -1)
}

/**
 * An extension function to join all elements of a collection into a string.
 * Receiver type is generic type
 */
fun <T> Collection<T>.joiningToString(delimiter: String = ",",
                    prefix: String = "",
                    suffix: String = ""): String {
    val sb = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {

        if(index > 0) sb.append(delimiter)

        sb.append(element)
    }

    sb.append(suffix)

    return sb.toString()
}

/**
 * more specific type as receiver type
 */
fun Collection<String>.join(delimiter: String,
                            prefix: String,
                            suffix: String) = joinToString(delimiter,prefix,suffix)

/**
 *
 * Extensions are resolved statically
 * Extensions do not actually modify classes they extend. By defining an extension,
 * you do not insert new members into a class, but merely make new functions callable
 * with the dot-notation on variables of this type.
 *
 * Extension functions are dispatched statically, i.e. they are not virtual by receiver type.
 * This means that the extension function being called is determined by the type of the expression
 * on which the function is invoked, not by the type of the result of evaluating that expression
 * at runtime.
 *
 * For example: Button is a derived class of View, showOff extension function defined on both class
 * They don't override each other. They will be called based on the type of the variable
 */

fun View.showOff() = println("It's a view")
fun Button.showOff() = println("It's a view")
fun printShowOff(view: View) {
    view.showOff() // will print "It's a view"
}

/**
 * Member function with same parameters as with extension function - this case member will win
 * However, if they are overloaded, then appropriate function will be called based on arguments match
 *
 *
 */

fun test() {

}