package com.deck

import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class CardTest {
    private val card = Card(Rank.ACE, Suit.SPADES)

    @Test
    fun cardConstructsNameCorrectly() {
        assertEquals("Ace of Spades", card.getName())
    }
}