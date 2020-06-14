package org.adolf.kotlin.demo

/**
 * 对象
 *
 * @author adolf
 * @date 2020/6/14
 * @since
 */

// object declaration 对象声明
object MyObject {
    fun method() {
        println("method")
    }
}

fun main() {
    MyObject.method()

    println("-----------")

    MyTest.MyObject.method()

    println("-----------")

    println(MyTest.a) //类似于静态方法，Kotlin中没有静态方法
    MyTest.method()

    println("-----------")
    println(MyTest.MyObject.javaClass)
}

// companion object,伴生对象
// 在Kotlin中，与java不同的是，类是没有static方法的
// 在大多数情况下，Kotlin推荐的做法是使用包级别的函数来作为静态方法
// Kotlin会将包级别的函数当做静态方法来看待
class MyTest {

    // 伴生对象的名字MyObject可以省略，编译器会提供一个默认的名字 Companion
    // 伴生对象的成员看起来像是java中的静态成员，但在运行期，他们依旧是真实对象的实例成员
    // 在JVM上，可以将伴生对象的成员真正生成为类的静态方法与属性，这是通过@JvmStatic注解来实现的
    // 伴生对象在编译后会生成一个静态内部类
    companion object MyObject {
        var a = 100

        fun method() {
            println("method invoked")
        }
    }
}