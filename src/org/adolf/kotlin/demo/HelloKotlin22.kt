package org.adolf.kotlin.demo

/**
 *
 * 可见性 visibility
 * @author adolf
 * @date 2020/6/14
 * @since
 */

// Kotlin 提供了4中可见性修饰符：private，protected，internal，public

// 顶层函数和类：
// 不加修饰符则表示public
// internal表示一个模块可见
// private当前文件可用
// protected 不能用在顶层类/函数

private fun method() {
    Clazz().test()
}

private class Clazz {
    fun test() {
        method()
    }
}

