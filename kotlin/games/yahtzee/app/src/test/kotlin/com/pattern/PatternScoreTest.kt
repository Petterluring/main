package com.pattern

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
    fun `can assigns pair correctly`() {

    }

    @Test
    fun `can identify invalid inputs`() {
        for (value in listOf(-1, 10000)) {

        }
    }
}