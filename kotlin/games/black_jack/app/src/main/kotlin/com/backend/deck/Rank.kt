package com.deck

enum class Rank(val emblem: String, var value: Int) {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4",4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 10),
    QUEEN("Q", 10),
    KING("K", 10),
    ACE("A", 11);

    fun getName(): String = name[0] + name.substring(1, name.length).lowercase()
}