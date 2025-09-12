package com.player

import com.pointcalculator.PointCalculator

class Player(
    val name: String,
    private var _chipStack: Int,
    ) {
    private var _hands: MutableList<Hand> = mutableListOf()

   val hands: List<Hand>
       get() = _hands.toList()

   val chipStack: Int
       get() = _chipStack

    fun clearHands() {
        _hands.clear()
    }

    fun addHand(hand: Hand) {
        _hands.add(hand)
    }

    fun removeFromChipStack(amount: Int): Int {
        require(amount > 0) { "Amount must exceed 0" }
        if (_chipStack - amount < 0) { throw IllegalStateException("Not enough chips in the chip stack") }
        _chipStack -= amount
        return amount
    }
}