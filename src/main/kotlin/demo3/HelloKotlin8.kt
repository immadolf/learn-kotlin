package org.adolf.kotlin.demo3

/**
 * 类似于Java的匿名内部类，Kotlin对象表达式中的代码是可以访问到外层的变量
 *
 * 与Java不同的是，Kotlin可以修改外层的变量
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */

fun main() {
    var i = 100

    val myObject = object {
        fun myMethod() {
            i++
        }
    }
    println(i)
    myObject.myMethod()
    println(i)
}