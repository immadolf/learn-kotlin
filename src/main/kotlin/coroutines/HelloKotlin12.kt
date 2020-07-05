package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * 全局协程类似于守护线程。
 *
 * 守护线程是为其他线程服务的线程；在JVM中，所有非守护线程都执行完毕后，无论有没有守护线程，虚拟机都会自动退出。
 * 使用GlobalScope启动的活动协程并不会保持进程的生命
 *
 * @see <a href="https://www.liaoxuefeng.com/wiki/1252599548343744/1306580788183074">守护线程</a>
 *
 *
 *
 * @author adolf
 * @date 2020/7/5
 * @since
 */
fun main() {
    GlobalScope.launch {
        repeat(100) {
            //注意这里并没有使用launch来启动新的协程
            println("I am sleeping $it")
            delay(400)
        }
    }
    Thread.sleep(2000)
    //I am sleeping 0
    //I am sleeping 1
    //I am sleeping 2
    //I am sleeping 3
    //I am sleeping 4
}