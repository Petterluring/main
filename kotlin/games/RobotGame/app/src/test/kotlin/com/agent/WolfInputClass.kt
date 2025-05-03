package com.agent

import com.agents.Wolf
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class WolfInputClass {
    private val wolf: Wolf = Wolf(
        "Wolf",
        0,
        0,
        2
    )

    @Test
    fun canGetAttackValue() {
        assertEquals(2, wolf.attackValue)
    }

    @Test
    fun initCanThrowExceptions() {
        assertThrows<IllegalArgumentException> {
            Wolf("Wolf", 0, 0, 0)
        }
    }

    @Test
    fun canMoveCloserToAgent() {
        var row = 5
        var column = 5
        wolf.moveCloserToAgent(row, column)
        assertEquals(0, wolf.row)
        assertEquals(0, wolf.column)

        row = 4
        column = 5
        wolf.moveCloserToAgent(row, column)
        assertEquals(0, wolf.row)
        assertEquals(1, wolf.column)
        wolf.setPosition(0, 0)

        row = 5
        column = 4
        wolf.moveCloserToAgent(row, column)
        assertEquals(1, wolf.row)
        assertEquals(0, wolf.column)
    }
}