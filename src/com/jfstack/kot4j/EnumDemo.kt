package com.jfstack.kot4j

/**
 * Definition of an Enum
 * two keywords are being used "enum" + "class"
 */
enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255,0,0),
    YELLOW(255,255,0),
    BLUE(0,0,255),
    WHITE(0,0,0);

    fun rgb() = (r*255 + g) + 255 + b
}

/**
 * when expression should be exhaustive meaning expression
 * should cover all branches otherwise need else
 */
fun getMnemonic(color: Color) =
        when(color) {
            Color.RED -> "Rose"
            Color.YELLOW -> "York"
            Color.BLUE -> "Battle"
            else -> "invalid color"
        }

fun main(args: Array<String>) {
    println(Color.BLUE.rgb())
    println(getMnemonic(Color.BLUE))
}