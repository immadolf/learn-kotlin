package coroutines4

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * coroutineContext的plus运算符重载.
 * 配合jvm参数：-Dkotlinx.coroutines.debug
 *
 * @author 40313
 * @date 2020/7/15
 * @since
 */

fun main() = runBlocking {
    //同时指定分发器和协程名
    launch(Dispatchers.Default + CoroutineName("myCoroutine1")) {
        println("thread:${Thread.currentThread().name}")
    }

    println("thread:${Thread.currentThread().name}")
}