package com.player

import com.deck.Card
import com.pointcalculator.PointCalculator

class Hand(
    private val _cards: MutableList<Card>,
    private var _bet: Int,
    private val pointCalculator: PointCalculator
) {
    val bet: Int
        get() = _bet

    val cards: List<Card>
        get() = _cards.toList()

    private var _point: Int = pointCalculator.calculatePoint(_cards)

    val point: Int
        get() = _point

   init {
       require(_bet > 0) {"Bet must be higher than 0"}
   }

    fun doubleCurrentBet(): Int {
        _bet *= 2
        return _bet
    }

    fun addCard(card: Card): Int {
        _cards.addLast(card)
        _point = pointCalculator.calculatePoint(_cards)
        return _point
    }
}