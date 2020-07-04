package org.adolf.kotlin.demo8

import java.lang.Integer.parseInt

/**
 * 异常
 * Kotlin中的try是个表达式，返回值是try中或catch中最后一条语句的结果
 *
 * Kotlin中没有checked exception
 *
 * @author 40313
 * @date 2020/6/23
 * @since
 */
fun main() {
    val a = "3"
    val result: Int? = try {
        parseInt(a)
    } catch (ex: NumberFormatException) {
        null
    } finally {
        println("finally invoked")
    }

    println(result)
}