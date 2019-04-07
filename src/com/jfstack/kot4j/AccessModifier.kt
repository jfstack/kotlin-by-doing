package com.jfstack.kot4j

/**
 *
 * Kotlin has following 4 access modifiers
 *
 * private
 *  -> Private Modifiers do not allow the declarations to be visible outside the current scope
 *
 * protected
 *  -> visible to subclass only
 *  -> CANNOT be set on top-level declarations.
 *  -> Declarations that are protected in a class, can be accessed only in their subclasses
 *  -> Declarations that are protected, when overridden would have the same protected modifier in the subclass unless you explicitly change them.
 *
 * internal
 *  -> visible to all classes and functions in the current module
 *  -> By module in Kotlin, we mean a group of files that are compiled together.
 *  -> Internal Modifiers is useful when you need to hide specific library implementations from the users.
 *  -> This was not possible using the package-private visibility in Java
 *
 * public
 *  -> visible to all classes and functions to all modules
 *
 * default is public
 *
 * Java's default modifier is package-private which doesn't exist in Kotlin
 *
 */
fun main(args: Array<String>) {

}

/**
 * Since Kotlin allow multiple top-level definition, below code is compiled.
 * But if someVariable is defined in some different scope, then will not work
 */
class AnotherPrClass {
    private var someVariable1: String = "somevalue"
}
private var someVariable: String = "somevalue"
private class PrivateClass {
    fun print() {
        someVariable = "newvalue"
//        someVariable1 = "someothervalue" // compiler error
    }
}

/**
 * If I declare a class internal, it's visible to the current module
 */
internal class InternalClass

/**
 * floowing two classes are public and you can see that IntelliJ is suggesting
 * that the public access modifier isn't required
 */
class PublicClassA
public class PublicClassB