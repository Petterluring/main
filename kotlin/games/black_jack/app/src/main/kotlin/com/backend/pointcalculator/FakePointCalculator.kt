package com.pointcalculator

import com.deck.Card

class FakePointCalculator(private var _fakePoint: Int): PointCalculator {

    override fun calculatePoint(cards: List<Card>): Int {
        return ++_fakePoint
    }
}