package org.adolf.kotlin.demo

/**
 * overwrite
 *
 * @author adolf
 * @date 2020/6/14
 * @since
 */

open class Fruit {
    // 方法默认也是final的，要用open关键词才能被子类重写
    open fun name() {
        println("fruit")
    }

    fun expirationDate() {
        println("1 month")
    }
}

class Apple : Fruit() {
    override fun name() {
        println("apple")
    }
}

open class Orange : Fruit() {
    // 可以用final再次标记从父类继承的方法
    final override fun name() {
        println("orange")
    }
}

fun main() {
    var apple = Apple()
    apple.name()
    apple.expirationDate()
}