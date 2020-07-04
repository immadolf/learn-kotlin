package org.adolf.kotlin.demo7

/**
 * 集合的扩展方法
 *
 * @author 40313
 * @date 2020/6/23
 * @since
 */

fun main() {
    val items = listOf(1, 2, 3, 4)
    println(items.first())
    println(items.last())
    items.filter { it % 2 == 0 }.forEach { println(it) }

    println("--------------")

    val myList = mutableListOf(1, 2, 3, 4)
    println(myList.requireNoNulls())

    if (myList.none { it > 10 }) {
        println("没有大于10的元素")
    }

    println(myList.firstOrNull())
    println(myList.lastOrNull())

    println("--------------")

    val myMap = hashMapOf("hello" to 1, "world" to 2)
    println(myMap["hello"])

    val myMap2: Map<String, Int> = HashMap(myMap)
    println(myMap2)
}