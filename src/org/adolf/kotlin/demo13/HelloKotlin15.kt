package org.adolf.kotlin.demo13

import kotlin.reflect.full.memberFunctions

/**
 * 反射获取kotlin方法.
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */

class MyTestClass3 {

    fun printSomeThing() {
        println("hello")
    }

    fun add(a: Int, b: Int): Int {
        return a + b
    }

}

fun main() {
    val kClass = MyTestClass3::class
    //[fun org.adolf.kotlin.demo13.MyTestClass3.add(kotlin.Int, kotlin.Int): kotlin.Int, fun org.adolf.kotlin.demo13.MyTestClass3.printSomeThing(): kotlin.Unit, fun org.adolf.kotlin.demo13.MyTestClass3.equals(kotlin.Any?): kotlin.Boolean, fun org.adolf.kotlin.demo13.MyTestClass3.hashCode(): kotlin.Int, fun org.adolf.kotlin.demo13.MyTestClass3.toString(): kotlin.String]
    println(kClass.memberFunctions)
}