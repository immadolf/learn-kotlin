package org.adolf.kotlin.demo4

import kotlin.reflect.KProperty

/**
 * 委托(delegation)
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */

// 属性委托(delegation property)
/*
    有4种情况在实际开发中比较有用：
    1. 延迟属性
    2. 可观测属性
    3. 非空属性
    4. map属性
 */
class MyPropertyClass {
    var str: String by MyDelegation()
}

class MyDelegation {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, your delegated property name is ${property.name}"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$thisRef, new value is $value")
    }

}

fun main(args: Array<String>) {
    val myPropertyClass = MyPropertyClass()
    myPropertyClass.str = "hello world"
    println(myPropertyClass.str)
}
