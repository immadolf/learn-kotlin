package org.adolf.kotlin.demo13

import kotlin.reflect.full.memberFunctions

/**
 * 反射调用函数.
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */

class MyTestClass5 {
    fun printSomeThing(name: String) {
        println("someThing: $name")
    }

    fun printNothing() {
        println("nothing")
    }
}

fun main() {
    val kClass = MyTestClass5::class
    val obj = MyTestClass5()

    val kFunction = kClass.memberFunctions.find { it.name == "printNothing" }
    kFunction?.call(obj) //nothing

    println("--------")

    val kFunction2 = kClass.memberFunctions.find { it.name == "printSomeThing" }
    kFunction2?.call(obj, "abc") //someThing: abc
}