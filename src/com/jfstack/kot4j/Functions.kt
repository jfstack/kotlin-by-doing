package com.jfstack.kot4j

import java.lang.IllegalArgumentException
import java.net.ServerSocket
import java.net.Socket

/**
 * Kotlin has following function scopes
 * top-level function
 * member
 * local
 * extension
 *
 */

fun main(args: Array<String>) {

    println(average())
    println(average(1,2,3))

    val numbers = intArrayOf(1,2,3,4,5,6,7)
    println(average(*numbers))

    log("Hello there", "INFO", true)
    log("Hello there", flag = true, level = "INFO") //named param function

    println("Server is running")
    runServer(ServerSocket(4000))
}

fun average(vararg numbers: Int): Float {
    /** require() function is from kotlin std library */
//    require(numbers.size < 2) { "size is less than 2"}

    /** custom function */
    checkParams(numbers.size < 2) { "size is less than 2"}

    var sum = 0F

    for (n in numbers) {
        sum += n
    }

    return sum/numbers.size

}

fun log(msg: String, level: String, flag: Boolean) {

    /** use of string interpolation */
    if (flag)
        println("$level : $msg")
}


fun checkParams(value: Boolean, lazyMessage: () -> Any) {
    if (value) {
        val message = lazyMessage()
        IllegalArgumentException(message.toString())
    }
}

fun runServer(serverSocket: ServerSocket): Nothing {
    while (true) {
        handleSocket(serverSocket.accept())
    }
}
fun handleSocket(socket: Socket) {
    TODO("Not implemented")
}