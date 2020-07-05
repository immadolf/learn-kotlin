package org.adolf.kotlin.demo

/**
 * 延迟初始化
 *
 * @author adolf
 * @date 2020/6/14
 * @since
 */
class TheClass {
    /**
     * Kotlin要求非空类型的属性必须要在构造方法中进行初始化
     * 有时，这种要求不太方便，比如通过依赖注入或是单元测试情况下进行属性的赋值
     *
     * 通过lateinit关键字标识属性为延迟初始化，需要满足如下3个条件
     *
     * 1. lateinit只能用在类体中声明的var属性上，不能用在primary constructor声明的属性上
     * 2. 属性不能拥有自定义的setter与getter
     * 3. 属性类型需要为非空，且不能是原生数据类型
     */
    lateinit var name: String

    fun init() {
        this.name = "zhangsan"
    }

    fun print() {

    }
}

fun main(args: Array<String>) {
    var theClass = TheClass()

    theClass.init()
    theClass.print()
}