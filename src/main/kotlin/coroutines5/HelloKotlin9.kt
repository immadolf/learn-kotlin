package coroutines5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    Buffer 缓冲
    Buffer的主要作用在于对发射的缓冲，减少等待时间。
    实际上，flowOn运算符本质上在遇到需要改变CoroutineDispatcher时也会使用同样的缓冲机制，只不过该示例并没有改变执行上下文而已。
 */

private fun myMethod(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)//模拟一个较为耗时的操作，该操作之后才开始流元素的发射
        emit(i)
    }
}

fun main() {
    runBlocking {
        val costTime = measureTimeMillis {
            myMethod().collect { value ->
                delay(200)
                println(value)
            }
        }
        println(costTime)//执行时间在900左右 (100 + 200) * 3
    }

    println("-------")

    runBlocking {
        val costTime = measureTimeMillis {
            myMethod().buffer().collect { value ->
                delay(200)
                println(value)
            }
        }
        println(costTime)//执行时间在700左右,todo buffer减少了哪里的耗时？
    }

}