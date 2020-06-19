package org.adolf.kotlin.demo3

/**
 * 内部类 Inner Class
 *
 * 关于嵌套类与内部类之间的区别和联系：
 * 1. 嵌套类：对应于java的静态内部类，即有static关键字修饰的内部类，只要在一个类的内部定义了另外一个类，那么这个类就叫做嵌套类
 * 2. 内部类：对应于java的非静态内部类，即没有static关键字修饰的内部类，使用inner关键字在一个类的内部定义的另一个类就叫做内部类
 *
 * @author 40313
 * @date 2020/6/19
 * @since
 */

class OuterClass2 {

    private var str: String = "hello,world"

    // 注意关键字 **inner**
    inner class InnerClass {
        fun innerMethod() = this@OuterClass2.str
    }

    // 局部嵌套类
    fun getName(): String {
        class LocalNestedClass {
            val name: String = "myTest"
        }

        val localNestedClass = LocalNestedClass()
        return localNestedClass.name
    }

}

fun main() {
    // println(OuterClass2.InnerClass()) // 编译错误
    println(OuterClass2().InnerClass().innerMethod())

    println(OuterClass2().getName())
}