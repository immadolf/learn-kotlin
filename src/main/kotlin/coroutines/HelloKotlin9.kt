package coroutines

import java.util.concurrent.CountDownLatch
import kotlin.concurrent.thread

/**
 * 与HelloKotlin8.kt进行对比.
 *
 * @author adolf
 * @date 2020/7/5
 * @since
 */

fun main() {

    val start = System.currentTimeMillis()
    val countDownLatch = CountDownLatch(10000)
    //创建1w个线程并输出总耗时
    repeat(10000) {
        thread {
            Thread.sleep(1000)
            println(it)
            countDownLatch.countDown()
        }
    }
    println("hello")
    countDownLatch.await()
    println("cost: ${System.currentTimeMillis() - start} ms")//cost: 2015 ms
}