package org.adolf.kotlin.demo5

/**
 * Kotlin内置函数的使用
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */

fun main() {
    val strings = arrayOf("hello", "world", "hellowor1D", "welcome")

    strings.filter { it.contains("h") }.forEach { println(it) }

    println("----------")

    strings.filter { it.endsWith("d", ignoreCase = true) }
        .map { it.toUpperCase() }
        .forEach { println(it) }
}