package coroutines4

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 对于父子协程来说，父协程总是会等待其所有子协程的完成，而不必显式的调用Job.join方法来等待协程的完成.
 *
 * @author 40313
 * @date 2020/7/15
 * @since
 */

fun main() = runBlocking {
    val request = launch {
        repeat(5) {
            launch {
                delay((it + 1) * 100L)
                println("coroutine:$it 执行完毕")
            }
        }
        println("hello")
    }

    //这里会挂起到所有子协程完成
    request.join()
    println("world")
}