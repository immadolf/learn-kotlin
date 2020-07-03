package org.adolf.kotlin.demo5

/**
 * Kotlin内置函数的使用
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */

fun main() {
    val strings = arrayOf("hello", "world", "hellowor1D", "welcome")

    strings.filter { it.contains("h") }.forEach { println(it) }

    println("----------")

    strings.filter { it.endsWith("d", ignoreCase = true) }
        .map { it.toUpperCase() }
        .forEach { println(it) }

    println("-----------")
    //内置函数let和run
    //let函数和run函数都有返回值，且返回值由闭包中的函数决定
    //区别在于let函数有一个参数，可以通过这个参数来访问调用者对象，而run函数没有参数，需要通过this关键字来访问调用者对象.
    val stringLength = "abc".let { s: String -> s.length }
    val stringLength2 = "abc".run { this.length }

    println("------------")

    //内置函数apply和also
    //这两个函数的都只能接收无返回值的函数作为参数，并且这两个函数的返回值是调用者自身，因此可以链式使用这两个函数
    //区别在于also函数有一个参数，可以通过这个参数来访问调用者对象，而apply函数没有参数，需要通过this关键字来访问调用者对象.
    "abc".apply { println(this.length) }
        .also { s: String -> println(s.length) }

    println("------------")

    //内置函数takeIf和takeUnless
    //这两个函数的返回值都是可空类型
    //takeIf是当对象满足条件时返回对象，不满足时返回null
    //takeUnless恰好相反，是当对象不满足条件时返回对象，满足时返回null
    //这两个函数其实就是if (...) else {...} 的缩写
    val takeIf: String? = "abc".takeIf { s: String -> s.length > 1 }
    val takeUnless: String? = "abc".takeUnless { s: String -> s.length < 1 }
}