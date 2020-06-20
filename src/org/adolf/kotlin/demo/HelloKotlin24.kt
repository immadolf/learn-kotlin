package org.adolf.kotlin.demo

/**
 * 扩展属性
 *
 * @author adolf
 * @date 2020/6/20
 * @since
 */
class MyExtensionProperty

val MyExtensionProperty.name: String
    get() = "hello"


fun main() {
    val myExtensionProperty = MyExtensionProperty()
    println(myExtensionProperty.name) //hello
}