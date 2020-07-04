package org.adolf.kotlin.demo3

import javax.sound.midi.Soundbank

/**
 * 匿名对象只能在局部变量范围内或是被private修饰的成员变量范围内才能被识别出其真正的类型。
 * 如果将该匿名对象当做一个public方法的返回类型，或是public属性的类型，那么该方法或是属性的真正类型
 * 就是该匿名对象所声明的父类型，如果没有声明如何父类型，那么其类型就是Any；在这种情况下，匿名对象中所声明的任何成员都是无法访问的
 *
 * 反编译后可以看到有private修饰和没有private修饰的时候，返回值类型是不同的
 *
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */
class MyClass {
    //当没有private修饰时，myTest方法中就无法访问output方法
    private var myObject = object {
        fun output() {
            println("output invoked")
        }
    }

    fun myTest() {
        println(myObject.javaClass)
        myObject.output()
    }
}

class MyClass2 {
    private fun method1() = object {
        val str = "hello"
    }

    internal fun method2() = object {
        var str = "world"
    }

    fun test() {
        println(method1().javaClass)
        println(method2().javaClass)
    }
}

fun main() {
    val myClass = MyClass()
    myClass.myTest()
    MyClass2().test()
}