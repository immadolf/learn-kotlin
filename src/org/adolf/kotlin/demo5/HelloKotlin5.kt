package org.adolf.kotlin.demo5

/**
 * lambda格式
 *
 * lambda表达式格式要求
 * 1. 一个lambda表达式总是被一对花括号所包围
 * 2. 其参数位于 -> 之前(参数类型是可以省略掉的)
 * 3. 执行体位于 -> 之后
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */

val multiPly: (Int, Int) -> Int = { a, b -> a * b }
val add: (Int, Int) -> Int = { a, b -> a + b }
val subtract = { a: Int, b: Int -> a - b }
val myAction = { println("hello world") }

val mayReturnNull: (Int, Int) -> Int? = { _, _ -> null }

val nullAbleAction: ((Int, Int) -> Int)? = null