package org.adolf.kotlin.demo5

/**
 * 高阶函数 high-order function
 *
 * 接收函数为参数或返回函数为结果值的函数被称为高阶函数
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */
fun myCalculate(a: Int, b: Int, operator: (Int, Int) -> Int): Int {
    return operator(a, b)
}

fun main() {
    println(myCalculate(1, 2) { a, b -> a + b })
    println(myCalculate(1, 2) { a, b -> a - b })
    println(myCalculate(1, 2) { a, b -> a * b })
    println(myCalculate(1, 2) { a, b -> a / b })
}