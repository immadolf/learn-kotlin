package org.adolf.kotlin.demo

/**
 * 属性
 *
 * @author adolf
 * @date 2020/6/14
 * @since
 */
class ThePerson(address: String, name: String) {
    // kotlin中的属性，java中的成员变量
    val age: Int = 20

    //val readOnly = 20
    val readOnly: Int
        get() = 20

    var address: String = address
        get() {
            println("get invoked")
            return field //backing field 支援字段
        }
        set(value) {
            println("set invoked")
            field = value //要理解属性背后的backing field，只能在属性的get set中访问
        }

    var weight: String
        get() {
            return backingProperty
        }
        set(value) {
            backingProperty = value
        }

    //backing property:支撑属性，由于是private不能直接访问，但可以通过其他属性的访问器访问
    private var backingProperty: String = "1111"

    var name: String = name
        private set //修改set方法的可见性，不修改默认实现，get方法的可见性需要和属性的可见性一致
}

fun main(args: Array<String>) {
    val person = ThePerson("a", "b")

    println(person.age)

    person.address = "beijing"
    println(person.address)

    println(person.weight) //1111
}