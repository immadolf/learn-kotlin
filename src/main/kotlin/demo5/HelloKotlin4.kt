package org.adolf.kotlin.demo5

/**
 * 内联函数(inline function)
 *
 * 扩展：crossinline,表示被标记的函数不允许使用非局部返回。
 * non-local returns 非局部返回，表示的是在一个方法内部，我们可以在其中通过一个lambda表达式的返回直接作为外层方法的返回值返回。
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */

inline fun myCalculate(a: Int, b: Int) = a + b

fun main() {
    println(myCalculate(1, 2))
}