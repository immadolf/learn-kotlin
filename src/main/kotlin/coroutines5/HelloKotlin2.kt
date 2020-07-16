package coroutines5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
  Flow的使用。

  如果返回List<String>结果类型，那么就表示只能一次性返回所有值。要想能够表示可以异步计算的流式的值，
  我们就可以使用Flow<String>类型，它非常类似于Sequence<String>类型，但其值是异步计算的。

  1. Flow构建器是通过flow来实现的。
  2. 位于flow{}构建器中的代码是可以挂起的。
  3. myMethod方法无需再使用suspend标志符，值是通过emit函数来发射出来的。
  4. Flow里面的值是通过collect方法来收集的。

 */

private fun myMethod(): Flow<Int> = flow {
    for (i in 1..4) {
        //注意这里并不是suspend修饰的函数，但是可以直接使用delay函数
        delay(100)
        emit(i)
    }
}

fun main() {
    //第一个例子的结果是交替输出的
    runBlocking {
        launch {
            for (i in 1..4) {
                println("hello $i")
                delay(200)
            }
        }
        myMethod().collect { println(it) }
    }

    println("------------")

    runBlocking {
        println(1111)
        //只有当调用了Flow对象上的终止操作（如collect）之后，Flow才会真正执行
        myMethod()
        println(2222)
    }

    println("------------")

    runBlocking {
        val flow = myMethod()
        //这个例子的结果是输出两遍1234
        //可以说明两个点：1：一个flow对象可以重复执行；2：collect会阻塞流程，说明它是一个挂起函数
        flow.collect{ println(it)}
        flow.collect{ println(it)}
    }


}