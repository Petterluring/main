package com.player

import kotlin.test.Test
import kotlin.test.assertEquals

class PlayerTest {

    private val player = Player("Jon", "Doe")

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