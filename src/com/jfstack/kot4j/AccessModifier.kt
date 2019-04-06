package com.jfstack.kot4j

/**
 *
 * Kotlin has following 4 access modifiers
 *
 * private      -> internal to class
 * protected    -> visible to subclass only
 * internal     -> visible to all classes and functions in the current module
 * public       -> visible to all classes and functions to all modules
 *
 * default is public
 *
 */
fun main(args: Array<String>) {

}

/**
 * If I declare a class private, it's visible only to this kotlin file
 */
private class PrivateClass

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