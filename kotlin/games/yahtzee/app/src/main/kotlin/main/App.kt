package main

import kotlin.random.Random


fun main() {
    println(Random.nextInt(5))
    val min = 1
    val max = 6
    for (v in 1..20) {
        println(Random.nextInt(max + 1 - min) + min)
    }
}