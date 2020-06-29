package org.adolf.kotlin.demo11

/**
 * Kotlin中的包级函数和包级属性会变成Java中的静态方法和静态变量(需通过getter/setter访问)
 *
 * @author 40313
 * @date 2020/6/29
 * @since
 */
class MyClass

fun test() {
    println("hello,world")
}

val str: String = "hello"