package coroutines

/**
 * 对kotlin中lambda的一些说明.
 *
 * @author adolf
 * @date 2020/7/5
 * @since
 */

fun main() {
    //同样的函数体，可以用在不同的函数签名上
    //因为当只有一个参数时，kotlin中这个参数可以省略不写，默认为it
    //不知道这样的语法糖到底是好事还是坏事，我觉得对于阅读的人来说容易造成困扰，idea对这种写法有特殊提示，不用idea的人咋办。。。
    //给我的感觉和gradle很像，灵活的让人不知所措。。。
    test {
        println("111")
    }
    //test的完整写法
    test { ->
        println("111")
    }

    test2 {
        println("111")
    }

    //test2的完整写法
    test2 { it: Int ->
        println("111")
    }

    test(::test3)
    test2(::test4)
    test5(5, ::test6)

    //这里会编译错误，和test2不同，只有一个参数的时候才可以省略
//    test5(5,action = {
//        println("a")
//    })
}

fun test(action: () -> Unit) {

}

fun test2(action: (Int) -> Unit) {

}

fun test3() {

}

fun test4(x: Int) {

}

fun test5(x: Int, action: (Int, Int) -> Unit) {

}

fun test6(x: Int, y: Int) {

}