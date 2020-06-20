package org.adolf.kotlin.demo3

/**
 * 在外部类的外面声明一个内部类的对象
 *
 * @author 40313
 * @date 2020/6/20
 * @since
 */
class OuterClass5 {

    inner class InnerClass5(string: String) {
        init {
            println(string)
        }
    }
}

fun main() {
    val innerClass5: OuterClass5.InnerClass5 = OuterClass5().InnerClass5("hello world")
}