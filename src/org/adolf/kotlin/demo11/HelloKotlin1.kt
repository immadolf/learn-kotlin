package org.adolf.kotlin.demo11

/**
 * Java调用Kotlin
 *
 * 一个Kotlin属性会被编译成3部分Java元素
 * 1. 一个getter方法
 * 2. 一个setter方法
 * 3. 一个私有的字段(field)，其名字与Kotlin属性名一样
 *
 * 如果Kotlin属性名以is开头，那么：
 * 1. getter方法就会和属性名一致
 * 2. setter方法会将is替换成set
 * 3. 对任何类型都生效，不仅仅是布尔值
 *
 * @author 40313
 * @date 2020/6/29
 * @since
 */

// 看反编译结果
class Test {
    val name: String = "zhangsan"
    val isStudent: String = "yes"
}