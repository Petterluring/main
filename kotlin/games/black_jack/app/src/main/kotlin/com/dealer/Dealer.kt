package com.dealer

import com.deck.Card
import com.deck.Deck
import com.deck.Rank

class Dealer(private val deck: Deck) {

    companion object {
        fun calculatePoint(cards: List<Card>): Int {
            var sum = 0
            for (card in cards) {
                sum += card.rank.value
            }
            if (sum > 21) {
                for (card in cards) {
                    if (card.rank.equals(Rank.ACE)) {
                        sum = sum - card.rank.value + 1
                        if (sum < 21) {
                            break
                        }
                    }
                }
            }
            return sum
        }

        fun bust(point: Int): Boolean {
            require(point >= 2) {"Point must be at least 2"}
            return point > 21
        }

        fun isTwentyOne(point: Int): Boolean {
            return point == 21
        }
    }

    fun dealCard(): Card {
        val card = deck.popCard()
        if (card == null) {
            throw IllegalStateException("No cards remaining in the deck")
        }
        return card
    }

    fun newHand(): MutableList<Card> {
        if (deck.cards.size - 1 - deck.currentTopCardIndex < 2) {
            throw IllegalStateException("Too few cards in the deck")
        }
        return mutableListOf(deck.popCard()!!, deck.popCard()!!)
    }


}