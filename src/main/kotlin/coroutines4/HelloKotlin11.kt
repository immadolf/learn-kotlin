package coroutines4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.asContextElement
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield

/*
    协程局部变量.
    配合jvm参数：-Dkotlinx.coroutines.debug
 */

val threadLocal = ThreadLocal<String>()

//结合下面的文档翻译做一些测试

fun main() {
    runBlocking {
        //context元素并不跟踪thread-local的修改
        threadLocal.set("hello")
        println("pre main, current thread:${Thread.currentThread().name},thread local value:${threadLocal.get()}")

        val job = launch(Dispatchers.Default + threadLocal.asContextElement(value = "world")) {
            println("launch start, current thread:${Thread.currentThread().name},thread local value:${threadLocal.get()}")
            yield()
            println("after yield, current thread:${Thread.currentThread().name},thread local value:${threadLocal.get()}")
        }

        job.join()

        println("post main, current thread:${Thread.currentThread().name},thread local value:${threadLocal.get()}")

        println("--------------")
        val threadLocal2 = ThreadLocal.withInitial { "init" }
        //默认情况下,即不指定asContextElement方法的value值，当前线程的ThreadLocal.get()方法的值将被用作协程中ThreadLocal的值
        println("current thread:${Thread.currentThread().name},threadLocal2 before launch:${threadLocal2.get()}")//current thread:main @coroutine#1,threadLocal2 before launch:init
        val job2 = GlobalScope.launch(threadLocal2.asContextElement()) {
            println("current thread:${Thread.currentThread().name},threadLocal2 in launch:${threadLocal2.get()}")//current thread:DefaultDispatcher-worker-1 @coroutine#3,threadLocal2 in launch:init
        }
        job2.join()
        println("current thread:${Thread.currentThread().name},threadLocal2 after launch:${threadLocal2.get()}")//current thread:main @coroutine#1,threadLocal2 after launch:init



        println("--------------")
        // todo 这个例子我本地跑了几次都无法出现modified的情况，而且我不太理解这个例子和上面第一个普通的例子有什么区别，等我更深入的了解协程之后再回来看看这个问题
        val tl = ThreadLocal.withInitial { "initial" }
        println(tl.get()) // Will print "initial"
        // Change context
        withContext(tl.asContextElement("modified")) {
            println(tl.get()) // Will print "modified"
        }
        // Context is changed again
        println(tl.get()) // <- WARN: can print either "modified" or "initial"

        println("--------------")
        //协程挂起后，在协程内部对threadLocal进行的修改将会被丢弃,前提是需要显式指定使用asContextElement方法，也就是说如果不写threadLocal3.asContextElement("bilibili")，那就不成立
        val threadLocal3 = ThreadLocal.withInitial { "init" }
        println("current thread:${Thread.currentThread().name},threadLocal3 before launch:${threadLocal3.get()}")//current thread:main @coroutine#1,threadLocal3 before launch:init
        val job3 = launch(Dispatchers.Default + threadLocal3.asContextElement("bilibili")) {
            println("current thread:${Thread.currentThread().name},threadLocal3 in launch:${threadLocal3.get()}")//current thread:DefaultDispatcher-worker-1 @coroutine#5,threadLocal3 in launch:bilibili
            threadLocal3.set("abc")
            println("current thread:${Thread.currentThread().name},threadLocal3 in launch after modify:${threadLocal3.get()}")//current thread:DefaultDispatcher-worker-1 @coroutine#5,threadLocal3 in launch after modify:abc
            yield()
            println("current thread:${Thread.currentThread().name},threadLocal3 in launch after yield:${threadLocal3.get()}")//current thread:DefaultDispatcher-worker-1 @coroutine#5,threadLocal3 in launch after yield:bilibili
        }
        job3.join()
        println("current thread:${Thread.currentThread().name},threadLocal3 after launch:${threadLocal3.get()}")//current thread:main @coroutine#1,threadLocal3 after launch:init

    }
}

/*
asContextElement的文档翻译如下：

将ThreadLocal包装成ThreadContextElement。
生成的ThreadContextElement为coroutine维护给定的ThreadLocal的值，而不管它是在哪个线程上恢复的。
默认情况下，ThreadLocal.get被用作线程局部变量的值，但它可以被value参数重写。
要注意的是，context元素并不跟踪thread-local的修改，在没有相应的context元素的情况下，从coroutine访问thread-local会返回未定义的值。
详细说明请参见示例：
val myThreadLocal = ThreadLocal<String?>()
...
println(myThreadLocal.get()) // Prints "null"
launch(Dispatchers.Default + myThreadLocal.asContextElement(value = "foo")) {
  println(myThreadLocal.get()) // Prints "foo"
  withContext(Dispatchers.Main) {
    println(myThreadLocal.get()) // Prints "foo", but it's on UI thread
  }
}
println(myThreadLocal.get()) // Prints "null"

context元素并不跟踪theadLocal的修改, for example:
myThreadLocal.set("main")
withContext(Dispatchers.Main) {
  println(myThreadLocal.get()) // Prints "main"
  myThreadLocal.set("UI")
}
println(myThreadLocal.get()) // Prints "main", not "UI"

使用 withContext 来改变对应thread-local变量的值, for example:
withContext(myThreadLocal.asContextElement("foo")) {
    println(myThreadLocal.get()) // Prints "foo"
}

Accessing the thread-local without corresponding context element leads to undefined value:
val tl = ThreadLocal.withInitial { "initial" }

runBlocking {
  println(tl.get()) // Will print "initial"
  // Change context
  withContext(tl.asContextElement("modified")) {
    println(tl.get()) // Will print "modified"
  }
  // Context is changed again
   println(tl.get()) // <- WARN: can print either "modified" or "initial"
}
to fix this behaviour use runBlocking(tl.asContextElement())
 */