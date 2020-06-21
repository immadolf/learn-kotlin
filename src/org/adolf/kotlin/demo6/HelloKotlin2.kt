package org.adolf.kotlin.demo6

/**
 * 匿名函数
 *
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */

fun main(args: Array<String>) {
    fun(x: Int, y: Int) = x + y

    fun(x: Int, y: Int): Int {
        return x + y
    }

    val strings = arrayOf("hello", "world", "bye")

    strings.filter(fun(item): Boolean = item.length > 3)
        .forEach(fun(item) { println(item) })
}