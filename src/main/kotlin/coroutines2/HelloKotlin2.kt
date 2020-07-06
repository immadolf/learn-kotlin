package coroutines2

import kotlinx.coroutines.*

/**
 * kotlinx.coroutines包下的所有挂起函数都是可以取消的。
 *
 * 他们会检查协程的取消状态，当取消时会抛出CancellationException异常
 *
 * 但是，如果协程正在处于某个计算过程中，没有去检查取消状态，那么它就是无法取消的。
 *
 * @author 40313
 * @date 2020/7/6
 * @since
 */

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime

        var i = 0

        //CPU一直处于计算过程
        while (i < 20) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I am sleeping ${i++}")
                nextPrintTime += 500L
            }
        }
    }

    delay(1300)
    println("hello world")

    job.cancelAndJoin()
    println("11111111111111")
}