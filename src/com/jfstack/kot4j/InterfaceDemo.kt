package com.jfstack.kot4j

fun main(args: Array<String>) {
    println(MyInterface.MY_CONSTANT) // accessing companion object members just like static
}


interface MyInterface {
    /** abstract property */
    val prop: Int

    /** property with accessor implementation */
    val propertyWithImpl: String
        get() = "something"

    /** abstract method */
    fun bar()

    /** default method implementation */
    fun foo() {
        println("default method in interface")
    }

    /** companion object is something like static in Java */
    companion object {
        const val MY_CONSTANT = "CONSTANT"
    }
}

/**
 * Here Child class is implementing the abstract property from MyInterface
 * as constructor parameter. OVERRIDE keyword must be used to implement abstract
 * members from of an interface. Otherwise, class must be prefixed with ABSTRACT
 */
class Child(override val prop: Int) : MyInterface {
    override fun bar() {
        TODO("not implemented")
    }

}

abstract class AnotherChild : MyInterface {

}


interface Named {
    val name: String
}

interface Person1 : Named {
    val firstName: String
    val lastName: String
    override val name: String
        get() = "$firstName $lastName"
}

class Employee(override val firstName: String,
               override val lastName: String) : Person1