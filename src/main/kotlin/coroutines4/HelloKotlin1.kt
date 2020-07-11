package coroutines4

import kotlinx.coroutines.*
import java.util.concurrent.Executors

/**
 * 协程与线程之间的关系。
 *
 * 协程上下文与分发器（Coroutine Context 与 Dispatcher）
 *
 * 协程总是会在某个上下文中执行，这个上下文实际上是由CoroutineContext类型的一个实例来表示的，该实例是由Kotlin标准库来定义的。
 *
 * 协程上下文本质是各种元素锁构成的一个集合。其中，主要的元素包括协程的Job，以及分发器。
 *
 * 所谓的分发器，主要功能就是确定由哪个线程来执行我们指定的协程代码。
 *
 * 协程上下文包含了一个协程分发器（CoroutineDispatcher），协程分发器确定了到底由哪个线程或者是线程池来执行我们所指定的协程。
 * 协程分发器可以将协程的执行限制到一个具体的指定的线程，也可以将协程的执行分发到一个线程池中，由线程池中的某个线程来执行我们所指定的协程，
 * 还可以不加任何限制地去执行我们所指定的代码(在这种情况下，我们所指定的协程代码到底是由哪个线程或线程池来执行是不确定的，它需要根据程序
 * 的实际执行情况来确定，这种方法的协程分发器在一般的开发中使用较少，它只用在一些极为特殊的情况下)。
 *
 * 所有的携程构建器(coroutine builder),如launch和async都会接收一个可选的CoroutineContext参数，该参数可用于显式指定新携程所运行的分发器
 * 以及其他的上下文元素。
 *
 *
 * @author 40313
 * @date 2020/7/9
 * @since
 */

fun main() = runBlocking<Unit> {
    //当通过launch来启动协程并且不指定协程分发器时，它会继承启动它的那个CoroutineScope的上下文与分发器，
    //对于该示例来说，它会继承runBlocking的上下文，而runBlocking则是运行在main线程中。
    launch {
        println("no param,this:$this")
        println("no param,thread:${Thread.currentThread().name}")
    }

    //Dispatchers.Unconfined是一种很特殊的协程分发器，它在该示例中它恰好是运行在main线程中，但实际上，其运行机制与不指定协程分发器时是完全不同的。
    //在日常的开发中使用的很少。
    launch(context = Dispatchers.Unconfined) {
        println("Dispatchers.Unconfined,this:$this")
        println("Dispatchers.Unconfined,thread:${Thread.currentThread().name}")
    }

    //Dispatchers.Default是默认的协程分发器，当协程是通过GlobalScope来启动的时候，它会使用默认的分发器来启动协程，
    //它会使用一个后台的共享线程池来运行代码，因此，launch(Dispatchers.Default) {} 等同于 GlobalScope.launch {}
    launch(context = Dispatchers.Default) {
        println("Dispatchers.Default,this:$this")
        println("Dispatchers.Default,thread:${Thread.currentThread().name}")
    }

    GlobalScope.launch {
        //delay(1000)//这里加了delay函数，就不会打印下面这行字，原因是这里的scope并不是runBlocking的scope，runBlocking不会等它完成
        //但是奇怪的是，理论上即使不加delay，也有可能不输出下面这行字，但实际上每次都输出，是因为执行的太快了吗？
        println("GlobalScope.launch,this:$this")
    }

    //Executors.newSingleThreadExecutor().asCoroutineDispatcher()创建一个单独的线程池来执行我们所制定的协程代码
    //这里需要使用close方法将协程分发器关闭(同时也就关闭了线程池)，否则jvm进程无法退出
    //在实际开发中，也可以将该协程分发器放到顶级变量中，从而实现复用。
    val thread = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
    launch(thread) {
        println("Executors.newSingleThreadExecutor,this:$this")
        println("Executors.newSingleThreadExecutor,thread:${Thread.currentThread().name}")
        thread.close()//注意是在launch方法体中
    }
}