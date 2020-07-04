package org.adolf.kotlin.demo13

/**
 * 扩展属性的属性引用.
 *
 * @author 40313
 * @date 2020/7/3
 * @since
 */
class MyClass2

val MyClass2.x: Int
    get() = 10


fun main() {
    //使用方法和成员属性没有什么区别
    println(MyClass2::x)//val org.adolf.kotlin.demo13.MyClass2.x: kotlin.Int
    println(MyClass2::x.get(MyClass2()))//10
    println(MyClass2::x.name)//x
}