package com.jfstack.kot4j


/**
 *
 * when we have a named function, we can easily call it directly.
 * But we can also use it as function type value e.g. pass it to other function.
 *
 * To do this, we use :: operator
 *
 * It's really powerful in defining function composition
 *
 */
fun main(args: Array<String>) {

    println(isOdd(5))

    val numbers = listOf<Int>(1,2,3,4,5,6)

    println(numbers.filter { isOdd(it) })

    println(numbers.filter ( ::isOdd ))

    val strings = listOf("a", "ab", "abc")
    println(strings.filter(oddLength))


    /** property reference */
    println(::title.get())
    ::title.set("Mrs")
    println(title)

    /** property reference to a member of a class */
    println(Person1::firstName)

    /**
     * property reference can be used where a function with one parameter
     * is expected
     */
    val initials = listOf("cg", "bg", "sg")
    println(initials.map ( String::length))

    /** Constructor reference */
    supplier(::Foo)

    /** class reference */
    val c = Foo::class
    println(c)
    println(Foo().javaClass)

}

var title = "Mr"

class Foo

fun supplier(factory: () -> Foo){
    val obj = factory()
    println(obj)
}

/**
 * Function composition:
 *
 * compose(f, g) = g(f(*))
 *
 */
fun <A, B, C> compose(
        f: (A) -> B,
        g: (B) -> C): (A) -> C {

    return { x -> g(f(x)) }
}

fun isOdd(x: Int) = x%2 != 0

fun length(s: String) = s.length

val oddLength = compose(::length, ::isOdd) //oddLength is a composed function