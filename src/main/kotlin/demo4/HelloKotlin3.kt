package org.adolf.kotlin.demo4

/**
 * 属性委托 -- 延迟属性
 * 指的是属性只在第一次被访问的时候才会计算，之后则会将之前的计算结果缓存起来供后续使用
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */

//LazyThreadSafetyMode:
//1. SYNCHRONIZED:默认情况下，延迟属性的计算是同步的：值只会在一个线程中得到计算，所有线程都会使用相同的一个结果
//2. PUBLICATION：如果不需要初始化委托的同步，这样多个线程可以同时执行，但是只有第一个返回的结果会被使用
//3. NONE：如果确定初始化操作只会在一个线程中执行，这样会减少线程安全方面的开销
val myLazyValue: Int by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
    println("hello world")
    30 //完整写法是 return@lazy 30
}

fun main() {
    // hello world 只会输出一次
    println(myLazyValue)
    println(myLazyValue)
}
