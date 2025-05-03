package com.test

class InputClass {


    fun askAndReturn(): String {
        print("Insert a message")
        val value = readln()
        return value
    }
}