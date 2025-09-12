package com.dealer

import com.deck.Card
import com.deck.Deck
import com.deck.Rank
import com.pointcalculator.PointCalculator

class Dealer(private val deck: Deck): PointCalculator {

    companion object {

        fun bust(point: Int): Boolean {
            require(point >= 2) {"Point must be at least 2"}
            return point > 21
        }

        fun isTwentyOne(point: Int): Boolean {
            return point == 21
        }

        fun canSplit(first: Card, second: Card): Boolean {
            return first.rank == second.rank
        }

        fun splitHand(first: Card, second: Card): Pair<MutableList<Card>, MutableList<Card>> {
            return Pair(mutableListOf(first), mutableListOf(second))
        }
    }

    override fun calculatePoint(cards: List<Card>): Int {
        var sum = 0
        for (card in cards) {
            sum += card.rank.value
        }
        if (sum > 21) {
            for (card in cards) {
                if (card.rank == Rank.ACE) {
                    sum = sum - card.rank.value + 1
                    if (sum < 21) {
                        break
                    }
                }
            }
        }
        return sum
    }

    fun dealCard(): Card {
        return deck.popCard() ?: throw IllegalStateException("No cards remaining in the deck")
    }

    fun newHand(): MutableList<Card> {
        if (deck.cards.size - 1 - deck.currentTopCardIndex < 2) {
            throw IllegalStateException("Too few cards in the deck")
        }
        return mutableListOf(deck.popCard()!!, deck.popCard()!!)
    }
}