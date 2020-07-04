package org.adolf.kotlin.demo13

import java.io.Serializable
import kotlin.reflect.full.superclasses

/**
 * 反射获取父类的信息
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */
class MySerializable : Serializable

fun main() {
    val kClass = MySerializable::class
    println(kClass.superclasses)//[class java.io.Serializable, class kotlin.Any]
    println(kClass.supertypes)//[java.io.Serializable, kotlin.Any]
}