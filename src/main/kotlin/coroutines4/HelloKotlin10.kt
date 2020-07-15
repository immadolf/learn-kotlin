package coroutines4

import kotlinx.coroutines.*

/**
 * 可以用以下的方式来统一管理一个对象（特别是有生命周期的对象，例如安卓的activity，spring中的bean等）内部产生的协程，而无需手动保存每个协程返回的job对象。
 *
 * @author 40313
 * @date 2020/7/15
 * @since
 */
class Activity : CoroutineScope by CoroutineScope(Dispatchers.Default) {
    fun destroy() {
        cancel()
    }

    fun doSomeThing() {
        repeat(8) {
            launch {
                delay((it + 1) * 100L)
                println("Coroutine $it is finished")
            }
        }
    }
}

fun main() = runBlocking {
    val activity = Activity()
    activity.doSomeThing()
    println("启动协程")
    delay(300L)
    println("销毁activity")
    activity.destroy()
    delay(3000L)
}