package org.adolf.kotlin.demo4

import kotlin.properties.Delegates

/**
 * 属性委托 -- 可观测属性
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */
class Person {
    // observable 在属性修改之后调用回调
    var age: Int by Delegates.observable(20) { property, oldValue, newValue ->
        println("${property.name}, oldValue: $oldValue, newValue: $newValue")
    }
}

class Person2 {
    // vetoable 在属性修改之前调用回调
    var age: Int by Delegates.vetoable(20) { property, oldValue, newValue ->
        when {
            oldValue <= newValue -> true
            else -> false
        }
    }
}

fun main() {
    val person = Person()
    person.age = 30 //age, oldValue: 20, newValue: 30
    person.age = 40 //age, oldValue: 30, newValue: 40

    println("------------")

    val person2 = Person2()
    person2.age = 10
    println(person2.age)  //20
    person2.age = 30
    println(person2.age)  //30

}