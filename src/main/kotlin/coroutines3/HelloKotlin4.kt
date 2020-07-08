package coroutines3

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 异步风格的函数.不建议使用.
 *
 * @author 40313
 * @date 2020/7/8
 * @since
 */
fun main() {
    val costTime = measureTimeMillis {
        val value1 = intValue1Async()
        val value2 = intValue2Async()

        runBlocking {
            println("the result is : ${value1.await() + value2.await()}")
        }
    }
    println("costTime : $costTime")
}

fun intValue1Async() = GlobalScope.async {
    intValue1()
}

fun intValue2Async() = GlobalScope.async {
    intValue2()
}

private suspend fun intValue1(): Int {
    delay(2000)
    return 15
}

private suspend fun intValue2(): Int {
    delay(3000)
    return 20
}
