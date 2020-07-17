package coroutines5

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Flow的完成。
 *
 * Kotlin提供了两种方式来实现Flow的完成
 * 1. 命令式
 * 2. 声明式
 *
 * @author 40313
 * @date 2020/7/17
 * @since
 */

private fun myMethod(): Flow<Int> = (1..3).asFlow()
private fun myMethod2(): Flow<Int> = flow {
    emit(1)
    throw RuntimeException("this is a exception")
}


fun main() {
    // 命令式
    runBlocking {
        try {
            myMethod().collect { println(it) }
        } finally {
            println("finally")
        }
    }

    println("----------------------")

    //声明式，flow提供了一个onCompletion中间操作，该操作会在flow完成终止操作后执行
    runBlocking {
        myMethod().onCompletion { println("finally") }.collect { println(it) }
    }

    println("----------------------")

    //onCompletion的优势在于它有个可空参数throwable，可以通过是否有这个参数来判断flow是否出现异常
    runBlocking {
        myMethod2().onCompletion { cause: Throwable? -> cause ?: println("finally") }
            .catch { cause -> println("exception:$cause") }
            .collect { println(it) }
    }

}