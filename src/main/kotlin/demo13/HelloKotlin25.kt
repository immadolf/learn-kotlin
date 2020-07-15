package org.adolf.kotlin.demo13

import kotlin.reflect.full.createInstance

/**
 * 反射操作顶层属性.
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */
class MyTestClass13 {
    var name: String = "aaaa"
}

var test = "test"

fun main() {
    val topProp = ::test
    topProp.set("test@@@@@@@@@@")

    println(topProp.get())//test@@@@@@@@@@
    println(test)//test@@@@@@@@@@

    println("--------------------")

    //属性引用与反射
    val kClass = MyTestClass13::class
    val name = MyTestClass13::name
    name.set(kClass.createInstance(), "abcdefg")
}