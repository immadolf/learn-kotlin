package org.adolf.kotlin.demo4

import kotlin.properties.Delegates

/**
 * 属性委托 -- 非空属性
 * Kotlin的空类型安全要求对于非空类型，必须要给一个初始值，而有的时候我们的确不知道初始值，又不想随便给个值，这个时候就可以用非空委托
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */
class MyPerson {
    var address: String by Delegates.notNull<String>()
}

fun main() {
    val myPerson = MyPerson()
    //println(myPerson.address) // 异常 Property address should be initialized before get.
    myPerson.address = "suzhou"
    println(myPerson.address) //suzhou
}
