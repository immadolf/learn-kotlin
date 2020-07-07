package coroutines3

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 挂起函数的组合.
 *
 * @author 40313
 * @date 2020/7/7
 * @since
 */
fun main() = runBlocking {

    val costTime = measureTimeMillis {
        val value1 = intValue1()
        val value2 = intValue2()

        println("$value1 + $value2 = ${value1 + value2}")//15 + 20 = 35
    }
    //输出结果说明这两个函数是同步执行的
    println("costTime:$costTime") //costTime:5012
}

private suspend fun intValue1(): Int {
    delay(2000)
    return 15
}

private suspend fun intValue2(): Int {
    delay(3000)
    return 20
}