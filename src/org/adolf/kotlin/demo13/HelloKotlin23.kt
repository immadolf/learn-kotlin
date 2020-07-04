package org.adolf.kotlin.demo13

import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredFunctions

/**
 *
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */

open class Parent2 {
    fun method() {
        println("执行无参的方法")
    }
}

class MyTestClass11 : Parent2() {
    fun method(message: String) {
        println("执行带String参数的方法:$message")
    }

    fun method(message: String, price: Double) {
        println("执行带String,Double参数的方法:$message,$price")
    }
}

fun main() {
    val kClass = MyTestClass11::class
    val obj = kClass.createInstance()
    //获取**本类中**声明的函数
    val declaredFunctions = kClass.declaredFunctions
    //结果中不包含父类的方法
    //[fun org.adolf.kotlin.demo13.MyTestClass11.method(kotlin.String): kotlin.Unit, fun org.adolf.kotlin.demo13.MyTestClass11.method(kotlin.String, kotlin.Double): kotlin.Unit]
    println(declaredFunctions)

    //java.lang.IllegalArgumentException: Callable expects 2 arguments, but 3 were provided.
    //println(declaredFunctions.find { it.parameters.size == 2 }?.call(obj, "aaa", 1.0))

    //敲重点！！！
    //实例方法与构造方法不用，虽然定义了两个参数，但实际上有一个隐藏的参数是对象引用，因此要调用带两个2参数的method方法，实际上需要查找有3个参数的方法
    declaredFunctions.find { it.parameters.size == 3 }?.call(obj, "aaa", 1.0)//执行带String,Double参数的方法:aaa,1.0
}