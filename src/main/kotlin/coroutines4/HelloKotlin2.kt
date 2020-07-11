package coroutines4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Dispatchers.Unconfined.
 *
 * Dispatchers.Unconfined会在调用者线程中启动协程，但仅仅会持续到第一个挂起点。
 * 当挂起结束后程序恢复执行时，他会继续协程代码的执行，但这时执行协程的线程是由之前所调用的挂起函数来决定的，即这个挂起函数由哪个线程来执行，后面的代码就由哪个线程来执行。
 * 该协程分发器适用于这样的协程：
 * 1. 它既不会消耗CPU时间
 * 2. 同时也不会更新任何共享的数据
 *
 * Dispatchers.Unconfined是一种高级的机制，它对于某些特殊情况是很有帮助作用的：协程分发是不需要的；或者会产生意料之外的副作用。因为协程中的操作必须立刻执行。
 *
 *
 *
 * @author 40313
 * @date 2020/7/11
 * @since
 */

fun main() = runBlocking<Unit> {
    launch(Dispatchers.Unconfined) {
        println("Dispatchers.Unconfined,thread:${Thread.currentThread().name}")//Dispatchers.Unconfined,thread:main
        delay(200)
        println("Dispatchers.Unconfined,thread:${Thread.currentThread().name}")//Dispatchers.Unconfined,thread:kotlinx.coroutines.DefaultExecutor
    }

    launch {
        println("no param,thread:${Thread.currentThread().name}")//no param,thread:main
        delay(300)
        println("no param,thread:${Thread.currentThread().name}")//no param,thread:main
    }
}