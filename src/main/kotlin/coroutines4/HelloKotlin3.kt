package coroutines4

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

/**
 * 使用JVM参数输出协程名称：-Dkotlinx.coroutines.debug
 * 单线程运行多协程
 *
 * @author 40313
 * @date 2020/7/11
 * @since
 */

private fun log(message: String) = println("[${Thread.currentThread().name}: $message]")

fun main() {
    runBlocking {
        val a = async {
            log("hello world")
            10
        }

        val b = async {
            log("welcome")
            20
        }

        log("the result is ${a.await() + b.await()}")
    }
}