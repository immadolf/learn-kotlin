package coroutines4

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 关于父子协程的关系.
 *
 * 当一个协程是通过另一个协程的CoroutineScope来启动的，那么这个协程就会通过CoroutineScope.coroutineContext来继承其上下文信息。
 * 同时，新协程的job也会成为父协程job的一个孩子；当父协程被取消执行时，该父协程的所有孩子都会通过递归的方式一并取消执行。
 *
 * 特例：当使用GlobalScope来启动协程时，对于启动的新协程来说，其Job是没有父Job的，因此，它就不会绑定到其所启动的那个范围上，故其可以独立执行。
 *
 * @author 40313
 * @date 2020/7/14
 * @since
 */

//GlobalScope的JavaDoc
/*
一个不绑定到任何作业的全局CoroutineScope。
全局作用域用于启动顶层的coroutine，这些coroutine在整个应用程序的生命周期内都在运行，不会过早地被取消。全局作用域的另一个用途是运行在Dispatchers.Unconfined中的操作符，
这些操作符没有与任何作业相关联。
应用程序代码通常应该使用应用程序定义的CoroutineScope。非常不鼓励在GlobalScope的实例上使用async或launch。
这个接口的用法可能是这样的：

fun ReceiveChannel<Int>.sqrt(): ReceiveChannel<Double> = GlobalScope.produce(Dispatchers.Unconfined) {
    for (number in this) {
        send(Math.sqrt(number))
    }
}
 */

/*
job1:1111
job2:1111
job1:2222
3333
 */
fun main() = runBlocking {
    val request = launch {
        GlobalScope.launch {
            println("job1:1111")
            delay(1000)
            println("job1:2222")
        }

        launch {
            delay(100)
            println("job2:1111")
            delay(1000)
            println("job2:2222")
        }
    }
    delay(500)
    request.cancel()
    delay(1000)
    println("3333")
}