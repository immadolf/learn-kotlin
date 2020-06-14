package org.adolf.kotlin.demo

/**
 * 类和接口
 *
 * @author adolf
 * @date 2020/6/14
 * @since
 */
interface A {
    //接口中可以实现方法
    fun method() {
        println("A")
    }
}

// 接口后面不用括号
class C : A {

}

fun main() {
    var c = C()
    c.method()
}

class C1 : A {
    override fun method() {
        println("C")
    }
}

open class B {
    open fun method() {
        println("B")
    }
}

// 多个父类有同样的方法，需要显示指定
class C2 : A, B() {

    override fun method() {
        super<A>.method()
        super<B>.method()
    }
}