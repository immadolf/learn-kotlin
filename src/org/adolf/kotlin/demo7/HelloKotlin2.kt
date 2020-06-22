package org.adolf.kotlin.demo7

/**
 * 集合
 *
 * Kotlin严格区分可变集合与不可变集合
 * 要清楚的一点：区分开**可变集合的只读视图**与**真正的不可变集合**
 *
 * @author 40313
 * @date 2020/6/22
 * @since
 */
fun main() {
    val stringList: MutableList<String> = mutableListOf("hello", "world", "hello,world")
    // 可变集合的只读视图
    val readOnlyView: List<String> = stringList

    println(stringList)// [hello, world, hello,world]

    stringList.add("welcome")

    println(readOnlyView) //[hello, world, hello,world, welcome]

    // readOnlyView.clear() 编译错误，不可变集合List中没有该方法

    println("-------------------")

    val strings: HashSet<String> = hashSetOf("a", "b", "c", "a")
    assert(strings.size == 3) // true

    println("-------------------")

    // 只读类型是协变的
    val a = listOf("a", "b")
    // 协变
    val a2: List<Any> = a

    println("-------------------")

    // 快照
    val item = mutableListOf("a", "b", "c")
    // toList是一个扩展方法，会复制原有集合中的数据，所以返回的集合就可以保证不会发生变化
    val item2 = item.toList()

    item.add("d")

    println(item)// [a, b, c, d]
    println(item2)// [a, b, c]
}