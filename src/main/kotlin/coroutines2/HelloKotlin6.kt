package coroutines2

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

/**
 * 协程的超时机制。
 *
 * 我们使用协程时，如果取消了协程，那么很大一部分原因都在于协程的执行时间超过了某个设定值，我们可以通过手动引用与协程对应的Job的方式来启动另一个协程用于取消这协程，
 * 不归kotlin内置了函数来帮我们做到这一点。
 *
 * @author 40313
 * @date 2020/7/7
 * @since
 */
fun main() = runBlocking {

    /**
     *  0
     *  1
     *  2
     *  Exception in thread "main" kotlinx.coroutines.TimeoutCancellationException: Timed out waiting for 1000 ms
     */
    //注意withTimeout函数会抛出异常
    withTimeout(1000) {
        repeat(10) {
            println("$it")
            delay(400)
        }
    }
}