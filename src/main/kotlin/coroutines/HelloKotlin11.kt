package coroutines

import kotlinx.coroutines.runBlocking

/**
 * suspend:被suspend关键字修饰的函数叫做挂起函数。
 *
 * 挂起函数(suspending function)
 *
 * 挂起函数只能用在协程中或者是另一个挂起函数中，也就是挂起函数中可以调用其他挂起函数
 *
 * @author adolf
 * @date 2020/7/5
 * @since
 */

fun main() = runBlocking {
    //在协程中使用挂起函数
    world()
}

suspend fun hello() {
    println("hello")
}

suspend fun world() {
    //可以在一个挂起函数中调用另一个挂起函数
    hello()
}