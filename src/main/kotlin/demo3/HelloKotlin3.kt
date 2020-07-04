package org.adolf.kotlin.demo3

/**
 * Kotlin访问外部类变量的方法：this@OuterClass.str
 * Java访问外部类变量的方法: OuterClass.this.str
 *
 * @author 40313
 * @date 2020/6/19
 * @since
 */

class Person(val name: String, val age: Int) {

    private val str: String = "person属性"

    private inner class PersonFeature(val height: Int, val weight: Int) {
        private val str: String = "PersonFeature属性"

        fun getPersonFeature() {
            val str = "局部变量"
            println("身高，$height")
            println("体重，$weight")
            this@Person.method()

            // 访问重名变量
            println(str)
            println(this.str)
            println(this@Person.str)
        }
    }

    private fun method() {
        println("执行了person的method方法")
    }

    fun getPerson() {
        val personFeature = PersonFeature(100, 100)
        personFeature.getPersonFeature()
    }
}

fun main() {
    val person = Person("张三", 20)
    person.getPerson()
}