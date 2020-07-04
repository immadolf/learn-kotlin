package org.adolf.kotlin.demo

/**
 * 字段的覆写
 *
 * @author adolf
 * @date 2020/6/14
 * @since
 */

open class MyParent {
    // 字段的覆写也需要open
    open val name: String = "parent"
}

class MyChild : MyParent() {
    override val name: String = "child"
}

// 字段覆写的简便方法
class MyChild2(override val name: String) : MyParent()

open class Myparent3 {
    open fun method() {
        println("parent method")
    }

    open val name get() = "parent"
}

class MyChild3 : Myparent3() {
    override fun method() {
        super.method()

        println("child method")
    }

    // 子类可以用var属性来覆盖父类的val属性
    // 但是不能用val属性来覆盖父类的var属性
    override val name: String
        get() = super.name + " and child"
}