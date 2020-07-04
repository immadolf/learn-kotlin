package org.adolf.kotlin.demo6

/**
 * 闭包
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */
fun main() {
    var sum = ""

    val strings = arrayOf("hello", "world", "bye")

    strings.filter { it.length > 3 }.forEach {
        // 在lambda/匿名函数中可以访问到外层变量的值
        // 特别的是在kotlin中可以对外层变量进行修改，而java不行
        sum += it
    }
}