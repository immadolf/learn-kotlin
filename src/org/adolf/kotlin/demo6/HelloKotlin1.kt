package org.adolf.kotlin.demo6

/**
 * lambda表达式的返回值
 * 1. 默认情况下，lambda表达式中最后一个表达式的值会隐式作为该lambda表达式的返回值
 * 我们可以通过全限定的return语法来显式从lambda表达式返回结果
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */

fun main() {
    val strings = arrayOf("hello", "world", "bye")

    strings.filter {
        val result = it.length > 3
        result
    }

    strings.filter {
        val result = it.length > 3
        return@filter result
    }

    strings.filter { it.length > 3 }
}