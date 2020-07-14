package coroutines4

import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.runBlocking

/**
 * Job的使用方式以及在Context中的具体应用。
 *
 * 协程Job是归属于其上下文(Context)的一部分，Kotlin为我们提供了一种简洁的方法来通过协程上下文获取到协程自身的Job对象.
 *
 * @author 40313
 * @date 2020/7/13
 * @since
 */
fun main() {
    runBlocking {
        //coroutineContext是CoroutineScope的属性
        //[]是运算符重载
        //注意这里的方括号和?
        //这里实际上需要的是Job.Key,也就是Job的伴生对象
        val job = coroutineContext[Job]
        println(job)
        //job不为空时以下写法等价
        println(coroutineContext.isActive)
        println(coroutineContext[Job]?.isActive)
        println(job?.isActive)
    }
    //可以用类名代替伴生对象,从反编译的结果可以看出是编译器做了手脚，它会把这里的A替换成A.key
    //虽然这样写很方便，但是对于阅读者来说又造成了一定的困扰，kotlin是不是过度追求简洁了？把很多细节都隐藏在编译器里，这样真的好吗？
    method(A)
}

interface B

class A {
    companion object Key : B {
        fun say() {
            println("hello")
        }
    }
}

fun method(b: B) {

}