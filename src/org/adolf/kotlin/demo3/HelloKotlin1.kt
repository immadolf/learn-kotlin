package org.adolf.kotlin.demo3

/**
 * 嵌套类 nested class
 *
 * @author 40313
 * @date 2020/6/19
 * @since
 */
class OuterClass {
    private val str: String = "Hello,World"


    // 嵌套类不能访问外部类的其他成员，只能访问其他嵌套类
    class NestedClass {
        fun nestedMethod() = "welcome"
    }

    class NestedClass2 {
        fun nestedMethod() = NestedClass().nestedMethod()
    }
}

fun main() {
    println(OuterClass.NestedClass().nestedMethod())
}