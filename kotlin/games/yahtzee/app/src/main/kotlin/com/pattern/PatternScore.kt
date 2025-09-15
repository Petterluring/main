package com.pattern

data class PatternScore(
    val ones: Int,
    val twos: Int,
    val threes: Int,
    val fours: Int,
    val fives: Int,
    val sixes: Int,
    val pair: Int,
    val twoPair: Int,
    val threeOfAKind: Int,
    val fourOfAKind: Int,
    val smallStraight: Int,
    val largeStraight: Int,
    val fullHouse: Int,
    val chance: Int,
    val yahtzee: Int,
) {

    init {
        require(ones in 0..5)
        require(twos in setOf(0, 2, 4, 6, 8, 10))
        require(threes in setOf(0, 3, 6, 9, 12, 15))
        require(fours in setOf(0, 4, 8, 12, 16, 20))
        require(fives in setOf(0, 5, 10, 15, 20, 25))
        require(sixes in setOf(0, 6, 12, 18, 24, 30))
        require(pair in setOf(0, 2, 4, 6, 8, 10, 12))
        require(twoPair in setOf(0, 6, 8, 10, 12, 14, 16, 18, 20, 22))
        require(threeOfAKind in setOf(0, 3, 6, 9, 12, 15, 18))
        require(fourOfAKind in setOf(0, 4, 8, 12, 16, 20, 24))
        require(smallStraight in setOf(0, 15))
        require(largeStraight in setOf(0, 20))
        require(fullHouse in setOf(0, 7, 9, 11, 13, 15, 8, 12, 14, 16, 18, 17, 19, 21, 22, 24, 23, 27, 20, 26, 28))
        require(chance in 0..6*5)
        require(yahtzee in setOf(0, 50))
    }
}