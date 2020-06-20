package org.adolf.kotlin.demo

/**
 * 扩展：extension
 *
 * @author adolf
 * @date 2020/6/14
 * @since
 */

class ExtensionTest {
    fun add(a: Int, b: Int) = a + b

    fun subtract(a: Int, b: Int) = a - b
}

// 扩展方法
fun ExtensionTest.multiply(a: Int, b: Int) = a * b

fun main(args: Array<String>) {
    var extensionTest = ExtensionTest()

    println(extensionTest.add(1, 2))
    println(extensionTest.subtract(1, 2))
    println(extensionTest.multiply(1, 2))

    myPrint(BB()) // a
    println("----------")
    CC().foo() //member
}

// 扩展函数的解析是静态的
// 1. 扩展本身并不会真正修改目标类，也就是说它并不会在目标类中插入新的属性或是方法
// 2. 扩展函数的解析是静态分发的，而不是动态的，即不支持多态，调用只取决于对象的声明类型
// 3. 调用是由对象声明类型决定的，而不是由对象的实际类型决定

open class AA

class BB : AA()

fun AA.a() = "a"

fun BB.a() = "b"

fun myPrint(aa: AA) {
    println(aa.a())
}

class CC {
    fun foo() {
        println("member")
    }
}

// 扩展函数**无法**覆盖类中已有的函数
fun CC.foo() {
    println("member2")
}

// 扩展函数**可以**重载类中已有的函数
fun CC.foo(i: Int) {
    println("member2")
}


// 可以对可空类型进行扩展
fun Any?.toString(): String {
    if (null == this) {
        return "null"
    }

    return this.toString()
}