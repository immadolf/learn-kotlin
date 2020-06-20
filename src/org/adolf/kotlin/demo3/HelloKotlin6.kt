package org.adolf.kotlin.demo3

/**
 * 对象表达式(object expression)
 *
 * Kotlin的对象表达式是为了解决匿名内部类的一些缺陷而产生的
 *
 * @author 40313
 * @date 2020/6/20
 * @since
 */

// 1. 匿名内部类是没有名字的类
// 2. 匿名内部类一定是继承了某个父类，或者是实现了某个接口
// 3. Java运行时会将该匿名内部类当做它所实现的接口或继承的父类来看待


// 对象表达式的语法格式
/*
    object [: 若干父类型，中间用逗号隔开] {

    }
 */

interface MyInterFace {
    fun myPrint(i: Int)
}

abstract class MyAbstractClass {
    abstract val age: Int
    abstract fun printMyAbstractClassInfo()
}

fun main() {
    // java中匿名内部类的用法
    val myObject = object : MyInterFace {
        override fun myPrint(i: Int) {
            println("i的值是$i")
        }
    }

    myObject.myPrint(100)

    println("--------------")

    // 没有父类的对象（java中的匿名内部类必须是实现一个超类）
    val myObject2 = object {
        init {
            println("初始化块执行")
        }

        val myProperty = "hello,world"
        fun myMethod() = "myMethod()"
    }

    println(myObject2.myProperty)
    println(myObject2.myMethod())

    println("--------------")

    // 实现多个超类的对象（java中的匿名内部类只能实现一个超类）
    val myObject3 = object : MyInterFace, MyAbstractClass() {
        override fun myPrint(i: Int) {
            println("i的值是$i")
        }

        override val age: Int
            get() = 30

        override fun printMyAbstractClassInfo() {
            println("printMyAbstractClassInfo invoked")
        }

    }

    myObject3.myPrint(200)
    println(myObject3.age)
    myObject3.printMyAbstractClassInfo()
}