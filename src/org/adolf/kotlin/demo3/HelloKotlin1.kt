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


    class NestedClass {
        fun nestedMethod() = "welcome"
    }
}

fun main() {
    println(OuterClass.NestedClass().nestedMethod())
}