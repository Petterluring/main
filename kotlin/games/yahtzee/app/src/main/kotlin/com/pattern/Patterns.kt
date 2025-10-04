package com.pattern

enum class Patterns(val legalValues: Set<Int>, val valueError: String) {
    ONES(setOf(0, 1, 2, 3, 4, 5), "Illegal value for ones."),
    TWOS(setOf(0, 2, 4, 6, 8, 10), "Illegal value for twos."),
    THREES(setOf(0, 3, 6, 9, 12, 15), "Illegal value for threes."),
    FOURS(setOf(0, 4, 8, 12, 16, 20), "Illegal value for fours."),
    FIVES(setOf(0, 5, 10, 15, 20, 25), "Illegal value for fives."),
    SIXES(setOf(0, 6, 12, 18, 24, 30), "Illegal value for sixes."),
    PAIR(setOf(0, 2, 4, 6, 8, 10, 12), "Illegal value for pair."),
    TWO_PAIR(setOf(0, 6, 8, 10, 12, 14, 16, 18, 20, 22), "Illegal value for two pair."),
    THREE_OF_A_KIND(setOf(0, 3, 6, 9, 12, 15, 18), "Illegal value for three of a kind."),
    FOUR_OF_A_KIND(setOf(0, 4, 8, 12, 16, 20, 24), "Illegal value for four of a kind."),
    SMALL_STRAIGHT(setOf(0, 15), "Illegal value for small straight."),
    LARGE_STRAIGHT(setOf(0, 20), "Illegal value for large straight."),
    FULL_HOUSE(setOf(
        0, 7, 9, 11, 13, 15, 8, 12, 14, 16, 18, 17, 19,
        21, 22, 24, 23, 27, 20, 26, 28), "Illegal value for full house."),
    CHANCE((0..6*5).toSet(), "Illegal value for chance."),
    YAHTZEE(setOf(0, 50), "Illegal value for yahtzee.")
}