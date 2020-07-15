package org.adolf.kotlin.demo7

/**
 * 解构声明
 *
 * @author 40313
 * @date 2020/6/22
 * @since
 */

//kotlin文档推荐使用自定义类的形式
data class MyResult(val result: String, val status: Int)

fun myMethod(): MyResult {
    return MyResult("success", 1)
}

fun myMethod2(): Pair<String, Int> {
    return Pair("success", 1)
}

fun main() {
    //解构，使用了之前提到了componentN
    val (result, status) = myMethod()
    println(result)
    println(status)

    println("-------------------")

    val (result2, status2) = myMethod2()
    println(result2)
    println(status2)

    println("-------------------")

    val map = mapOf<String, String>("a" to "b", "c" to "d")
    for ((key, value) in map) {
        println("$key,$value")
    }

    println("-------------------")

    // 转换map中的value
    map.mapValues { entry -> "${entry.value} hello" }.forEach { println(it) }

    println("-------------------")

    map.mapValues { (key, value) -> "${value} world" }.forEach { println(it) }

    //kotlin 允许我们为解构声明整体指定类型，也可以为每一个具体的component指定类型
    map.mapValues { (key, value): Map.Entry<String, String> -> "${value} world" }.forEach { println(it) }


}