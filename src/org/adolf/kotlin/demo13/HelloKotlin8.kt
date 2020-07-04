package org.adolf.kotlin.demo13

import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

/**
 *
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */
class T(val x: Int)

fun main() {
    println(T::x.javaGetter) //public final int org.adolf.kotlin.demo13.T.getX()
    println(T::x.javaField) //private final int org.adolf.kotlin.demo13.T.x

    println("-----------")

    //从kotlin类获取java类，从java类获取kotlin类
    println(T(10).javaClass)
    println(T(10).javaClass.kotlin)

}