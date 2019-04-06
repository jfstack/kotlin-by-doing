package com.jfstack.kot4j

fun main(args: Array<String>) {

}

/**
 * From https://kotlinlang.org
 *
 * NOTE: on the JVM, if all of the parameter of primary constructor
 * have default values, the compiler will generate an additional
 * parameter-less constructor which will use the default values. This
 * makes it easy to use Kotin with libraries such as jackson or JPA
 * that creates class instances through parameter-less constructor
 */
private class Customer(val login: String = "",
                       val name: String = "")

/**
 * This is verbose declaration of a class. Kotlin has concise syntax for that
 */
private class Person constructor(_fname:String, _lname:String) {
    val firstName = _fname
    val lastName = _lname
}

/**
 * Concise syntax
 * use var for mutable properties
 * val for immutable properties
 */
private class User(val firstName: String, val lastName: String)


/**
 * primary constructor is declared in the same line of class declaration
 *
 * class can have only one primary constructor
 *
 * but can have multiple secondary constructors
 *
 * secondary constructor must call to primary constructor with the required parameters
 */
private class Car(val engineType: String) { // primary constructor
    var wheel: Int = 0
    var isGasolin: Boolean = false

    constructor(_engineType: String, _wheels: Int) : this(_engineType) { // secondary constructor
        this.wheel = _wheels
    }

    constructor(_engineType: String, _wheels: Int, _isGasolin: Boolean) : this(_engineType) { // secondary constructor
        this.wheel = _wheels
        this.isGasolin = _isGasolin
    }
}