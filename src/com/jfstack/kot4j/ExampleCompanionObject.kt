package com.jfstack.kot4j

fun main(args: Array<String>) {

    var myList = MyList.of(1,2,3,4,5)

    for (i in 0..myList.size - 1)
        println("value at $i index is ${myList[i]}")

    /** IntelliJ suggests that rangeTo function or .. operator should be replaced by until function */
    for (i in 0 until myList.size)
        println("value at $i index is ${myList[i]}")


    PageRepository.get()
    val page by PageRepository.lazyGet()

    /**
     * Creating a mock object for test
     *
     * In Kotlin we can create an anonymous class like below
     * by implementing an interface or extending a class
     *
     */
    PageRepository.mocked = object : PageRepository {
        override fun getPage(): Page {
            TODO("not implemented")
        }
    }
}

/**
 * Kotlin doesn't allow static methods.
 * Analogue to Java static methods, it's commonly called
 * companion factory method.
 *
 * Under the hood companion object is actually a singleton object.
 * companion object can extend other classes
 *
 */

class MyList {
    companion object {

        fun of(vararg elements: Int): MutableList<Int> { /** factory method using companion object */
            return elements.asList().toMutableList()
        }
    }
}

class Page

abstract class Provider<T> {
    var original: T? = null
    var mocked: T? = null

    abstract fun create(): T

    fun get(): T = mocked ?: original ?: create().apply { original = this }

    fun lazyGet(): Lazy<T> = lazy { get() }
}

interface PageRepository {
    fun getPage(): Page

    companion object : Provider<PageRepository> () {
        override fun create(): PageRepository {
            TODO("not implemented")
        }
    }
}



