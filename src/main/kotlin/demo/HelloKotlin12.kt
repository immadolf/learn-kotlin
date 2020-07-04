package org.adolf.kotlin.demo

/**
 * primary构造方法和secondary构造方法
 *
 * @author adolf
 * @date 2020/6/14
 * @since
 */
class Person constructor(username: String) {
    private var name: String

    private var age: Int

    private var address: String

    init {
        println(username)
        this.name = username
        this.age = 20
        this.address = "beijing"
    }

    // secondary构造方法必须直接或间接调用主构造方法
    constructor(username: String, age: Int) : this(username) {
        println("$username, $age")

        this.age = age
        this.address = "beijing"
    }

    constructor(username: String, age: Int, address: String) : this(username, age) {
        this.address = "beijing"
    }

    fun printInfo() {
        println("username: $name, age: $age, address: $address")
    }
}

fun main() {
    val person = Person("zhangsan")
    val person2 = Person("lisi", 30)
    val person3 = Person("wangwu", 40, "hangzhou")

    person.printInfo()
    person2.printInfo()
    person3.printInfo()
}