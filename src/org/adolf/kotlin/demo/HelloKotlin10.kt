package org.adolf.kotlin.demo

/**
 *
 * 原始字符串
 *
 * @author adolf
 * @date 2020/6/14
 * @since
 */

fun main(args: Array<String>) {
    var a = "hello \n world"
    println(a)

    var b = """hello
        \n world
    """.trimMargin()
    println(b)
}