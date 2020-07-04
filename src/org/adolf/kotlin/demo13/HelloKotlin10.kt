package org.adolf.kotlin.demo13

/**
 * 引用特定对象的实例方法.
 * 引用特点对象的属性.
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */

fun main() {
    val str = "abc"
    val getReference = str::get
    println(getReference(1)) //b

    println("---------------")

    val myProp = "test"::length
    println(myProp.get())//4

    println("----------------")

    val myProp2 = String::length
    println(myProp2.get("test"))//4
}