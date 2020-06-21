package org.adolf.kotlin.demo4

import java.util.*

/**
 * 属性委托 -- map属性
 *
 * 将属性存储到map中，通常出现在JSON解析或是一些动态行为，
 * 在这种情况中，可以将map实例作为委托，作为类中属性的委托
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */
// map中key的名字要与属性名字保持一致
class Student(map: Map<String, Any?>) {
    val name: String by map
    val address: String by map
    val age: Int by map
    val birthday: Date by map
}

class Student2(map: MutableMap<String, Any?>) {
    var address: String by map
}

fun main(args: Array<String>) {
    val student = Student(
        mapOf(
            "name" to "zhangsan",
            "address" to "beijing",
            "age" to 20,
            "birthday" to Date()
        )
    )
    println(student.name)
    println(student.address)
    println(student.age)
    println(student.birthday)

    println("----------")

    val map: MutableMap<String, Any?> = mutableMapOf(
        "address" to "beijing"
    )
    val student2 = Student2(map)
    println(map["address"]) //beijing
    println(student2.address) //beijing
    println("-----------")
    student2.address = "shanghai"
    println(map["address"]) //shanghai
    println(student2.address) //shanghai
}