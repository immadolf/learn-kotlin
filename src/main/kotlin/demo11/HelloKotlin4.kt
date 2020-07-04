@file: JvmName("HelloWorld") //两个文件指定同样的类名（同一个包下），会编译错误
@file: JvmMultifileClass //通过这个注解，可以让多个kt文件编译后合并成一个class文件，每个kt文件上都要加这个注解

package org.adolf.kotlin.demo11

/**
 *
 *
 * @author 40313
 * @date 2020/6/29
 * @since
 */
fun myPrint2() {
    println("myPrint2")
}