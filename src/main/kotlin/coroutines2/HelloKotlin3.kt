package coroutines2

import kotlinx.coroutines.*

/**
 * 续上一节：有两种方式可以让计算代码变成可取消的：
 * 1. 周期性的调用一个挂起函数，该挂起函数会检查取消状态，比如使用yield函数
 * 2. 显式的检查取消状态
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

        //显式的检查取消状态，isActive是coroutineScope的扩展属性
        while (this.isActive) {
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