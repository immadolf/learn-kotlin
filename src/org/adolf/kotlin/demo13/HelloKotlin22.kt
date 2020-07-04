package org.adolf.kotlin.demo13

import kotlin.reflect.full.createInstance

/**
 * 反射调用有参数的构造方法.
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */
class MyTestClass10(val name: String) {
    var price = 0.0

    constructor() : this("aaa") {
        this.price = 1.0
    }

    constructor(name: String, price: Double) : this(name) {
        this.price = price
    }

    override fun toString(): String {
        return "name:$name,price:$price"
    }
}

fun main() {
    val kClass = MyTestClass10::class
    //createInstance调用的是无参的构造方法
    val obj = kClass.createInstance()
    println(obj)//name:aaa,price:1.0

    //name:bbb,price:2.0
    println(kClass.constructors.find { it.parameters.size == 2 }?.call("bbb", 2.0))
}