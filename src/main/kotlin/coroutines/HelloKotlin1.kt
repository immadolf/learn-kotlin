package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * 第一个协程程序.
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
    println("hello")
    println(Thread.currentThread().name)
    Thread.sleep(2000)

    println("world")
}

/*
后面很多例子的运行结果看起来像是会先执行launch中的代码块直到挂起再跑去执行外部的代码，
这个例子说明了协程的确是后台运行的，即不是先执行launch的代码直到挂起再去执行后面的代码。
fun main() {
    runBlocking {
        launch {
            for (i in 1..100000) {
                println(i)
            }
        }
        println("end")
    }
}

 */