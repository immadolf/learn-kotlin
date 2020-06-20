package org.adolf.kotlin.demo

/**
 * 伴生对象的扩展
 *
 * @author adolf
 * @date 2020/6/20
 * @since
 */
class CompanionObjectExtension {
    companion object MyObject {

    }
}

fun CompanionObjectExtension.MyObject.method() {
    println("hello world")
}

fun main() {
    CompanionObjectExtension.method() //hello world
}