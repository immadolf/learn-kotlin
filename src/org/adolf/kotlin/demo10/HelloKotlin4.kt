package org.adolf.kotlin.demo10

/**
 * Kotlin调用Java时的异常
 *
 * @author 40313
 * @date 2020/6/29
 * @since
 */

fun main() {
    val myException = MyException()
    //println(myException.myMethod())//编译不会报错，运行时才报错

    println("------------------")

    println(myException::class) //kotlin 类型
    println(myException::class.java) //Java 类型
    println(myException.javaClass)//Java 类型 kotlin1.1之后才加入的方法
}