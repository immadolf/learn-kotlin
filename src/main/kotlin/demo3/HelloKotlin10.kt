package org.adolf.kotlin.demo3

/**
 * 枚举 enum
 *
 * @author adolf
 * @date 2020/6/21
 * @since
 */
enum class Season {
    SPRING, SUMMER, AUTUMN, WINTER
}

enum class Season2(val tempearture: Int) {
    SPRING(10), SUMMER(30), AUTUMN(20), WINTER(-10)
}

enum class Season3 {
    SPRING {
        override fun getSeason(): Season3 = SPRING

    },
    SUMMER {
        override fun getSeason(): Season3 = SUMMER

    },
    AUTUMN {
        override fun getSeason(): Season3 = AUTUMN

    },
    WINTER {
        override fun getSeason(): Season3 = WINTER
    };


    abstract fun getSeason(): Season3
}

fun main(args: Array<String>) {
    val seasons = Season.values()
    seasons.forEach { season: Season -> println(season) }
    seasons.forEach { println(it) }

    println("-------------")

    val season = Season.valueOf("SPRING")
    println(season.name)
}