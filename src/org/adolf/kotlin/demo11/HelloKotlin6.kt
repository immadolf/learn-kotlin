package org.adolf.kotlin.demo11

/**
 * Java访问kotlin中的伴生对象
 *
 * @author 40313
 * @date 2020/6/29
 * @since
 */
class People2 {
    companion object {
        val name = "zhangsan"

        @JvmField
        var age = 20
    }
}