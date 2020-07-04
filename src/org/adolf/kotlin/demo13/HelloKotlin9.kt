package org.adolf.kotlin.demo13

/**
 * 构造方法引用(Constructor Reference)
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */
class B(val x: Int)

fun myMethod(factory: (x: Int) -> B) {
    val b: B = factory(3)
    println(b.x)
}

fun main() {
    //当一个函数的参数是一个函数，且这个函数的签名和某个类的构造方法签名一致时
    //就可以使用构造方法引用，使用形式是::类名
    myMethod(::B)
}