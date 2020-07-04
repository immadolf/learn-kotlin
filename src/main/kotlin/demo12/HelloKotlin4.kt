package org.adolf.kotlin.demo12

import java.io.IOException

/**
 * kotlin中抛出Java中的checked exception，Java如何调用。
 *
 * @author 40313
 * @date 2020/7/1
 * @since
 */

class MyClass3() {
    fun method() {
        println("method invoked")
        //这里抛出checked exception
        throw IOException()
    }

    @Throws(IOException::class)
    fun method2() {
        println("method invoked")
        //这里抛出checked exception
        throw IOException()
    }
}