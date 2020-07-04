// package 可以与 目录名不一样
package org.adolf.kotlin.demo

fun main(args: Array<String>) {
    println(sum(1, 2))
    println(sum2(1, 2))

    myPrint(2, 3)
    myPrint2(2, 3)
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

// 无返回值函数，最后的Unit可以省略
fun myPrint(a: Int, b: Int): Unit {
    println(a + b)
}

//字符串模板
fun myPrint2(a: Int, b: Int): Unit {
    println("$a + $b = ${a + b}")
}