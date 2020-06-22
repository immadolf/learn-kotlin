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
}