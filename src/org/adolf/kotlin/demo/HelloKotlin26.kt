package org.adolf.kotlin.demo

/**
 * 扩展的作用域
 * 1. 扩展函数所定义在的类实例叫做分发接收者(dispatch receiver)
 * 2. 扩展函数所扩展的那个类的实例叫做扩展接收者(extension receiver)
 * 3. 当以上两个名字出现冲突时，扩展接收者的优先级最高
 *
 * 扩展可以很好地解决Java中充斥的各种辅助类问题
 *
 * @author adolf
 * @date 2020/6/20
 * @since
 */

// 扩展接收者
class DD {
    fun method() {
        println("DD method")
    }

    override fun toString(): String {
        return "dd"
    }
}

// 分发接收者
class EE {
    fun method2() {

    }

    fun DD.hello() {
        method()
        method2()
    }

    fun world(dd: DD) {
        dd.hello()
    }

    fun DD.output() {
        println(toString())// dd
        println(this@EE.toString())// ee
    }

    override fun toString(): String {
        return "ee"
    }

    fun test() {
        val dd = DD()
        dd.output()
    }
}

fun main() {
    // DD().hello() 编译错误，因为扩展方法hello是定义在EE类中，外界无法直接访问

    EE().test() //dd /r/n ee
}