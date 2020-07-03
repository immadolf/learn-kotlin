package org.adolf.kotlin.demo13

/**
 * 属性引用 property reference.
 *
 * @author 40313
 * @date 2020/7/3
 * @since
 */

const val a = 3
var b = 1

fun main() {
    //::a表示类型为KProperty<Int>的属性对象，可以通过get()方法来获取值，通过name属性来获取属性名
    println(::a)//val a: kotlin.Int
    println(::a.get())//3
    println(::a.name)//a

    println("-------------")

    //对于可变属性来说，::b表示类型为KMutableProperty<Int>的属性对象
    println(::b)//var b: kotlin.Int
    println(b)//1
    ::b.set(10)
    println(::b.get())//10
    println(::b.name)//b


}