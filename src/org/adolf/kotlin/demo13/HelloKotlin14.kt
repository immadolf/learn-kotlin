package org.adolf.kotlin.demo13

import kotlin.reflect.full.memberProperties

/**
 * 反射获取kotlin属性.
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */
class MyTestClass2(var a: String, val flag: Boolean, var age: Int) {

}

fun main() {
    val kClass = MyTestClass2::class
    //[var org.adolf.kotlin.demo13.MyTestClass2.a: kotlin.String, var org.adolf.kotlin.demo13.MyTestClass2.age: kotlin.Int, val org.adolf.kotlin.demo13.MyTestClass2.flag: kotlin.Boolean]
    println(kClass.memberProperties)
    //除了属性，还会返回函数
    println(kClass.members)
}