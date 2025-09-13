package com.die

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

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

    }

    @Test
    fun `can get dice values`() {
        val values = dice.getDiceValues()
        assertEquals(9, values.size)
        values.forEach { value -> assertEquals(1, value) }
    }



}