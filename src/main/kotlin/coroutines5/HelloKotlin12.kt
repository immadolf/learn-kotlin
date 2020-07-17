package coroutines5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/**
 * Flow exception ，Flow的异常
 *
 * @author 40313
 * @date 2020/7/17
 * @since
 */

private fun myMethod(): Flow<Int> = flow {
    for (i in 1..3) {
        println("emiting $i")
        emit(i)
    }
}

private fun myMethod2(): Flow<String> = flow {
    for (i in 1..3) {
        println("emiting $i")
        emit(i)
    }
}.map { value ->
    check(value <= 1) { "collected $value" }
    "string $value"
}

fun main() = runBlocking {
    //可以捕获终止操作的异常
    try {
        myMethod().collect { value ->
            println(value)
            check(value <= 1) {
                "collected $value"
            }
        }
    } catch (e: Exception) {
        println(e)
    }

    println("----------------------")

    //也可以捕获发射操作和中间操作的异常
    try {
        myMethod2().collect { value -> println(value) }
    } catch (e: Exception) {
        println(e)
    }
}