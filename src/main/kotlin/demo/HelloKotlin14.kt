package org.adolf.kotlin.demo

/**
 * 继承
 *
 * @author adolf
 * @date 2020/6/14
 * @since
 */

// 在kotlin中所有类在默认情况下是无法被继承的，即默认情况下是final的
open class Parent(name: String, age: Int) {

}

// 继承的时候显示调用父类的构造方法
class Child(name: String, age: Int) : Parent(name, age) {

}


open class Parent2(name: String)

/**
 * 在Kotlin中，如果一个类没有primary构造方法，那么这个类的每个secondary构造方法就需要通过
 * super关键字来初始化父类型，或者是通过其他的secondary构造方法来完成这个任务
 * 不同的secondary构造方法可以调用父类型不同的构造方法
 */
class Child2 : Parent2 {
    constructor(name: String) : super(name)
}