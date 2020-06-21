package org.adolf.kotlin.demo5

/**
 * 函数的定义
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */

fun myPrint(name: String) {
    println(name)
}

/**
 * 单表达式函数
 */
fun add(a: Int, b: Int) = a + b

/*
    一个方法中，只允许一个参数为vararg，通常作为最后一个参数。
    如果vararg不是最后一个参数，那么其后的参数就要通过具名参数的形式指定，
    如果其后的参数是函数类型，那么还可以通过在圆括号外传递lambda表达式来实现
 */

fun <T> conver2List(vararg elements: T): List<T> {
    val result = ArrayList<T>()

    elements.forEach { result.add(it) }

    return result
}

fun main() {
    println(conver2List("a", "b"))
    val arrays = arrayOf("a", "b")
    println(conver2List("1", "2", *arrays))
}