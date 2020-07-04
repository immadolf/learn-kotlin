package org.adolf.kotlin.demo13

/**
 * 反射获取构造方法.
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */
class MyTestClass4(value: Int) {
    constructor(amount: Int, color: String) : this(amount) {
        println("secondary constructor")
    }
}

fun main() {
    val kClass = MyTestClass4::class
    //[fun <init>(kotlin.Int, kotlin.String): org.adolf.kotlin.demo13.MyTestClass4, fun <init>(kotlin.Int): org.adolf.kotlin.demo13.MyTestClass4]
    println(kClass.constructors)
}