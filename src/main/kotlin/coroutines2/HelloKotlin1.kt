package coroutines2

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 协程的取消与超时.
 *
 * @author 40313
 * @date 2020/7/6
 * @since
 */
fun main() = runBlocking {
    val myJob = GlobalScope.launch {
        repeat(200) {
            println("hello:$it")
            //delay内部就会检查isActive属性
            delay(500)
        }
    }

    delay((1100))
    println("hello world")

    //取消协程
    myJob.cancel()
    //带原因的取消
    //myJob.cancel(CancellationException(("bbbbb")))
    //因为上面的myJob是用globalScope创建的，因此这里需要手动join来挂起流程
    myJob.join()

    //myJob.cancelAndJoin() 综合了cancel和join

    println("aaa")
}