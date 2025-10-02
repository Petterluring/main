package com.score_table

import com.pattern.Patterns

class ScoreColumn {
    private var          _ones = -1
    private var          _twos = -1
    private var        _threes = -1
    private var         _fours = -1
    private var         _fives = -1
    private var         _sixes = -1
    private var         _bonus =  0
    private var          _pair = -1
    private var       _twoPair = -1
    private var  _threeOfAKind = -1
    private var   _fourOfAKind = -1
    private var _smallStraight = -1
    private var _largeStraight = -1
    private var     _fullHouse = -1
    private var        _chance = -1
    private var       _yahtzee = -1
    private var         _total =  0

    companion object {
        private const val VALUE_ERROR = "Illegal value"
    }

    var ones
        get() = if (_ones == -1) 0 else _ones
        set(value) {
            require(value in 0..5) {"$VALUE_ERROR for ones."}
            _twos = value
            calculateBonus()
            calculateTotal()
        }

    var twos
        get() = if (_twos == -1) 0 else _twos
        set(value) {
            require(value in setOf(0, 2, 4, 6, 8, 10)) {"$VALUE_ERROR for twos."}
            _twos = value
            calculateBonus()
            calculateTotal()
        }

    var threes
        get() = if (_threes == -1) 0 else _threes
        set(value) {
            require(value in setOf(0, 3, 6, 9, 12, 15)) {"$VALUE_ERROR for threes."}
            _threes = value
            calculateBonus()
            calculateTotal()
        }

    var fours
        get() = if (_fours == -1) 0 else _fours
        set(value) {
            require(value in setOf(0, 4, 8, 12, 16, 20)) {"$VALUE_ERROR for fours."}
            _fours = value
            calculateBonus()
            calculateTotal()
        }

    var fives
        get() = if (_fives == -1) 0 else _fives
        set(value) {
            require(value in setOf(0, 5, 10, 15, 20, 25)) {"$VALUE_ERROR for fives."}
            _fives = value
            calculateBonus()
            calculateTotal()
        }

    var sixes
        get() = if (_sixes == -1) 0 else _sixes
        set(value) {
            require(value in setOf(0, 6, 12, 18, 24, 30)) {"$VALUE_ERROR for sixes."}
            _sixes = value
            calculateBonus()
            calculateTotal()
        }

    val bonus
        get() = _bonus

    var pair
        get() = if (_pair == -1) 0 else _pair
        set(value) {
            require(value in setOf(0, 2, 4, 6, 8, 10, 12)) {"$VALUE_ERROR for pair."}
            _pair = value
            calculateBonus()
            calculateTotal()
        }

    var twoPair
        get() = if (_twoPair == -1) 0 else _twoPair
        set(value) {
            require(value in setOf(0, 6, 8, 10, 12, 14, 16, 18, 20, 22)) {"$VALUE_ERROR for two pair."}
            _twoPair = value
            calculateBonus()
            calculateTotal()
        }

    var threeOfAKind
        get() = if (_threeOfAKind == -1) 0 else _threeOfAKind
        set(value) {
            require(value in setOf(0, 3, 6, 9, 12, 15, 18)) {"$VALUE_ERROR for three of a kind."}
            _threeOfAKind = value
            calculateBonus()
            calculateTotal()
        }

    var fourOfAKind
        get() = if (_fourOfAKind == -1) 0 else _fourOfAKind
        set(value) {
            require(value in setOf(0, 4, 8, 12, 16, 20, 24)) {"$VALUE_ERROR for four of a kind."}
            _fourOfAKind = value
            calculateBonus()
            calculateTotal()
        }

    var smallStraight
        get() = if (_smallStraight == -1) 0 else _smallStraight
        set(value) {
            require(value in setOf(0, 15)) {"$VALUE_ERROR for small straight."}
            _smallStraight = value
            calculateBonus()
            calculateTotal()
        }

    var largeStraight
        get() = if (_largeStraight == -1) 0 else _largeStraight
        set(value) {
            require(value in setOf(0, 20)) {"$VALUE_ERROR for large straight."}
            _largeStraight = value
            calculateBonus()
            calculateTotal()
        }

    var fullHouse
        get() = if (_fullHouse == -1) 0 else _fullHouse
        set(value) {
            require(value in setOf(
                0, 7, 9, 11, 13, 15, 8, 12, 14, 16, 18, 17, 19,
                21, 22, 24, 23, 27, 20, 26, 28)) {"$VALUE_ERROR for full house."}
            _fullHouse = value
            calculateBonus()
            calculateTotal()
        }

    var chance
        get() = if (_chance == -1) 0 else _chance
        set(value) {
            require(value in 0..6*5) {"$VALUE_ERROR for chance."}
            _chance = value
            calculateBonus()
            calculateTotal()
        }

    var yahtzee
        get() = if (_yahtzee == -1) 0 else _yahtzee
        set(value) {
            require(value in setOf(0, 50)) {"$VALUE_ERROR for yahtzee."}
            _yahtzee = value
            calculateBonus()
            calculateTotal()
        }

    val total
        get() = _total

    /**
     * Checks if a pattern has been assigned a point.
     * This lets the user know what patterns are left for point assignment.
     */
    fun patternIsAssigned(pattern: Patterns): Boolean {
        when(pattern) {
            Patterns.ONES            -> return _ones          > -1
            Patterns.TWOS            -> return _twos          > -1
            Patterns.THREES          -> return _threes        > -1
            Patterns.FOURS           -> return _fours         > -1
            Patterns.FIVES           -> return _fives         > -1
            Patterns.SIXES           -> return _sixes         > -1
            Patterns.PAIR            -> return _pair          > -1
            Patterns.TWO_PAIR        -> return _twoPair       > -1
            Patterns.THREE_OF_A_KIND -> return _threeOfAKind  > -1
            Patterns.FOUR_OF_A_KIND  -> return _fourOfAKind   > -1
            Patterns.SMALL_STRAIGHT  -> return _smallStraight > -1
            Patterns.LARGE_STRAIGHT  -> return _largeStraight > -1
            Patterns.FULL_HOUSE      -> return _fullHouse     > -1
            Patterns.CHANCE          -> return _chance        > -1
            else                     -> return _yahtzee       > -1
        }
    }

    private fun calculateBonus() {
        val total = ones + twos + threes + fours + fives + sixes
        _bonus = if (total >= 63) { 50 } else { 0 }
        }

    private fun calculateTotal() {
        _total = ones + twos + threes + fours + fives + sixes +
                 pair + twoPair + threeOfAKind + fourOfAKind +
                 smallStraight + largeStraight + fullHouse + chance +
                 yahtzee
    }
}


