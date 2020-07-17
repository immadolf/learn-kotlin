package coroutines5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Flatten Flow 打平
 *
 * @author 40313
 * @date 2020/7/17
 * @since
 */
private fun myMethod(i: Int): Flow<String> = flow {
    emit("$i:First")
    delay(100)
    emit("$i:second")
}

fun main() {
    runBlocking {
        val startTime = System.currentTimeMillis()
        (1..3).asFlow().onEach { delay(100) }
            .flatMapConcat { myMethod(it) }
            .collect { value -> println("$value at ${System.currentTimeMillis() - startTime} ms") }
    }
}