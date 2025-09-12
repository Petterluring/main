package com.die

import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DieTest {
    private val die = Die(1, 6)

    @Test
    fun `assigns variables correctly`() {
        assertEquals(1, die.minValue)
        assertEquals(6, die.maxValue)
        assertEquals(1, die.currentValue)
    }

    @Test
    fun `can assign currentValue correctly`() {
        for (v in 1 ..6) {
            die.currentValue = v
            assertEquals(v, die.currentValue)
        }
        assertThrows<IllegalArgumentException> { die.currentValue = die.maxValue + 1 }
        assertThrows<IllegalArgumentException> { die.currentValue = die.minValue - 1 }
    }

    @Test
    fun `can roll the die correctly`() {
        for (v in 1..100) {
            assertTrue { die.roll() in die.minValue..die.maxValue }
            die.roll()
            assertTrue { die.currentValue in die.minValue..die.maxValue }
        }
    }
}