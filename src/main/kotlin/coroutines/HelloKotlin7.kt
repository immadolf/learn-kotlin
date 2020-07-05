package coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 除去不同的协程构建器所提供的协程作用域外，还可以通过CoroutineScope builder来声明自己的协程作用域，
 * 该构建器会创建一个协程作用域，并会等待所有启动的子协程全部完成后，自身才会完成。
 *
 * runBlocking 和 coroutineScope之间的主要差别在于，后者在等待所有子协程完成的时候，**不会阻塞**当前线程。
 *
 * @author adolf
 * @date 2020/7/5
 * @since
 */

//运行结果：2,1,4,3,5
fun main() = runBlocking {
    //runBlocking会启动一个协程：BlockingCoroutine{Active}@c43d9509

    //launch会启动一个后台协程：StandaloneCoroutine{Active}@4391db75
    launch {
        delay(1000)
        //当1秒钟后，这里的协程StandaloneCoroutine{Active}@4391db75解除挂起，变成可运行，而当时其他几个协程都在挂起中，因此这里的代码被执行
        println("1:${this.coroutineContext}")//StandaloneCoroutine{Active}@4391db75
    }

    //先输出2，这里没疑问，执行这段代码的协程是runBlocking创建的协程
    println("2:${this.coroutineContext}") //BlockingCoroutine{Active}@c43d9509

    //coroutineScope会创建一个新的协程：ScopeCoroutine{Active}@781a3436
    //coroutineScope创建的协程，会等待所有子协程完成后，才会完成自身，因此需要等20秒后StandaloneCoroutine{Active}@bf0688c4协程结束，
    //ScopeCoroutine{Active}@781a3436协程才能结束
    coroutineScope {
        //launch会启动一个后台协程：StandaloneCoroutine{Active}@bf0688c4
        launch {
            //这个后台协程会挂起20秒
            delay(20 * 1000)
            println("3:${this.coroutineContext}")//StandaloneCoroutine{Active}@bf0688c4
        }

        //执行这段代码的协程是coroutineScope创建的协程，即ScopeCoroutine{Active}@781a3436，这里这个协程遇到delay后挂起
        delay(5 * 1000)
        //5秒钟后这里的协程结束挂起，且其他协程都在挂起，因此执行这里的代码
        println("4:${this.coroutineContext}")//ScopeCoroutine{Active}@781a3436
    }

    //这里是最后执行的，因为coroutineScope方法是一个suspend的方法，和delay差不多，同样是阻塞流程但是不阻塞线程，
    //因此这里需要等到coroutineScope方法结束才能得到执行
    println("5:${this.coroutineContext}")//BlockingCoroutine{Active}@c43d9509
}