package com.pattern

import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class PatternScoreTest {


    @Test
    fun `can assign ones to sixes correctly`() {
        for (score in 0..5) {
            val scores = PatternScore(
                score,
                score * 2,
                score * 3,
                score * 4,
                score * 5,
                score * 6,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
            )
            assertEquals(score, scores.ones)
            assertEquals(score * 2, scores.twos)
            assertEquals(score * 3, scores.threes)
            assertEquals(score * 4, scores.fours)
            assertEquals(score * 5, scores.fives)
            assertEquals(score * 6, scores.sixes)
        }
    }

    @Test
    fun `can assign pairs, three and four of a kind correctly`() {
        for (dieValue in 0..6) {
            val scores = PatternScore(
                0,
                0,
                0,
                0,
                0,
                0,
                dieValue * 2,
                0,
                dieValue * 3,
                dieValue * 4,
                0,
                0,
                0,
                0,
                0,
            )
            assertEquals(dieValue * 2, scores.pair)
            assertEquals(dieValue * 3, scores.threeOfAKind)
            assertEquals(dieValue * 4, scores.fourOfAKind)
        }
    }

    @Test
    fun `can assign two pairs correctly`() {
        for (d1 in 1..6) {
            for (d2 in d1 + 1..6) {
                val scores = PatternScore(
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    d1 * 2 + d2 *2,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                )
                assertEquals(d1 * 2 + d2 * 2, scores.twoPair)
            }
        }
    }

    @Test
    fun `can assign large and small straight, and Yatzy correctly`() {
        val scores = PatternScore(
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            15,
            20,
            0,
            0,
            50,
        )
        assertEquals(15, scores.smallStraight)
        assertEquals(20, scores.largeStraight)
        assertEquals(50, scores.yahtzee)
    }

    @Test
    fun `can assign full house correctly`() {
        for (d1 in 1..6) {
            for (d2 in 1..6) {
                if (d1 == d2) continue
                val scores = PatternScore(
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    d1 * 2 + d2 * 3,
                    0,
                    0,
                )
                assertEquals(d1 * 2 + d2 * 3, scores.fullHouse)
            }
        }
    }

    @Test
    fun `can identify invalid inputs`() {
        for (i in 1..15) {
            for (value in listOf(-1, 10000)) {
                assertThrows<IllegalArgumentException> {
                    PatternScore(
                        if (i == 1) value else 0,
                        if (i == 2) value else 0,
                        if (i == 3) value else 0,
                        if (i == 4) value else 0,
                        if (i == 5) value else 0,
                        if (i == 6) value else 0,
                        if (i == 7) value else 0,
                        if (i == 8) value else 0,
                        if (i == 9) value else 0,
                        if (i == 10) value else 0,
                        if (i == 11) value else 0,
                        if (i == 12) value else 0,
                        if (i == 13) value else 0,
                        if (i == 14) value else 0,
                        if (i == 15) value else 0,
                    )
                }
            }
        }
    }
}