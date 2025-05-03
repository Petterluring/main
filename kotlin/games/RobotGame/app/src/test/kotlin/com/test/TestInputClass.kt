package com.test

import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.InputStream
import kotlin.test.assertEquals

class TestInputClass {

    @Test
    fun canTest() {
        val temp = InputClass()
        val originalIn: InputStream = System.`in`
        val testInput = "TestInput\n"
        System.setIn(ByteArrayInputStream(testInput.toByteArray()))

        val result = temp.askAndReturn()

        assertEquals("TestInput", result)
        System.setIn(originalIn)
    }
}