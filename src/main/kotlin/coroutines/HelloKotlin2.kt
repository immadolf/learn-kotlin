package coroutines

import kotlin.concurrent.thread

/**
 * HelloKotlin1.kt中代码的线程写法.
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */
fun main() {

    thread {
        Thread.sleep(1000)
        println("kotlin coroutines")
        println(Thread.currentThread().name)
    }
    println("hello")
    println(Thread.currentThread().name)
    Thread.sleep(2000)

    println("world")
}