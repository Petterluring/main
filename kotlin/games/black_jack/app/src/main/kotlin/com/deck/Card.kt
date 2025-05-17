package com.deck

data class Card(
    val rank: Rank,
    val suit: Suit,
) {

    fun getName(): String  = rank.getName() + " of " + suit.getName()

    fun getEmblem(): String = rank.emblem + suit.emblem
}