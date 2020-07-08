package coroutines3

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * async延迟执行.
 * 通过将async方法的start参数设置为lazy来实现延迟执行。
 * 这个时候有两个方法来启动：
 * 1. 调用async返回值deferred的await方法
 * 2. 调用deferred的start方法
 *
 * @author 40313
 * @date 2020/7/8
 * @since
 */
fun main() = runBlocking {

    val costTime = measureTimeMillis {
        val value1 = this.async(start = CoroutineStart.LAZY) { intValue1() }
        val value2 = this.async(start = CoroutineStart.LAZY) { intValue2() }

        value1.start()
        value2.start()
        //如果通过await方法来启动协程，那么这里就会变成串行，因为await是suspend的
        val result1 = value1.await()
        val result2 = value2.await()
        println("$result1 + $result2 = ${result1 + result2}")//15 + 20 = 35
    }
    println("costTime:$costTime")
}

private suspend fun intValue1(): Int {
    delay(2000)
    return 15
}

private suspend fun intValue2(): Int {
    delay(3000)
    return 20
}
