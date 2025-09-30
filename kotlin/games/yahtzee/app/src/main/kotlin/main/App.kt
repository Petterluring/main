package main


import kotlin.reflect.KMutableProperty0

fun main() {
    var a = 5
    var b = 10
    val lst = listOf( {a}, {b} )
    println(lst[0].invoke())
    a = 10
    println(lst[0].invoke())

    println(lst[1].invoke())
    b = 15
    println(lst[1].invoke())
}