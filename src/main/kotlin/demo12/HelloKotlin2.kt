package org.adolf.kotlin.demo12

/**
 *
 *
 * @author 40313
 * @date 2020/6/30
 * @since
 */
class MyClass {

    val a: Int
        @JvmName("getAValue")
        get() = 20

    fun getA() = 30
}

fun main() {
    val myClass = MyClass()

    println(myClass.a)
    println(myClass.getA())
}