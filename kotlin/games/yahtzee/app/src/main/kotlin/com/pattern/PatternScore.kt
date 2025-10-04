package com.pattern

data class PatternScore(
    val          ones: Int,
    val          twos: Int,
    val        threes: Int,
    val         fours: Int,
    val         fives: Int,
    val         sixes: Int,
    val          pair: Int,
    val       twoPair: Int,
    val  threeOfAKind: Int,
    val   fourOfAKind: Int,
    val smallStraight: Int,
    val largeStraight: Int,
    val     fullHouse: Int,
    val        chance: Int,
    val       yahtzee: Int
) {

    init {
        require(ones in Patterns.ONES.legalValues) { Patterns.ONES.valueError }
        require(twos in Patterns.TWOS.legalValues) { Patterns.TWOS.valueError }
        require(threes in Patterns.THREES.legalValues) { Patterns.THREES.valueError }
        require(fours in Patterns.FOURS.legalValues) { Patterns.FOURS.valueError }
        require(fives in Patterns.FIVES.legalValues) { Patterns.FIVES.valueError }
        require(sixes in Patterns.SIXES.legalValues) { Patterns.SIXES.valueError }
        require(pair in Patterns.PAIR.legalValues) { Patterns.PAIR.valueError }
        require(twoPair in Patterns.TWO_PAIR.legalValues) { Patterns.TWO_PAIR.valueError }
        require(threeOfAKind in Patterns.THREE_OF_A_KIND.legalValues) { Patterns.THREE_OF_A_KIND.valueError }
        require(fourOfAKind in Patterns.FOUR_OF_A_KIND.legalValues) { Patterns.FOUR_OF_A_KIND.valueError }
        require(smallStraight in Patterns.SMALL_STRAIGHT.legalValues) { Patterns.SMALL_STRAIGHT.valueError }
        require(largeStraight in Patterns.LARGE_STRAIGHT.legalValues) { Patterns.LARGE_STRAIGHT.valueError }
        require(fullHouse in Patterns.FULL_HOUSE.legalValues) { Patterns.FULL_HOUSE.valueError }
        require(chance in Patterns.CHANCE.legalValues) { Patterns.CHANCE.valueError }
        require(yahtzee in Patterns.YAHTZEE.legalValues) { Patterns.YAHTZEE.valueError }
    }

    override fun toString(): String {
        return ""
    }

}