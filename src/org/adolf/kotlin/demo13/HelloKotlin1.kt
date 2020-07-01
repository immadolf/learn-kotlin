package org.adolf.kotlin.demo13

/**
 * Kotlin反射 -- KClass
 *
 * @author 40313
 * @date 2020/7/1
 * @since
 */

fun main() {
    val a = String::class
    println(a) //class kotlin.String

    println("-------------")

    val a2 = String::class.java
    println(a2) //class java.lang.String
}