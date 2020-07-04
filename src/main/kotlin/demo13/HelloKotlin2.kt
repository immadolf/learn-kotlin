package org.adolf.kotlin.demo13

/**
 * 通过对象获取KClass.
 *
 * @author 40313
 * @date 2020/7/2
 * @since
 */
fun main() {
    //通过对象获取KClass
    val son: Parent = Son()
    println(son::class) //class org.adolf.kotlin.demo13.Son
    println(son::class.java) //class org.adolf.kotlin.demo13.Son
    println("-----------")

    val daughter: Parent = Daughter()
    println(daughter::class) //class org.adolf.kotlin.demo13.Daughter
    println(daughter::class.java) //class org.adolf.kotlin.demo13.Daughter
    println("-----------")

}

open class Parent {}

class Son : Parent() {}

class Daughter : Parent() {}