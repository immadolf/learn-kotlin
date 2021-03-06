package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 使用runBlocking实现HelloKotlin1.kt
 *
 * @author adolf
 * @date 2020/7/4
 * @since
 */
fun main() {

    //launch函数: 如果不指定CoroutineDispatcher或者没有其他的CoroutinuationInterceptor，默认的协程调度器就是Dispatchers.Default，
    //Default是一个协程调度器，其指定的线程为共有的线程池，线程数量最少为2，最大与CPU数相同。
    //因此，这里加载协程的线程并不是main线程，所以main线程的sleep不会影响协程的恢复
    GlobalScope.launch {
        //挂起一个协程，但是不会阻塞线程
        println(Thread.currentThread().name)
        delay(1000)
        println("kotlin coroutines")
    }

    //runBlocking {} 函数创建一个新的协程同时**阻塞当前线程**，直到协程结束。这个不应该在协程中使用，主要是为了main函数和测试设计的。
    runBlocking {
        println("hello")
        println(Thread.currentThread().name)
        delay(2000)
    }


    println("world")
}