package com.deck

import org.junit.jupiter.api.assertThrows
import kotlin.test.*


class DeckTest {
    private val deck = Deck()

    @Test
    fun initCanThrowException() {
        assertThrows<IllegalArgumentException> { Deck(0) }
        assertThrows<IllegalArgumentException> { Deck(-1) }
    }

    @Test
    fun canPopCard() {
        var card = deck.popCard()
        assertEquals("2", card!!.rank.emblem)
        assertEquals(1, deck.currentTopCardIndex)
        card = deck.popCard()
        assertEquals("3", card!!.rank.emblem)
        assertEquals(2, deck.currentTopCardIndex)
        for (i in 0..< 52 - 2) {
            deck.popCard()
        }
        assertNull(deck.popCard())
        assertEquals(52, deck.currentTopCardIndex)
    }

    @Test
    fun canShuffle() {
        val cardsBefore = deck.cards
        deck.shuffle()
        assertEquals(0, deck.currentTopCardIndex)
        val cardsAfter = deck.cards
        assertNotEquals(cardsBefore, cardsAfter)
    }
}