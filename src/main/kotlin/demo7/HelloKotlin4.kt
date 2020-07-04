package org.adolf.kotlin.demo7

/**
 * range的常用操作
 *
 * @author 40313
 * @date 2020/6/23
 * @since
 */

fun main() {
    val i = 4

    if (i in 1..5) {
        println(i)
    }

    println("-------------")

    for (a in 1..4) {
        println(a)
    }

    for (a in 4 downTo 1) {
        println(a)
    }

    println("-------------")

    for (a in 1..4 step 2) {
        println(a)
    }

    for (a in 4 downTo 1 step 2) {
        println(a)
    }

    println("--------------")

    //左闭右开
    for (a in 1 until 4) {
        println(a)
    }
}