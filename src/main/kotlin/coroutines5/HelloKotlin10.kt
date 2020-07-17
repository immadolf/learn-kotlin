package coroutines5

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

/**
 * Flow的组合
 *
 * @author 40313
 * @date 2020/7/17
 * @since
 */
fun main() {
    runBlocking {
        val nums = (1..5).asFlow()
        var strs = flowOf("a", "b", "c", "d", "e")

        nums.zip(strs) { a, b ->
            "$a -> $b"
        }.collect {
            println(it)
        }
    }
}