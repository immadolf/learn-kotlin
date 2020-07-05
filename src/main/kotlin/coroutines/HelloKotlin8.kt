package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 协程是轻量级的。
 *
 * 与HelloKotlin9Kt进行对比。
 * @see coroutines.HelloKotlin9Kt.main
 *
 * @author adolf
 * @date 2020/7/5
 * @since
 */
fun main() {
    val start = System.currentTimeMillis()
    runBlocking {
        //创建1w个协程并输出总耗时
        repeat(10000) { it: Int ->
            launch {
                delay(1000)
                println(it)
            }
        }
        println("hello")
    }
    println("cost: ${System.currentTimeMillis() - start} ms") //cost: 1378 ms
}