package org.adolf.kotlin.demo10

/**
 * Kotlin与Java的互操作
 *
 * @author adolf
 * @date 2020/6/25
 * @since
 */
fun main() {
    val list = ArrayList<String>()
    list.add("hello")
    list.add("world")
    list.add("hello world")

    for (item in list) {
        println(item)
    }

    println("-------------")

    for (i in 0 until list.size) {
        println(list[i])
    }

    println("-------------")

    val person = Person()

    person.name = "张三"
    person.isMarried = false
    person.age = 20

    println(person)

    println("-------------")

    //在Java中，所有引用都可能为null，然而在Kotlin中，对null有着严格的检查和限制
    //这就使得某个来自Java的引用在Kotlin中变得不再适合；因此，在Kotlin中，将来自于Java的声明类型称为平台类型（Platform Types）
    //对于这种平台类型，Kotlin的null检查就会得到一定的缓和，变得不再严格，这样就使得空安全的语义要求变得和Java一致
    //当我们调用平台类型引用的方法时，Kotlin就不会在编译期间施加空安全的检查，使得编译可以正常通过，
    // 但是在运行期可能会抛出异常，因为平台类型的引用值可能为null

    val list2 = ArrayList<String>()
    list2.add("hello")

    val size = list2.size
    val item = list2[0]

    val s: String? = item
    val s2: String = item//可能会在运行期失败

}