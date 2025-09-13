package com.die

import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class DiceSetTest {

    private val dice = DiceSet(
        listOf(
            Die(1, 6),
            Die(1, 6),
            Die(1, 6),
            Die(1, 6),
            Die(1, 6),
            Die(1, 6),
            Die(1, 6),
            Die(1, 6),
            Die(1, 6)
        )
    )

    @Test
    fun `can roll all dice`() {
        val currentValues = dice.getDiceValues()
        val rolls = dice.rollAll()
        assertNotEquals(currentValues, rolls)
    }

    @Test
    fun `can roll selectively`() {
        var exception = assertThrows<IllegalArgumentException> {
            dice.selectiveRoll()
        }
        assertEquals("Amount", exception.message!!.take(6))
        exception = assertThrows<IllegalArgumentException> {
            dice.selectiveRoll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
        }
        assertEquals("Amount", exception.message!!.take(6))
        exception = assertThrows<IllegalArgumentException> {
            dice.selectiveRoll(10, 11)
        }
        assertEquals("Each index", exception.message!!.take(10))

        exception = assertThrows<IllegalArgumentException> {
            dice.selectiveRoll(4, 4)
        }
        assertEquals("Each unique", exception.message!!.take(11))

        val currentValues = dice.getDiceValues()
        val rolls = dice.selectiveRoll(1, 2, 3, 4, 5, 6, 7, 8)

        assertEquals(currentValues[0], rolls[0])
        assertNotEquals(currentValues, rolls)
    }

    @Test
    fun `can get dice values`() {
        val values = dice.getDiceValues()
        assertEquals(9, values.size)
        values.forEach { value -> assertEquals(1, value) }
    }
}