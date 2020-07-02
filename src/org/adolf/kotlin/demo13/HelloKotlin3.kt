package org.adolf.kotlin.demo13

/**
 * 函数(方法)引用.
 * 支持重载，但是需要注意的是需要用圆括号而不是花括号.
 *
 * @author 40313
 * @date 2020/7/2
 * @since
 */

/**
 * 表示函数类型(Int) -> Int 的值
 */
fun multiplyBy3(x: Int): Int {
    return x * 3
}

val myReference: (Int) -> Int = ::multiplyBy3

/**
 * 表示函数类型(String) -> Int 的值
 */
fun multiplyBy3(s: String): Int {
    return 10
}

//当一个函数属于某个类时，他的类型如下，需要带上类名
val myReference2: String.(Int) -> Char = String::get

fun main() {
    val values = listOf(1, 2, 3)

    //函数(方法)引用
    println(values.map(::multiplyBy3))

    println("-----------------")

    val values2 = listOf("a", "b", "c")
    println(values2.map(::multiplyBy3))
}