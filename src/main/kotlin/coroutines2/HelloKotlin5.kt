package coroutines2

import kotlinx.coroutines.*

/**
 * withContext(NonCancellable)
 *
 * @author 40313
 * @date 2020/7/7
 * @since
 */
fun main() = runBlocking {
    val myJob = GlobalScope.launch {
        try {
            repeat(100) {
                println("job: I am sleeping $it")
                delay(500)
            }
        } finally {
            println("执行了finally代码块")
            //在协程的finally块中执行挂起函数，会抛出CancellationException
            //原因在与运行该代码块的协程已经被取消了，通常情况下这不会产生什么问问题，因为大多数关闭操作（如取消一个job，关闭网络连接等）都是非阻塞的，所以不需要使用挂起函数。
            //在极少数情况下，如果我们需要在一个已经取消的协程中进行挂起函数时，可以将相应的代码放到withContext(NonCancelable) {}中，在这种结构中，我们实际上使用了withContext函数与NonCancelable上下文
            delay(1000)
            //这行代码不会打印
            println("在delay后执行的代码片段")

            //修改后如下，运行这段代码的时候需要把前面三句注释掉
            withContext(NonCancellable) {
                println("执行了finally代码块")
                delay(1000)
                println("在delay后执行的代码片段")
            }
        }
    }

    delay((1100))
    println("hello world")

    myJob.cancelAndJoin()

    println("aaa")
}