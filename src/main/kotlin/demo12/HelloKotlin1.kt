package org.adolf.kotlin.demo12

/**
 *
 *
 * @author 40313
 * @date 2020/6/30
 * @since
 */

fun List<String>.myFilter(): List<String> {
    println("List<String>.myFilter()")
    return emptyList()
}
/*

编译错误：泛型擦除导致的冲突
Platform declaration clash: The following declarations have the same JVM signature (myFilter(Ljava/util/List;)Ljava/util/List;):

fun List<Int>.myFilter(): List<Int> {
    return emptyList()
}
*/

//可以通过@JvmName注解来迂回解决
@JvmName("myFilter2")
fun List<Int>.myFilter(): List<Int> {
    println("List<Int>.myFilter()")
    return emptyList()
}

fun main() {
    listOf("1", "2").myFilter()
    listOf(1, 2).myFilter()
}
