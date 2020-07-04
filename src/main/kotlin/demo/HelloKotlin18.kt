package org.adolf.kotlin.demo

/**
 * 抽象类
 *
 * @author adolf
 * @date 2020/6/14
 * @since
 */

open class BaseClass {
    open fun method() {

    }
}

//抽象类可以用抽象的方法来覆写父类的方法
abstract class AbastractClass : BaseClass() {
    abstract override fun method()
}