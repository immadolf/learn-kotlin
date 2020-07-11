package coroutines4

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * 使用JVM参数输出协程名称：-Dkotlinx.coroutines.debug
 * 多线程跳转情况下的使用。
 *
 * @author 40313
 * @date 2020/7/11
 * @since
 */
private fun log(message: String) = println("[${Thread.currentThread().name}: $message]")

fun main() {
    newSingleThreadContext("context1").use { ctx1 ->
        newSingleThreadContext("context2").use { ctx2 ->
            runBlocking(ctx1) {
                log("start in ctx1")//[context1 @coroutine#1: start in ctx1]
                println("ctx1:$ctx1")
                withContext(ctx2) {
                    //注意这里的@coroutine#1不等于上面的@coroutine#1
                    log("work in ctx2")//[context2 @coroutine#1: work in ctx2]
                    println("ctx2:$ctx2")
                }
                log("back to ctx1")//[context1 @coroutine#1: back to ctx1]
                println("ctx1:$ctx1")
            }
        }
    }
}