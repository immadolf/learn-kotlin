package org.adolf.kotlin.demo8

/**
 * Kotlin中的throw
 *
 * throw在Kotlin中是个表达式，可以作为elvis表达式的一部分
 *
 * @author 40313
 * @date 2020/6/23
 * @since
 */

fun main() {
    val str: String? = "a"
    //throw表达式的类型是Nothing，表示永远不会触达的代码
    //在自己的代码中，可以用Nothing表示永远不会返回的函数，如在函数中抛出了异常
    val str2 = str ?: throw  IllegalArgumentException("值不能为空")
    println(str2)

    println("----------------")

    val str3 = str ?: myMethod()
    println(str3)

    println("----------------")

    //Nothing? 只可能表示null
    val a = null //这里a的类型就是Nothing?,因为编译器无法确定具体类型，只知道可能为null
    println(a is Nothing?) // true

    val a2 = listOf(null)
    println(a2 is List<Nothing?>) // true
}

fun myMethod(): Nothing = throw IllegalArgumentException()
