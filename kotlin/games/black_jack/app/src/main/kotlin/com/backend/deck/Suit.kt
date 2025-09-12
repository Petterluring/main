package com.deck

enum class Suit(var emblem: String, val color: String, var code: Int) {
    CLOVES("♣️", "Black", 1),
    DIAMOND("♦️", "Red", 2),
    HEART("♥️", "Red", 3),
    SPADES("♠️", "Black", 4);

    fun getName(): String {
        return name[0] + name.substring(1, name.length).lowercase()
    }
}