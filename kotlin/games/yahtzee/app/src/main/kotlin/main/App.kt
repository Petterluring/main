package main

import kotlin.random.Random


fun main() {
    val lst = listOf(1, 2, 3)
    val lst1 = lst.map { i -> i + 1 }
    println(lst1)
}