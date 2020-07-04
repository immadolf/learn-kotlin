package org.adolf.kotlin.demo13

import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties

/**
 * 反射设置属性.
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */
class MyTestClass7 {
    var name: String = "hello world"
    var authorName = "adolf"
}

fun main() {
    val kClass = MyTestClass7::class
    val obj = MyTestClass7()

    val variable = kClass.memberProperties.find { it.name == "name" }

    if (variable is KMutableProperty<*>) {
        variable.setter.call(obj, "aabbcc")
        println(variable.get(obj)) //aabbcc
    }
}