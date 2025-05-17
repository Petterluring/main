package com.dealer

import com.deck.Card
import com.deck.Deck
import com.deck.Rank
import com.deck.Suit
import org.junit.jupiter.api.assertThrows
import kotlin.test.*

class DealerTest {
    private val deck = Deck()
    private val dealer = Dealer(deck)


    @Test
    fun canDecideIfBusted() {
        assertThrows<IllegalArgumentException> { Dealer.bust(1) }
        assertFalse { Dealer.bust(4) }
        assertFalse { Dealer.bust(21) }
        assertTrue { Dealer.bust(22) }
        assertTrue { Dealer.bust(24) }
    }

    @Test
    fun canCalculatePoint() {
        var cards = listOf(
            Card(Rank.TEN, Suit.SPADES),
            Card(Rank.ACE, Suit.SPADES),
        )
        assertEquals(21, Dealer.calculatePoint(cards))
        cards = listOf(
            Card(Rank.THREE, Suit.SPADES),
            Card(Rank.ACE, Suit.SPADES),
        )
        assertEquals(14, Dealer.calculatePoint(cards))
        cards = listOf(
            Card(Rank.KING, Suit.SPADES),
            Card(Rank.KING, Suit.SPADES),
        )
        assertEquals(20, Dealer.calculatePoint(cards))
        cards = listOf(
            Card(Rank.KING, Suit.SPADES),
            Card(Rank.KING, Suit.SPADES),
            Card(Rank.TWO, Suit.SPADES),
        )
        assertEquals(22, Dealer.calculatePoint(cards))
        cards = listOf(
            Card(Rank.KING, Suit.SPADES),
            Card(Rank.ACE, Suit.SPADES),
            Card(Rank.TWO, Suit.SPADES),
        )
        assertEquals(13, Dealer.calculatePoint(cards))
        cards = listOf(
            Card(Rank.ACE, Suit.SPADES),
            Card(Rank.ACE, Suit.SPADES),
            Card(Rank.TWO, Suit.SPADES),
        )
        assertEquals(14, Dealer.calculatePoint(cards))
        cards = listOf(
            Card(Rank.FIVE, Suit.SPADES),
            Card(Rank.FIVE, Suit.SPADES),
            Card(Rank.ACE, Suit.SPADES),
        )
        assertEquals(21, Dealer.calculatePoint(cards))
        cards = listOf(
            Card(Rank.FIVE, Suit.SPADES),
            Card(Rank.SIX, Suit.SPADES),
            Card(Rank.ACE, Suit.SPADES),
        )
        assertEquals(12, Dealer.calculatePoint(cards))
    }

    @Test
    fun canDealCard() {
        val card = dealer.dealCard()
        assertEquals(Card(Rank.TWO, Suit.CLOVES), card)
        for (i in 0..< 51) {
            dealer.dealCard()
        }
        assertThrows<IllegalStateException> { dealer.dealCard() }
    }

    @Test
    fun canDealNewHand() {
        val hand = dealer.newHand()
        assertEquals(2, hand.size)
        assertNotNull(hand[0])
        assertNotNull(hand[1])
        assertEquals(2, deck.currentTopCardIndex)

        for (i in 2..51 - 1) {
            deck.popCard()
        }
        assertThrows<IllegalStateException> { dealer.newHand() }
    }

}