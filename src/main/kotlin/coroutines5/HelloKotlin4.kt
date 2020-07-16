package coroutines5

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

/*
    Flow builder(流的构建器)

    1.flow是最经常被使用的流构建器
    2.flowOf构建器可以用于定义发射固定数量值的流
    3.对于各种集合和序列来说，他们都提供了asFlow的扩展方法来将自身转换为flow
 */

fun main() {
    runBlocking {
        (1..10).asFlow().collect { println(it) }
    }

    println("-----")

    runBlocking {
        flowOf(10, 20, 30).collect { println(it) }
    }
}