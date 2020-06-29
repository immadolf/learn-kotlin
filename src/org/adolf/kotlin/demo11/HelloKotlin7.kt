package org.adolf.kotlin.demo11

/**
 * 在Kotlin中，可以将具名对象或者伴生对象中定义的函数标注@JvmStatic注解，这样编译器就会在相应对象的类中生成静态方法，也会在对象自身中生成实例方法。
 * 可以看反编译的结果来理解。
 *
 * @author 40313
 * @date 2020/6/29
 * @since
 */
class MyClass2 {
    companion object {
        fun test1() {
            println("test1")
        }

        @JvmStatic
        fun test2() {
            println("test2")
        }
    }
}