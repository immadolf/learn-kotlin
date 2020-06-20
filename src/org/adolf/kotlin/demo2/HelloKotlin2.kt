package org.adolf.kotlin.demo2

/**
 * 密封类(sealed class)
 * 1. 密封类表示一种受限的结构，类似于枚举
 * 2. 密封类可以有子类，且子类可以有无数多个实例
 * 3. 密封类和子类必须定义在一个文件
 * 4. 密封类是抽象的，不允许有私有的构造方法
 *
 * @author adolf
 * @date 2020/6/20
 * @since
 */
sealed class Calculator

class Add : Calculator()

class Subtract : Calculator()

fun calculate(a: Int, b: Int, cal: Calculator) = when (cal) {
    is Add -> a + b
    is Subtract -> a - b
}

fun main() {
    println(calculate(1, 2, Add()))
    println(calculate(1, 2, Subtract()))
}