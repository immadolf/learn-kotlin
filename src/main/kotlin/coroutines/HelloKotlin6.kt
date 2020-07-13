package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 每一个Coroutine builder(如launch、async等)以及每一个作用域函数(如coroutineScope,withContext等)都提供了它自己的scope和它自己的job实例到它所运行的内部代码块(block，即闭包)中。
 * 根据约定，它们都要等待它们内部代码块(block，即闭包)中的协程运行完毕之后才能完成它们自身，这样可以强制实现结构化并发的原则。
 *
 * 每一个协程构建器都会向其代码块作用域中添加一个coroutineScope实例，当我们在该作用域中启动协程时，无需显式调用新协程的join方法，因为外部协程会等待该作用域中的所有启动的协程全部完成后才会完成。
 *
 * @author adolf
 * @date 2020/7/5
 * @since
 */

//！！！！！！！
//runBlocking {} 只是传递一个闭包给runBlocking函数去执行，并不代表runBlocking本身全部的内容
//总是习惯性的把{}中的内容当成是runBlocking的完整内容，还是需要多用多练习才行。
//！！！！！！！

//block: suspend CoroutineScope.() -> Unit  这样的声明方式，是说明block函数需要一个CoroutineScope对象作为参数，更准确的说是作为上下文对象this
//相当于block: suspend (CoroutineScope) -> Unit
//疑问：runBlocking会阻塞线程，那为什么launch中输出的线程还是main线程？？？
fun main() = runBlocking {
    //注意这里不带GlobalScope
    //完整的写法是这样，带上this，这个this指代的是runBlocking函数创建的scope
    //runBlocking是一个协程构建器，每一个协程构建器都扩展了CoroutineScope（也就是说协程构建器会自动创建CoroutineScope），
    //传递给runBlocking函数的闭包block就是运行在runBlocking函数创建的scope的上下文中，就是说block中的this指向的是runBlocking函数创建的scope对象
    //而launch函数是CoroutineScope的(扩展)函数，在上下文对象this是CoroutineScope的环境中调用一个CoroutineScope类的函数(launch)，
    //这不就是直接调用这个this对象的launch方法吗！
    //而之前使用的GlobalScope.launch，则是**明确指定**调用另一个对象GlobalScope的launch函数
    this.launch {
        println("launch:${Thread.currentThread().name}")//launch:main
        delay(1000)
        println("kotlin coroutines")
    }

    println("world")
    println("run:${Thread.currentThread().name}")//run:main

    test()
}


//以下为对runBlocking和launch这种写法的思考

class MyScope

//没有带接收者类型时，这个函数的意思是接收一个block作为参数，block是一个函数，入参是Int，返回是String
fun testA(block: (Int) -> String) {
    println(block(1))
}

/**
 * 从testA中演化过来，参数多了一个接收者类型。
 * 意思是接收一个block作为参数，block是MyScope类型的一个函数，入参是Int，返回值是String
 * 调用这个函数参数block时需要提供两个参数，一个是扩展函数的接收者对象，在这里就是MyScope的对象，一个是扩展函数本身需要的参数，也就是一个Int值
 */
fun testRunBlocking(block: MyScope.(Int) -> String) {
    println("do something")
    val myScope = MyScope()
    println("testRunBlocking$myScope")
    println(block(myScope, 1))

    println("do something")
}

fun MyScope.testLaunch(block: MyScope.(Int) -> String) {
    println("do something")
    println("testLaunch: $this")
    block(this, 1)
    println("do something")
}

//这个等同于main
fun test() {
    //调用testRunBlocking时只需要提供一个入参是Int，返回值是String的函数即可
    testRunBlocking {
        this.testLaunch {
            println(this)
            it.toString()
        }
        return@testRunBlocking "111"
    }

}