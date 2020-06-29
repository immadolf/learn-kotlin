package org.adolf.kotlin.demo11

/**
 *
 *
 * @author 40313
 * @date 2020/6/29
 * @since
 */
class Person {
    val name: String = "zhangsan"

    //使用@JvmField注解对Kotlin中的属性进行标注时，表示它是一个实例字段（instance field），kotlin编译器在处理的时候，将不会给这个字段生成getter/setter方法
    @JvmField
    var age: Int = 10
}