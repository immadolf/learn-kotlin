package coroutines2

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * withTimeout函数所抛出的TimeoutCancellationException异常是CancellationException的子类，当该异常抛出时，我们并未
 * 在控制台上看到完整的堆栈信息，这是因为在取消的协程中，CancellationException被认为是一种协程完成的正常原因。
 *
 * 既然CancellationException仅仅是个异常，并且所有的资源也都会以通常的方式来关闭，那么我们就可以将代码块放到try--catch中；
 * 此外kotlin还提供了一个更加友好的函数：withTimeoutOrNull，区别在于它不会抛出异常，而是返回null。
 *
 * @author 40313
 * @date 2020/7/7
 * @since
 */

fun main() = runBlocking {
    val result = withTimeoutOrNull(1000) {
        repeat(1000) {
            println(it)
            delay(300)
        }
        return@withTimeoutOrNull "hello world"
    }

    //result: null
    println("result: $result")
}
