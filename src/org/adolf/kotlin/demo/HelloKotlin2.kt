package org.adolf.kotlin.demo

//import org.adolf.kotlin.demo2.multiply  导入
// 别名
import org.adolf.kotlin.demo2.multiply as myMultiply

/**
 *
 *
 * @author adolf
 * @date 2020/6/14
 * @since
 */

fun main(args: Array<String>) {
    val a: Int = 1 //final
    val b = 2

    var c: Int
    c = 3

    var d = 3
    d = 4

    println(d)


    var x = 10
    var y: Byte = 20

    // x = y error 需要转换
    x = y.toInt()
    println(x)

    println(myMultiply(2, 3))
}