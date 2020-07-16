package coroutines5

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/*
    Flow是顺序执行的。

    对于Flow对收集操作来说，它是运行在调用了终止操作对那个协程上，默认情况下，它是不会启动新对协程对。每个emit元素值都会由所有对中间操作进行处理，
    最后再由终止操作进行处理。本质上，就是由上游进入到了下游。
 */

fun main() {
    runBlocking {
        (1..5).asFlow().filter {
            println("filter:$it")
            true
        }.map {
            println("map:$it")
            "hello:$it"
        }.collect { println(it) }
    }
}