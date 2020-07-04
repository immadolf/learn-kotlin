package org.adolf.kotlin.demo

/**
 * 数组的用法
 *
 * @author adolf
 * @date 2020/6/14
 * @since
 */
fun main(args: Array<String>) {
    var array = intArrayOf(1, 2, 3, 4, 5)

    for (item in array) {
        println(item)
    }

    println("-------------")

    for (index in array.indices) {
        println("array[$index] = ${array[index]}")
    }

    println("-------------")

    for ((index, value) in array.withIndex()) {
        println("array[$index] = $value")
    }
}