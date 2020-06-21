package org.adolf.kotlin.demo5

/**
 * 内联函数(inline function)
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */

inline fun myCalculate(a: Int, b: Int) = a + b

fun main() {
    println(myCalculate(1, 2))
}