package com.player

import com.die.DiceSet
import com.die.Die
import kotlin.test.Test
import kotlin.test.assertEquals

class PlayerTest {

    private val dice = DiceSet(
        listOf(
            Die(1, 6)
        )
    )
    private val player = Player("Jon", "Doe", dice)

    @Test
    fun `can return the first and last name correctly`() {
        assertEquals("Jon", player.firstName)
        assertEquals("Doe", player.lastName)
    }

    @Test
    fun `can return the name correctly`() {
        assertEquals("Jon Doe", player.name)
    }

    @Test
    fun `can return the initials correctly`() {
        assertEquals("JD", player.initials)
    }
}