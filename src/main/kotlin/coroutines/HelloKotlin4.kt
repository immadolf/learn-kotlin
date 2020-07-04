package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 使用runBlocking实现HelloKotlin1.kt的另一种写法.
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */
fun main() = runBlocking {
    GlobalScope.launch {
        //挂起一个协程，但是不会阻塞线程
        println(Thread.currentThread().name)
        delay(1000)
        println("kotlin coroutines")
    }

    println("hello")
    println(Thread.currentThread().name)
    delay(2000)
    println("world")
}