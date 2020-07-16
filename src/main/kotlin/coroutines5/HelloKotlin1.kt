package coroutines5

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Flow出现的背景
 *
 * @author 40313
 * @date 2020/7/16
 * @since
 */

/*
直接返回一个集合的做法有两个特点：
1. 方法本身是阻塞的，即主线程会进入到该方法中执行，一直执行到该方法返回为止。
2. 集合本身是一次性返回给调用方的，即集合中的元素全部获取到后才一起返回给调用方
 */
private fun myMethod() = listOf("hello", "world", "hello,world")

fun main() {
    myMethod().forEach {
        println(it)
    }

    method2().forEach {
        println(it)
    }

    runBlocking {
        method3().forEach {
            println(it)
        }
    }
}

/*
Sequence 序列
如果在获取到每个元素时都需要执行一定的计算，这种计算是一种阻塞行为，将计算后的多个结果返回给调用方。
关于序列的特点：
1. 序列中的数据并非像集合那样一次性返回给调用方，而是计算完一个数据就返回一个数据
2. 序列中的计算过程会使用主线程来进行，因此它会阻塞主线程
 */
private fun method2(): Sequence<Int> = sequence {
    for (i in 100..105) {
        Thread.sleep(1000)
        yield(i)
    }
}

/**
 * 使用协程：
 * 1. 不阻塞主线程
 * 2. 结果一次性返回
 */
private suspend fun method3():List<String> {
    delay(1000)
    return listOf("hello", "world", "hello,world")
}