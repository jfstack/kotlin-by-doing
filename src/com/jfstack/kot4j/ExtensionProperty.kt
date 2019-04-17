package com.jfstack.kot4j

fun main(args: Array<String>) {
    val name = "Chandan"
    println(name.lastChar)

    val names = mutableListOf<String>("a", "b", "c")
    println(names.lastIndex)
}

/**
 * No backing field for extension property
 * No initializer allowed
 * Behavior can only be provided by getter/setter
 *
 */
val String.lastChar: Char
   get() = get(length -1)

val <T> List<T>.lastIndex: Int
    get() = size -1

//val String.lastChar = get(length -1) // initializer not allowed