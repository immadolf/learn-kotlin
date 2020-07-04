package org.adolf.kotlin.demo13

import kotlin.reflect.KMutableProperty
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredMemberProperties

/**
 * 反射对操作var和val属性.
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */
class MyTestClass12 {

    var name: String = "aaaa"
    var price: Double = 3.1415926
}

fun main() {
    val kClass = MyTestClass12::class
    val obj = kClass.createInstance()
    //获取本类声明的属性
    val declaredMemberProperties = kClass.declaredMemberProperties

    declaredMemberProperties.forEach {
        when (it.name) {
            "name" -> {
                //将属性转换成读写属性
                val temp = it as KMutableProperty1<MyTestClass12, Any>
                temp.set(obj, "bbb")
                println(it.get(obj))//bbb

                //上面的这种写法算是一种简便方法，因为KMutableProperty1提供了一个set方法
                val temp2 = it as KMutableProperty<*>
                temp2.setter.call(obj, "ccc")
                println(it.get(obj))//ccc
            }
            "price" -> {
                //price是只读属性，直接读就可以了
                println(it.get(obj))//3.1415926
            }
        }
    }
}