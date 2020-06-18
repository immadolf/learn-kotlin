package org.adolf.kotlin.demo2

/**
 * @UnsafeVariance 使协变类型可以用在参数上
 *
 * @author 40313
 * @date 2020/6/18
 * @since
 */

class MyStorage<out T>(private var t: T) {

    fun getValue() = this.t

    // 编译错误
//    fun setValue(t: T) {
//
//    }

    fun setValue(t: @UnsafeVariance T) {
        this.t = t
    }
}

fun main() {
    var myStorage: MyStorage<Int> = MyStorage(5)
    var myStorage2: MyStorage<Any> = myStorage

    val value = myStorage2.getValue() // value的类型是any，说明已经协变

    myStorage2.setValue("hello")
    println(myStorage2) //org.adolf.kotlin.demo2.MyStorage@1d810a49 结果不是一个Int 原因是泛型擦除


}