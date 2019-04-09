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

/**
 * By default all classes declared in Kotlin is FINAL
 * In order to make a class extensible, prefix it with OPEN and
 * all methods or properties should also be prefixed with OPEN
 *
 */
open class View {
    open fun click() = println("view clicked") // defined function as expression
}

/**
 * Following is the language syntax of extending a super class
 * Primary constructor of the super class must be called in the same line
 *
 * To override any base class function or property definition, they need to be
 * prefixed with OVERRIDE keyword
 */
class Button : View() {
    override fun click() {
        println("button clicked")
    }
}

/** Syntax to declare a private constructor. CONSTRUCTOR keyword is mandatory */
class ClassWithPrivateConstructor private constructor(val a: String) {

}


/**
 * Data class in Kotlin gets following things free
 * - The specified fields
 * - getter/setters
 * - parameterized constructor
 * - hashCode implementation
 * - equals implementation
 * - toString
 * - clone
 *
 * You cannot use inheritance when writing data class. Data class
 * cannot extend any base class and are final (you cannot use OPEN keyword)
 *
 */
data class DataClassDemo(val p1: Int, val p2: Int)