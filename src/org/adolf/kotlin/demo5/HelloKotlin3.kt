package org.adolf.kotlin.demo5

/**
 * 中缀符号 (infix notation)
 * 函数可以通过中缀符号形式来调用，需要满足如下3个条件：
 * 1. 是成员函数或扩展函数
 * 2. 拥有单个参数
 * 3. 声明时使用infix关键字
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */

class InfixTest(private var a: Int) {
    infix fun add(b: Int) = this.a + b
}

fun main(args: Array<String>) {
    val infixTest = InfixTest(2)

    // 以下两种方法等价
    println(infixTest.add(5))
    // 中缀形式
    println(infixTest add 5)
}