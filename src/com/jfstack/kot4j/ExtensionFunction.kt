package com.jfstack.kot4j

import java.lang.StringBuilder

fun main(args: Array<String>) {
    val key = "a1  b e g"
    println(removeWhiteSpace(key))

    println(key.removeWhiteSpaceExt())
}

/** normal top-level function */
fun removeWhiteSpace(str: String): String {
    val regex = Regex("\\s+")
    return regex.replace(str, "-")
}

/**
 * To write an extension function
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

