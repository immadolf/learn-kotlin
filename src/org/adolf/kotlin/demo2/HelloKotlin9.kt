package org.adolf.kotlin.demo2

/**
 * 泛型函数与泛型上界
 *
 * @author 40313
 * @date 2020/6/18
 * @since
 */

fun <T> getValue(item: T): T {

    return item
}

fun main() {
    val item = getValue<Int>(3)
    println(item)

    val item2 = getValue("hello")
    println(item2)

    val upperBoundsClass = UpperBoundsClass<SubClass>()

    // String既属于Comparable 又属于Any
    val upperBoundsClass2 = UpperBoundsClass2<String>()
}

open class SupperClass {}

class SubClass : SupperClass() {}

// 泛型上界,如果不指定泛型上界，那么默认上界就是Any?
class UpperBoundsClass<T : SupperClass> {

}

// 指定多个类型上界
class UpperBoundsClass2<T> where T : Comparable<T>, T : Any {

}

