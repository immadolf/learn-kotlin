package coroutines3

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 使用async和await实现并发.
 *
 * 从概念上来讲，async和launch一样，都会开启一个单独的后台协程，可以与其他协程并发工作。区别在于async会返回结果Deferred。
 * Deferred是一个轻量级的非阻塞的future，它代表一个promise，可以在稍后提供一个结果值。
 *
 * 可以通过在deferred上调用await方法来获取最终的结果值，deferred是Job的子类，因此它也可以取消。
 *
 *
 * @author 40313
 * @date 2020/7/7
 * @since
 */
fun main() = runBlocking {

    val costTime = measureTimeMillis {
        val value1 = this.async { intValue1() }
        val value2 = this.async { intValue2() }

        val result1 = value1.await()
        val result2 = value2.await()
        println("$result1 + $result2 = ${result1 + result2}")//15 + 20 = 35
    }
    //输出结果说明这两个函数是并行执行的
    println("costTime:$costTime") //costTime:3017
}

private suspend fun intValue1(): Int {
    delay(2000)
    return 15
}

private suspend fun intValue2(): Int {
    delay(3000)
    return 20
}