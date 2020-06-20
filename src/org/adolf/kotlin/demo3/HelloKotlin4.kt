package org.adolf.kotlin.demo3

/**
 * 在外部类的外面声明一个嵌套类的对象
 *
 * @author 40313
 * @date 2020/6/20
 * @since
 */
class OuterClass4 {

    class NestedClass4 {
        init {
            println("NestedClass4构造块执行")
        }
    }
}

fun main() {
    val nestedClass4: OuterClass4.NestedClass4 = OuterClass4.NestedClass4()

}