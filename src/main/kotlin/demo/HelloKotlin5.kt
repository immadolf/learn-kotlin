package org.adolf.kotlin.demo

/**
 * any以及智能转换
 *
 * @author adolf
 * @date 2020/6/14
 * @since
 */
fun main(args: Array<String>) {
    println(convert2Uppercase("hello world"))
    println(convert2Uppercase(23))
}

fun convert2Uppercase(x: Any): String? {
    return if (x is String) {
        // Smart cast
        x.toUpperCase()
    } else {
        null
    }
}