package org.adolf.kotlin.demo13

/**
 * 反射获取泛型信息.
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */
class MyTestClass<K, V> {
    var k: K? = null
    var v: V? = null
}

fun main() {
    val kClass = MyTestClass::class
    println(kClass.typeParameters)
    println(kClass.typeParameters.size)
    println("first type: ${kClass.typeParameters[0]}")
    println("second type: ${kClass.typeParameters[1]}")
}