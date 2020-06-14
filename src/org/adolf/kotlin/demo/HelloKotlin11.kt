package org.adolf.kotlin.demo

/**
 *
 * 类
 *
 * @author adolf
 * @date 2020/6/14
 * @since
 */

// 类名和文件名可以不一样
public class EmptyClass {

}

// 在Kotlin中，一个类可以有一个primary构造方法以及一个或多个secondary构造方法
// primary构造方法是类头的一部分，位于类名后面，可以拥有若干参数
// 如果primary构造方法没有任何注解或是可见性关键字修饰，那么constructor关键字可以省略
class MyClass constructor(username: String) {

    // 可以这样使用构造函数的值
    private val name: String = username.toUpperCase()

    // 初始化代码块，也可以这样使用构造函数的值
    init {
        // 初始化代码块 + 主构造函数 才等于 java的构造函数，kotlin把构造函数的声明和执行分开了
        println(username)
    }
}

fun main(args: Array<String>) {
    // 没有new关键字
    val myClass = MyClass("zhangsan")
}