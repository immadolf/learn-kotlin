package org.adolf.kotlin.demo6

/**
 * 带接收者的函数字面值
 *
 * Kotlin提供了一种功能：可以通过指定的接收者对象来调用一个函数字面值
 * 在函数字面值内部，可以调用接收者对象的方法而无需使用任何额外的修饰符
 *
 * 类似于扩展函数
 *
 * @author 40313
 * @date 2020/6/22
 * @since
 */

fun main(args: Array<String>) {

    //带接收者类型的函数字面值，注意这里subtract的类型是一个函数字面值
    val subtract: Int.(other: Int) -> Int = { other -> this - other }

    println(1.subtract(3))

    println("-------------------")

    // 匿名函数用法可以让我们指定函数字面值的接收者类型。这样，我们就可以先去声明一个带有接收者的函数类型变量，然后再去使用它。
    // 带函数接收者的匿名函数，这里是把一个匿名函数赋值给sum
    val sum = fun Int.(other: Int): Int = this + other
    // 等同于  val sum = fun Int.(other: Int): Int { this + other }
    println(1.sum(2))

    println("-------------------")

    // 带有接收者类型的函数非字面值可以作为参数进行传递，前提是所需要接收函数的地方应该有一个接收者类型的参数，反之亦然
    // 比如：类型String.(Int) -> Boolean 等价于 (String,Int) -> Boolean
    val myEquals: String.(Int) -> Boolean = { param -> this.toIntOrNull() == param }

    println("456".myEquals(456))

    println("-------------------")

    fun myTest(op: (String, Int) -> Boolean, a: String, b: Int, c: Boolean) = println(op(a, b) == c)

    // String.(Int) -> Boolean 等价于 (String,Int) -> Boolean
    myTest(myEquals, "200", 200, true)
}