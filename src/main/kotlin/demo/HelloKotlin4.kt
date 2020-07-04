package org.adolf.kotlin.demo

/**
 * 可空类型与智能转换
 *
 * @author adolf
 * @date 2020/6/14
 * @since
 */
fun main(args: Array<String>) {
    println(convert2Int("ab"))

    printMultiply("2", "a")

    printMultiply2("2", "a")
}

// 可空类型
fun convert2Int(str: String): Int? {
    return try {
        str.toInt()
    } catch (ex: NumberFormatException) {
        null
    }
}

fun printMultiply(x: String, y: String): Unit {
    val a = convert2Int(x)
    val b = convert2Int(y)

    if (null != a && null != b) {
        //Smart cast
        println(a * b)
    } else {
        println("param not int")
    }
}

fun printMultiply2(x: String, y: String): Unit {
    val a = convert2Int(x)
    val b = convert2Int(y)

    if (a == null) {
        println("param not int")
    } else if (b == null) {
        println("param not in")
    } else {
        //Smart cast
        println(a * b)
    }
}

