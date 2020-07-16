package coroutines5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

/*
    Flow的中间运算符。

    Flow的中间运算符的思想与Java Stream完全一致。

    Flow与Sequence之间在中间运算符上的重要差别在于：对于Flow来说，这些中间运算符的代码块是可以调用挂起函数的。
 */

private suspend fun myExecution(input: Int) :String {

    delay(1000)
    return "output:$input"
}


private fun emit5Value():Flow<Int> = flow {

    try {
        for (i in 1..5) {
            emit(i)
        }
    } catch (e: Exception) {
        //kotlin底层是通过异常来终止流，从而实现只取几个的操作
        println(e)
    } finally {
        println("finally")
    }
}

fun main() {
    runBlocking {
        (1..10).asFlow()
            .filter { it > 5 }
            .map { input -> myExecution(input) }
            .collect { println(it) }
    }

    println("--------------------")
    //transform 更为通用的转换操作
    runBlocking {
        (1..10).asFlow().transform { input ->
            emit("my input:$input")
            emit(myExecution(input))
            emit("hello world")
        }.collect { println(it) }
    }

    println("--------------------")

    //限定大小的中间操作
    runBlocking {
        emit5Value().take(3).collect { println(it) }
    }
}