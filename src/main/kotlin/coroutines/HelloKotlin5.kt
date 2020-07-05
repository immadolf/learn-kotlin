package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *
 *
 * @author adolf
 * @date 2020/7/5
 * @since
 */
fun main() = runBlocking {
    val job = GlobalScope.launch {
        //挂起一个协程，但是不会阻塞线程
        delay(1000)
        println("kotlin coroutines")
    }

    println("hello")
    job.join()
    println("world")
}