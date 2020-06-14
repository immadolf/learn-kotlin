package org.adolf.kotlin.demo

/**
 * if**表达式**
 *
 * @author adolf
 * @date 2020/6/14
 * @since
 */
fun main(args: Array<String>) {
    var x = 10
    var y = 20

    var max: Int
    var min: Int

    if (x > y) {
        max = x
        min = y
    } else {
        max = y
        min = x
    }

    println("max = $max, min = $min")

    // if 表达式，而不是语句
    max = if (x > y) x else y
    min = if (y > x) x else y
    println("max = $max, min = $min")
}