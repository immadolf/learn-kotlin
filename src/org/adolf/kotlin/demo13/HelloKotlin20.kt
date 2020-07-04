package org.adolf.kotlin.demo13

import kotlin.reflect.full.companionObject

/**
 * 反射获取伴生对象.
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */
class MyTestClass8 {
    companion object {
        fun method() {
            println("aaa")
        }
    }
}

fun main() {
    val kClass = MyTestClass8::class
    val companionObject = kClass.companionObject
    println(companionObject)//class org.adolf.kotlin.demo13.MyTestClass8$Companion
}