package org.adolf.kotlin.demo5

import java.sql.SQLOutput

/**
 * 函数的默认参数 default arguments
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */

fun test(a: Int = 0, b: Int = 1) = println(a - b)

fun main(args: Array<String>) {
    test()
    test(2)
    test(b = 2)
    test(3, 2)
    println("-------------")

    println(A().method(a = 4))
    println(B().method(a = 4))

    println("-------------")

    test2(b = 3) //具名参数 named argument

    println("-------------")

    test3(2, 3, ::test)
    test3(2, 3, { a, b -> println(a - b) })
    test3(2, 3) { a, b -> println(a - b) }

    test3(2) { a, b ->
        println(a - b)
    }
    test3 { a, b ->
        println(a - b)
    }

    println("-------------")

    test4(1, 2, 3, 4)
    test4(a = 1, b = 2, c = 3, d = 4)
    test4(a = 1, d = 5)

    test5(1, b = 2)
    //test5(b = 2, 1) 编译错误

    test6("a", "b")
    //test6(arrayOf("a", "b")) 编译错误
    //spread operator分散运算符，使得数组可以作为可变参数函数的参数
    test6(*arrayOf("a", "b"))

    //在kotlin中调用java方法时，不能使用具名参数的形式，因为java编译的时候并不总是保留参数名
}

/*
    对于重写的方法来说，子类所拥有的重写方法会使用与父类相同的默认参数值。
    在重写一个拥有默认参数值的方法时，方法签名中必须要将默认参数值省略掉
 */
open class A {
    open fun method(a: Int, b: Int = 4) = a + b
}

class B : A() {
    override fun method(a: Int, b: Int): Int {
        return super.method(a, b)
    }
}

/**
 * 如果一个默认参数位于其他无默认值的参数前面，那么默认值只能通过在调用函数时使用具名参数的方式来使用
 */
fun test2(a: Int = 1, b: Int) = println(a - b)

/**
 * 如果函数的最后一个参数是lambda表达式，而且调用时位于圆括号之外，那么就可以不指定lambda表达式的具名参数名
 */
fun test3(a: Int = 1, b: Int = 2, compute: (x: Int, y: Int) -> Unit) {
    compute(a, b)
}

/**
 * 具名参数，在调用函数时，函数参数可以是具名的
 * 当一个函数有大量参数或是一些参数拥有默认值时，这种调用方式是比较方便的
 */
fun test4(a: Int, b: Int = 2, c: Int = 3, d: Int) = println(a + b + c + d)

/**
 * 在调用函数时，如果同时使用了位置参数和具名参数，那么所有的位置参数都必须要位于第一个具名参数之前
 */
fun test5(a: Int, b: Int = 2) {

}

/**
 * 可变参数
 */
fun test6(vararg strings: String) {
    println(strings.javaClass) // strings的java类型是数组
    strings.forEach { println(it) }
}

