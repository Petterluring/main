package com.score_table

import com.pattern.Patterns
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ScoreColumnTest {

    private val scoreColumn = ScoreColumn()


    @Test
    fun `can assign ones to sixes correctly`() {

        for (dieAmount in 0..5) {
            scoreColumn.ones = 1 * dieAmount
            scoreColumn.twos = 2 * dieAmount
            scoreColumn.threes = 3 * dieAmount
            scoreColumn.fours = 4 * dieAmount
            scoreColumn.fives = 5 * dieAmount
            scoreColumn.sixes = 6 * dieAmount

            assertEquals(1 * dieAmount, scoreColumn.ones)
            assertEquals(2 * dieAmount, scoreColumn.twos)
            assertEquals(3 * dieAmount, scoreColumn.threes)
            assertEquals(4 * dieAmount, scoreColumn.fours)
            assertEquals(5 * dieAmount, scoreColumn.fives)
            assertEquals(6 * dieAmount, scoreColumn.sixes)
        }
    }

    @Test
    fun `can assign pair correctly`() {
        for (dieVal in 1..6) {
            scoreColumn.pair = dieVal * 2;
            assertEquals(dieVal * 2, scoreColumn.pair)
        }
    }

    @Test
    fun `can assign bonus correctly`() {
        scoreColumn.ones = 3 * 1;
        scoreColumn.twos = 3 * 2;
        scoreColumn.threes = 3 * 3;
        scoreColumn.fours = 3 * 4;
        scoreColumn.fives = 3 * 5;
        scoreColumn.sixes = 3 * 6;

        assertEquals(50, scoreColumn.bonus)

        scoreColumn.sixes = 4 * 6;
        assertEquals(50, scoreColumn.bonus)

        scoreColumn.sixes = 0;
        assertEquals(0, scoreColumn.bonus)
    }

    @Test
    fun `can assign two pair correctly`() {
        for (d1 in 1..6) {
            for (d2 in d1 + 1..6) {
                scoreColumn.twoPair = d1 * 2 + d2 * 2
                assertEquals(d1 * 2 + d2 * 2, scoreColumn.twoPair)
            }
        }
        scoreColumn.twoPair = 0
        assertEquals(0, scoreColumn.twoPair)
    }

    @Test
    fun `can assign three and four of a kind correctly`() {
        for (dieVal in 0..6) {
            scoreColumn.threeOfAKind = dieVal * 3
            scoreColumn.fourOfAKind = dieVal * 4
            assertEquals(dieVal * 3, scoreColumn.threeOfAKind)
            assertEquals(dieVal * 4, scoreColumn.fourOfAKind)
        }
    }

    @Test
    fun `can assign large and small straight correctly`() {
        scoreColumn.smallStraight = 0
        assertEquals(0, scoreColumn.smallStraight)

        scoreColumn.smallStraight = 15
        assertEquals(15, scoreColumn.smallStraight)

        scoreColumn.largeStraight = 0
        assertEquals(0, scoreColumn.largeStraight)

        scoreColumn.largeStraight = 20
        assertEquals(20, scoreColumn.largeStraight)
    }

    @Test
    fun `can assign full house correctly`() {
        for (d1 in 1..6) {
            for (d2 in 1..6) {
                if (d1 == d2) continue
                scoreColumn.fullHouse = d1 * 2 + d2 * 3
                assertEquals(d1 * 2 + d2 * 3, scoreColumn.fullHouse)
            }
        }
        scoreColumn.fullHouse = 0
        assertEquals(0, scoreColumn.fullHouse)
    }

    @Test
    fun `can assign chance correctly`() {
        for (point in 0..6*5) {
            scoreColumn.chance = point
            assertEquals(point, scoreColumn.chance)
        }
    }

    @Test
    fun `can assign yahtzee correctly`() {
        scoreColumn.yahtzee = 0
        assertEquals(0, scoreColumn.yahtzee)
        scoreColumn.yahtzee = 50
        assertEquals(50, scoreColumn.yahtzee)
    }

    @Test
    fun `can compute the total correctly`() {
        scoreColumn.ones = 3
        scoreColumn.twos = 6
        assertEquals(9, scoreColumn.total)

        scoreColumn.yahtzee = 50
        assertEquals(59, scoreColumn.total)

        scoreColumn.sixes = 30
        assertEquals(89, scoreColumn.total)
    }

    @Test
    fun `can identify if a pattern is consumed`() {
        Patterns.entries.forEach { pattern ->
            assertFalse { scoreColumn.patternIsAssigned(pattern) }  }

        scoreColumn.ones          = 0
        scoreColumn.twos          = 0
        scoreColumn.threes        = 0
        scoreColumn.fours         = 0
        scoreColumn.fives         = 0
        scoreColumn.sixes         = 0
        scoreColumn.pair          = 0
        scoreColumn.twoPair       = 0
        scoreColumn.threeOfAKind  = 0
        scoreColumn.fourOfAKind   = 0
        scoreColumn.smallStraight = 0
        scoreColumn.largeStraight = 0
        scoreColumn.fullHouse     = 0
        scoreColumn.chance        = 0
        scoreColumn.yahtzee       = 0

        Patterns.entries.forEach { pattern ->
            assertTrue { scoreColumn.patternIsAssigned(pattern) }  }
    }

    @Test
    fun `can deal with illegal value`() {
        for (illegalVal in listOf(-1, 1000)) {
            assertThrows<IllegalArgumentException> {
                scoreColumn.ones = illegalVal
            }
            assertThrows<IllegalArgumentException> {
                scoreColumn.twos = illegalVal
            }
            assertThrows<IllegalArgumentException> {
                scoreColumn.threes = illegalVal
            }
            assertThrows<IllegalArgumentException> {
                scoreColumn.fours = illegalVal
            }
            assertThrows<IllegalArgumentException> {
                scoreColumn.fives = illegalVal
            }
            assertThrows<IllegalArgumentException> {
                scoreColumn.sixes = illegalVal
            }
            assertThrows<IllegalArgumentException> {
                scoreColumn.pair = illegalVal
            }
            assertThrows<IllegalArgumentException> {
                scoreColumn.twoPair = illegalVal
            }
            assertThrows<IllegalArgumentException> {
                scoreColumn.threeOfAKind = illegalVal
            }
            assertThrows<IllegalArgumentException> {
                scoreColumn.fourOfAKind = illegalVal
            }
            assertThrows<IllegalArgumentException> {
                scoreColumn.smallStraight = illegalVal
            }
            assertThrows<IllegalArgumentException> {
                scoreColumn.largeStraight = illegalVal
            }
            assertThrows<IllegalArgumentException> {
                scoreColumn.fullHouse = illegalVal
            }
            assertThrows<IllegalArgumentException> {
                scoreColumn.chance = illegalVal
            }
            assertThrows<IllegalArgumentException> {
                scoreColumn.yahtzee = illegalVal
            }
        }
    }
}