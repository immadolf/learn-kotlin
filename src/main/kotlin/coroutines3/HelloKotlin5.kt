package coroutines3

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 使用async进行结构化并发程序开发.
 *
 * @author 40313
 * @date 2020/7/8
 * @since
 */
fun main() = runBlocking {
    val costTime = measureTimeMillis {
        println("result:${intSum()}")
    }
    println("costTime:$costTime")
}

private suspend fun intSum(): Int = coroutineScope {
    val value1 = async { intValue1() }

    val value2 = async { intValue2() }

    value1.await() + value2.await()
}


private suspend fun intValue1(): Int {
    delay(2000)
    return 15
}

private suspend fun intValue2(): Int {
    delay(3000)
    return 20
}
