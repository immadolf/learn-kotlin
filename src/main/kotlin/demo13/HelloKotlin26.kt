package org.adolf.kotlin.demo13

import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter
import kotlin.reflect.jvm.javaSetter

/**
 *
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */
class MyTestClass14 {
    var name: String = "aaaa"

    val price = 1.0
}

var test2 = "test"

fun main() {
    val topProp = ::test2
    println(topProp.javaField)//private static java.lang.String org.adolf.kotlin.demo13.HelloKotlin26Kt.test2

    println(topProp.javaGetter)//public static final java.lang.String org.adolf.kotlin.demo13.HelloKotlin26Kt.getTest2()
    println(topProp.javaSetter)//public static final void org.adolf.kotlin.demo13.HelloKotlin26Kt.setTest2(java.lang.String)

    //注意没有static
    val n = MyTestClass14::name
    println(n.javaField)//private java.lang.String org.adolf.kotlin.demo13.MyTestClass14.name
    println(n.javaGetter)//public final java.lang.String org.adolf.kotlin.demo13.MyTestClass14.getName()
    println(n.javaSetter)//public final void org.adolf.kotlin.demo13.MyTestClass14.setName(java.lang.String)

    val n2 = MyTestClass14::price
    println(n2.javaField)//private final double org.adolf.kotlin.demo13.MyTestClass14.price
    println(n2.javaGetter)//public final double org.adolf.kotlin.demo13.MyTestClass14.getPrice()
    //println(n2.javaSetter) val属性没有setter方法
}