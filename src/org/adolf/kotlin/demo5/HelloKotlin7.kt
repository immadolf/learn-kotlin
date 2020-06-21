package org.adolf.kotlin.demo5

/**
 * 扩展方法与高阶函数
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */
fun String.filter(predicate: (Char) -> Boolean): String {
    val result = StringBuilder()
    this.toCharArray().forEach {
        if (predicate(it)) {
            result.append(it)
        }
    }
    return result.toString()
}

fun main(args: Array<String>) {
    println("abc123".filter { it.isDigit() })
}