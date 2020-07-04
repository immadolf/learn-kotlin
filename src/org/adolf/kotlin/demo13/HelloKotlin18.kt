package org.adolf.kotlin.demo13

import kotlin.reflect.full.memberProperties

/**
 * 反射调用属性.
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */

class MyTestClass6 {
    var name: String = "hello world"
}

fun main() {
    val kClass = MyTestClass6::class
    val obj = MyTestClass6()

    val variable = kClass.memberProperties.find { it.name == "name" }
    println(variable?.get(obj))//hello world
    println(variable?.call(obj))//hello world
}