package org.adolf.kotlin.demo4

/**
 * 委托(delegation)
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */

// 类委托

interface MyInterface {
    fun myPrint()
}

class MyInterfaceImpl(val str: String) : MyInterface {
    override fun myPrint() {
        println("welcome $str")
    }
}

// 关键字 by
// 原理：by关键字后的对象实际上会被存储在类的内部，也就是作为类的成员变量，编译器会将父类的所有方法实现出来，然后调用委托对象来实现
// 和自己写的一样，只是在语言层面上提供了支持
class MyClass(myInterface: MyInterface) : MyInterface by myInterface

fun main() {
    val myInterfaceImpl = MyInterfaceImpl("zhangsan")
    MyClass(myInterfaceImpl).myPrint() // welcome zhangsan
}