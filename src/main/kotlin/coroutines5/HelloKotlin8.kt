package coroutines5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/*
    Flow Context Flow的上下文。

    Flow的收集动作总是发生在调用协程的上下文当中，这个特性叫做Context Preservation 上下文保留。

    搭配jvm参数：-Dkotlinx.coroutines.debug
 */
private fun log(msg: String) = println("[${Thread.currentThread().name}],$msg")

private fun myMethod(): Flow<Int> = flow {
    log("started")

    for (i in 1..3) {
        emit(i)
    }
}

private fun myMethod2(): Flow<Int> = flow {
    //这里会抛出异常Exception in thread "main" java.lang.IllegalStateException: Flow invariant is violated:
    //当一个Flow的发射和收集不在同一个context当中时，会抛出这个错误
    //正确的用法见myMethod3
    withContext(Dispatchers.Default) {
        log("started")

        for (i in 1..3) {
            emit(i)
        }
    }
}

/*
    借助于flowOn，可以让Flow在发射元素时所处的上下文与收集时所处的上下文时不同的。
    值得注意的是：flowOn运算符改变了Flow本身的顺序性。
    现在，收集操作实际上是发生在一个协程中，而发射操作发生在另一个协程中。
    flowOn运算符本质上会改变上下文中的CoroutineDispatcher，并且为上游的flow创建另一个协程。
 */
private fun myMethod3(): Flow<Int> = flow {
    log("started")

    for (i in 1..3) {
        log("emit:$i")
        emit(i)
    }
}.flowOn(Dispatchers.Default)

fun main() {
    runBlocking {
        myMethod().collect { log("collected:$it") }
    }

//    println("------")
//
//    runBlocking {
//        myMethod2().collect { log("collected:$it") }
//    }

    println("------")

    runBlocking {
        myMethod3().collect { log("collected:$it") }
    }
}