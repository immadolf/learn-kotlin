package org.adolf.kotlin.demo10

/**
 * 数组 array
 *
 * 在Kotlin中，数组是不变的（相对于协变和逆变），而Java中数组是协变的
 *
 * Kotlin提供了原生类型数组来避免自动装箱拆箱带来的成本
 * - IntArray
 * - DoubleArray
 * - ...
 *
 * @author 40313
 * @date 2020/6/28
 * @since
 */

fun main() {
    val myArray = MyArray()

    myArray.myArrayMethod(intArrayOf(1, 2, 3))
    //myArray.myArrayMethod(arrayOf(1, 2, 3)) 编译错误，说明IntArray和Array<Int>类型不同

    println("--------------")

    //当编译成jvm字节码时，编译器会优化对于数组的访问，不会产生额外的成本
    val array = arrayOf(1, 2, 3)
    array[0] = array[0] * 2 //此处并不会调用set方法，而是直接根据索引进行赋值
}