package com.board

import com.agents.consumable.Energy
import com.agents.consumable.Strength
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.*

class BoardInputClass {
    private val size: Int = 12
    private val boardManager: BoardManager = BoardManager(size)

    @Test
    fun initCanThrowException() {
        assertThrows<IllegalArgumentException> { BoardManager(1) }
    }

    @Test
    fun canPositionAgentOnBoard() {
        val strength = Strength("S1", -1, 1, 2, 2)
        assertThrows<IllegalArgumentException> { boardManager.positionAgent(strength) }
        strength.setPosition(1, 1)
        boardManager.positionAgent(strength)
        assertNotNull(boardManager.getAgent(1, 1))
    }

    @Test
    fun canPositionAgentRandomly() {
        val occurrences = MutableList(size) { MutableList(size) {0} }
        val energy = Energy("Energy", 0, 0, 1, 5)
        for (i in 0 ..1000*size) {
            boardManager.clearPosition(energy.row, energy.column)
            val (row, column) = boardManager.positionAgentRandomly(energy)
            assertNotNull(boardManager.getAgent(row, column))
            assertTrue(boardManager.getAgent(row, column)!!.name.equals("Energy"))
            occurrences[row][column] += 1
        }
        for (row in occurrences) {
            for (element in row) {
                assertNotEquals(0, element)
            }
        }
    }

    @Test
    fun canClearPosition() {
        val row = 1
        val column = 1
        val strength = Strength("S1", row, column, 2, 2)
        boardManager.positionAgent(strength)
        assertNotNull(boardManager.getAgent(row, column))
        boardManager.clearPosition(row, column)
        assertNull(boardManager.getAgent(row, column))
    }

    @Test
    fun canCheckIfPositionIsValid() {
        for (i in 0..< size) {
            for (j in 0..< size) {
                assertTrue { boardManager.validPosition(i, j) }
            }
        }
        assertFalse { boardManager.validPosition(-1, 0) }
        assertFalse { boardManager.validPosition(0, -1) }
        assertFalse { boardManager.validPosition(size, 0) }
        assertFalse { boardManager.validPosition(0, size) }
        assertFalse { boardManager.validPosition(size, size) }
    }
}