package coroutines4

import kotlinx.coroutines.*

/**
 * CoroutineName 上下文元素可以让我们对协程进行命名，以便能够输出可读性较好的日志信息。
 *
 * 需要配合jvm参数：-Dkotlinx.coroutines.debug
 *
 * @author 40313
 * @date 2020/7/15
 * @since
 */

private fun log(message: String) = println("[${Thread.currentThread().name}: $message]")

fun main() = runBlocking(CoroutineName("main")) {
    log("hello")

    val value1 = async(CoroutineName("coroutine1")) {
        delay(100)
        log("coroutine1 log")
        30
    }

    val value2 = async(CoroutineName("coroutine2")) {
        delay(200)
        log("coroutine2 log")
        5
    }

    log("result is :${value1.await() + value2.await()}")
}