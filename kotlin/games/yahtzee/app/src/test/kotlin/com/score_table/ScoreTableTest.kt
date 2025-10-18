package com.score_table

import com.die.DiceSet
import com.die.Die
import com.player.Player
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ScoreTableTest {

    private val dice = DiceSet(listOf(
        Die(1, 6)
    ))
    private val jon = Player("Jon", "Doe", dice)
    private val wilma = Player("Wilma", "Anderson", dice)
    private val john = Player("John", "Wick", dice)
    private val scoreTable = ScoreTable(
        listOf(
           jon, wilma, john
        )
    )

    @Test
    fun `can return the correct column`() {
        var column = scoreTable.getScoreColumn(jon)
        column!!.ones = 5
        column = scoreTable.getScoreColumn(jon)
        assertEquals(5, column!!.ones)
    }

    @Test
    fun `can identify that a player exists`() {
        assertTrue { scoreTable.playerExists(jon) }
        assertTrue { scoreTable.playerExists(wilma) }
        assertTrue { scoreTable.playerExists(john) }
        assertFalse { scoreTable.playerExists(
            Player("New", "Player", dice)
        ) }
    }

    @Test
    fun `can remove player`() {
        scoreTable.removePlayer(john)
        assertFalse { scoreTable.playerExists(john) }
    }

    @Test
    fun `can add player`() {
        val newPlayer = Player("New", "Player", dice)
        assertThrows<IllegalArgumentException> {
            scoreTable.addPlayer(wilma)
        }
        scoreTable.addPlayer(newPlayer)
        assertTrue { scoreTable.playerExists(newPlayer) }
    }
}