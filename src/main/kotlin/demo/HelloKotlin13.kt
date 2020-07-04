package org.adolf.kotlin.demo

/**
 * 构造函数的简便写法
 *
 * @author adolf
 * @date 2020/6/14
 * @since
 */

//当通过val/var修饰时，构造函数的参数同时也成为了属性
class Student(private val userName: String, private val age: Int, private val address: String) {
    fun printInfo() {
        println("username: $userName, age: $age, address: $address")
    }
}

//在JVM上，如果类的primary构造方法的所有参数都拥有默认值，
//那么kotlin编译器就会为这个类生成一个不带参数的构造方法
//这个不带参数的构造方法会使用这些参数的默认值，这样做的目的在于和spring等框架更好的集成
//因为这些框架通常会使用类的无参构造函数
class Student2(val userName: String = "zhangsan")

fun main() {
    val student = Student("zhangsan", 20, "beijing")
    val student2 = Student2()
}