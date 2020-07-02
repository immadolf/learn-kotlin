package org.adolf.kotlin.demo13

/**
 * 函数组合.
 *
 * @author 40313
 * @date 2020/7/2
 * @since
 */

fun <A, B, C> myCompose(f: (B) -> C, g: (A) -> (B)): (A) -> (C) {
    return { x -> f(g(x)) }
}

fun isEven(x: Int) = 0 == x % 2

fun length(s: String) = s.length

fun main() {
    val myCompose = myCompose(::isEven, ::length)
    val values = listOf("a", "b", "c", "ab", "abc", "abcd")
    println(values.filter(myCompose))//[ab, abcd]

}