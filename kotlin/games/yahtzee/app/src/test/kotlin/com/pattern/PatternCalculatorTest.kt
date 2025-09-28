package com.pattern

import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class PatternCalculatorTest {

    private val calc = PatternCalculator()


    @Test
    fun `throws exception when diceValues are not set`() {
        assertThrows<IllegalStateException> { calc.calculate() }
    }

    @Test
    fun `can enforce correct dice values`() {
        assertThrows<IllegalArgumentException> {
            calc.diceValues = listOf(1, 1, 1, 1) // Too few values
        }
        assertThrows<IllegalArgumentException> {
            calc.diceValues = listOf(1, 1, 1, 1, 1, 1) // Too many values
        }
        assertThrows<IllegalArgumentException> {
            calc.diceValues = listOf(1, 2, 3, 4, 7) // Incorrect value range
        }
        assertThrows<IllegalArgumentException> {
            calc.diceValues = listOf(0, 2, 3, 4, 6) // Incorrect value range
        }
    }

    @Test
    fun `calculates ones to sixes correctly`() {
        for (i in 1 ..6) {
            calc.diceValues = listOf(i, i, i, i, i)
            val score = calc.calculate()
            assertEquals(if (i == 1) { i*5 } else 0, score.ones)
            assertEquals(if (i == 2) { i*5 } else 0, score.twos)
            assertEquals(if (i == 3) { i*5 } else 0, score.threes)
            assertEquals(if (i == 4) { i*5 } else 0, score.fours)
            assertEquals(if (i == 5) { i*5 } else 0, score.fives)
            assertEquals(if (i == 6) { i*5 } else 0, score.sixes)
        }
    }

    @Test
    fun `calculates pair correctly`() {
        calc.diceValues = listOf(1, 2, 3, 4, 4)
        var score = calc.calculate()
        assertEquals(8, score.pair)

        calc.diceValues = listOf(1, 2, 3, 6, 6)
        score = calc.calculate()
        assertEquals(12, score.pair)

        calc.diceValues = listOf(1, 4, 4, 6, 6)
        score = calc.calculate()
        assertEquals(12, score.pair)

        calc.diceValues = listOf(4, 4, 4, 6, 6)
        score = calc.calculate()
        assertEquals(12, score.pair)

        calc.diceValues = listOf(4, 4, 4, 1, 1)
        score = calc.calculate()
        assertEquals(8, score.pair)
    }

    @Test
    fun `calculates two pair correctly`() {
        calc.diceValues = listOf(2, 2, 4, 4, 5)
        var score = calc.calculate()
        assertEquals(12, score.twoPair)

        calc.diceValues = listOf(2, 2, 4, 4, 4)
        score = calc.calculate()
        assertEquals(12, score.twoPair)

        calc.diceValues = listOf(5, 5, 6, 6, 6)
        score = calc.calculate()
        assertEquals(22, score.twoPair)
    }

    @Test
    fun `calculates three and four of a kind correctly`() {
        for (i in 1..6) {
            calc.diceValues = listOf(i, i, i, i, i)
            val score = calc.calculate()
            assertEquals(i*3, score.threeOfAKind)
            assertEquals(i*4, score.fourOfAKind)
        }

        calc.diceValues = listOf(4, 4, 4, 3, 3)
        var score = calc.calculate()
        assertEquals(4*3, score.threeOfAKind)

        calc.diceValues = listOf(4, 4, 4, 4, 3)
        score = calc.calculate()
        assertEquals(4*4, score.fourOfAKind)
    }

    @Test
    fun `calculates small and large straight correctly`() {
        calc.diceValues = listOf(1, 2, 3, 4, 5)
        var score = calc.calculate()
        assertEquals(15, score.smallStraight)

        calc.diceValues = listOf(2, 3, 4, 5, 6)
        score = calc.calculate()
        assertEquals(20, score.largeStraight)

        calc.diceValues = listOf(5, 5, 2, 2, 1) // Sums to 15
        score = calc.calculate()
        assertEquals(0, score.smallStraight)

        calc.diceValues = listOf(5, 5, 5, 3, 2) // Sums to 20
        score = calc.calculate()
        assertEquals(0, score.largeStraight)
    }

    @Test
    fun `calculates full house correctly`() {
        for (i in 1..6) {
            for (j in 1..6) {
                if (i == j) { continue }
                calc.diceValues = listOf(i, i, i, j, j)
                val score = calc.calculate()
                assertEquals(i * 3 + j * 2, score.fullHouse)
            }
        }
        calc.diceValues = listOf(4, 4, 4, 4, 5)
        val score = calc.calculate()
        assertEquals(0, score.fullHouse)
    }

    @Test
    fun `calculates chance correctly`() {
        calc.diceValues = listOf(1, 3, 5, 2, 3)
        var score = calc.calculate()
        assertEquals(14, score.chance)

        calc.diceValues = listOf(6, 6, 6, 6, 6)
        score = calc.calculate()
        assertEquals(6*5, score.chance)

        calc.diceValues = listOf(5, 5, 5, 2, 1)
        score = calc.calculate()
        assertEquals(18, score.chance)
    }

    @Test
    fun `calculates yahtzee correctly`() {
        for (i in 1..6) {
            calc.diceValues = listOf(i, i, i, i, i)
            val score = calc.calculate()
            assertEquals(50, score.yahtzee)
        }
    }
}