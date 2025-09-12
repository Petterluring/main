package com.pointcalculator

import com.deck.Card

interface PointCalculator {

    fun calculatePoint(cards: List<Card>): Int
}