package org.adolf.kotlin.demo13

/**
 * kotlin反射：
 * KClass  --> Class（java）
 * KFunction --> Method（java）
 * KProperty --> Field（java）
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */

fun main() {
    val kClass = "kotlin"::class
    val kClass2 = "kotlin2"::class
    val kClass3 = "kotlin3"::class

    //多个实例对象的类对象只有一个
    println((kClass == kClass2) and (kClass == kClass3))//true

    println("---------------")

    val javaClass = Class.forName("java.util.Date")
    val kotlinClass = javaClass.kotlin
    println(javaClass == kotlinClass)//false
}