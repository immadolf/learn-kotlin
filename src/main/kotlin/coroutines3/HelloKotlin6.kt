package coroutines3

import kotlinx.coroutines.*

/**
 * 父子协程的异常与取消.
 * 当协程抛出**非**cancellationException时，它会变成取消状态，它的父协程也会因此取消，而父协程的取消会使得该父协程的子协程全部取消.
 *
 * @author 40313
 * @date 2020/7/8
 * @since
 */

fun main() = runBlocking {

    try {
        println(failureFun())
    } finally {
        println("22222222")
    }
}
private suspend fun failureFun(): Int = coroutineScope {
    val value1 = async {
        try {
            //这里实际上不会等待这么久
            delay(100000000)
            50
        } finally {
            println("11111")
        }
    }

    val value2: Deferred<Int> = async {
        delay(1000)
        throw Exception("abcd")
    }

    value1.await() + value2.await()
}