package org.adolf.kotlin.demo13

import kotlin.reflect.full.createInstance
import kotlin.reflect.full.memberFunctions

/**
 * 反射创建对象.
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */
class MyTestClass9(value: Int = 0) {

    fun printSomeThing(name: String) {
        println("someThing: $name")
    }

    fun printNothing() {
        println("nothing")
    }
}

fun main() {
    val kClass = MyTestClass9::class
    //通过反射创建对象
    val obj = kClass.createInstance()
    val kFunction = kClass.memberFunctions.find { it.name == "printNothing" }
    kFunction?.call(obj)
}

