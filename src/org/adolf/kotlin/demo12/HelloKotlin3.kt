package org.adolf.kotlin.demo12

/**
 *
 *
 * @author 40313
 * @date 2020/6/30
 * @since
 */
class MyClass2 @JvmOverloads constructor(val a: Int, val b: String = "hello") {

    fun myMethod(a: Int, b: String, c: Int = 3) {
        println("a:$a,b:$b,c:$c")
    }

}