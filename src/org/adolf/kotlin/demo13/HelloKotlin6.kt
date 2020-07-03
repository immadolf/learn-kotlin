package org.adolf.kotlin.demo13

/**
 * 带接收者的属性引用，需要使用全限定名.
 *
 * @author 40313
 * @date 2020/7/3
 * @since
 */
fun main() {
    val values = listOf("a", "abc", "abcd")
    //属性引用还可以这样用
    println(values.map(String::length))//[1, 3, 4]

    println("------------------")

    //带接收者的属性引用
    println(MyClass::x)//val org.adolf.kotlin.demo13.MyClass.x: kotlin.Int
    //调用get方法需要传入其所属对象
    println(MyClass::x.get(MyClass(10)))//10
}

class MyClass(val x: Int)