package coroutines2

import kotlinx.coroutines.*

/**
 * 使用finally关闭资源。
 *
 * join和cancelAndJoin都会等待所有清理动作完成才会继续往下执行
 *
 * @author 40313
 * @date 2020/7/6
 * @since
 */
fun main() = runBlocking {
    val myJob = GlobalScope.launch {
        try {
            repeat(100) {
                println("job: I am sleeping $it")
                //delay内部就会检查isActive属性
                delay(500)
            }
        } finally {
            //join和cancelAndJoin都会等待所有清理动作完成才会继续往下执行
            println("执行了finally代码块")
        }
    }

    delay((1100))
    println("hello world")

    myJob.cancelAndJoin()

    println("aaa")
}