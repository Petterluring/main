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

    var ones
        get() = if (_ones == -1) 0 else _ones
        set(value) {
            require(ones in Patterns.ONES.legalValues) { Patterns.ONES.valueError }
            _ones = value
            calculateBonus()
            calculateTotal()
        }

    var twos
        get() = if (_twos == -1) 0 else _twos
        set(value) {
            require(twos in Patterns.TWOS.legalValues) { Patterns.TWOS.valueError }
            _twos = value
            calculateBonus()
            calculateTotal()
        }

    var threes
        get() = if (_threes == -1) 0 else _threes
        set(value) {
            require(threes in Patterns.THREES.legalValues) { Patterns.THREES.valueError }
            _threes = value
            calculateBonus()
            calculateTotal()
        }

    var fours
        get() = if (_fours == -1) 0 else _fours
        set(value) {
            require(fours in Patterns.FOURS.legalValues) { Patterns.FOURS.valueError }
            _fours = value
            calculateBonus()
            calculateTotal()
        }

    var fives
        get() = if (_fives == -1) 0 else _fives
        set(value) {
            require(fives in Patterns.FIVES.legalValues) { Patterns.FIVES.valueError }
            _fives = value
            calculateBonus()
            calculateTotal()
        }

    var sixes
        get() = if (_sixes == -1) 0 else _sixes
        set(value) {
            require(sixes in Patterns.SIXES.legalValues) { Patterns.SIXES.valueError }
            _sixes = value
            calculateBonus()
            calculateTotal()
        }

    val bonus
        get() = _bonus

    var pair
        get() = if (_pair == -1) 0 else _pair
        set(value) {
            require(pair in Patterns.PAIR.legalValues) { Patterns.PAIR.valueError }
            _pair = value
            calculateBonus()
            calculateTotal()
        }

    var twoPair
        get() = if (_twoPair == -1) 0 else _twoPair
        set(value) {
            require(twoPair in Patterns.TWO_PAIR.legalValues) { Patterns.TWO_PAIR.valueError }
            _twoPair = value
            calculateBonus()
            calculateTotal()
        }

    var threeOfAKind
        get() = if (_threeOfAKind == -1) 0 else _threeOfAKind
        set(value) {
            require(threeOfAKind in Patterns.THREE_OF_A_KIND.legalValues) { Patterns.THREE_OF_A_KIND.valueError }
            _threeOfAKind = value
            calculateBonus()
            calculateTotal()
        }

    var fourOfAKind
        get() = if (_fourOfAKind == -1) 0 else _fourOfAKind
        set(value) {
            require(fourOfAKind in Patterns.FOUR_OF_A_KIND.legalValues) { Patterns.FOUR_OF_A_KIND.valueError }
            _fourOfAKind = value
            calculateBonus()
            calculateTotal()
        }

    var smallStraight
        get() = if (_smallStraight == -1) 0 else _smallStraight
        set(value) {
            require(smallStraight in Patterns.SMALL_STRAIGHT.legalValues) { Patterns.SMALL_STRAIGHT.valueError }
            _smallStraight = value
            calculateBonus()
            calculateTotal()
        }

    var largeStraight
        get() = if (_largeStraight == -1) 0 else _largeStraight
        set(value) {
            require(largeStraight in Patterns.LARGE_STRAIGHT.legalValues) { Patterns.LARGE_STRAIGHT.valueError }
            _largeStraight = value
            calculateBonus()
            calculateTotal()
        }

    var fullHouse
        get() = if (_fullHouse == -1) 0 else _fullHouse
        set(value) {
            require(fullHouse in Patterns.FULL_HOUSE.legalValues) { Patterns.FULL_HOUSE.valueError }
            _fullHouse = value
            calculateBonus()
            calculateTotal()
        }

    var chance
        get() = if (_chance == -1) 0 else _chance
        set(value) {
            require(chance in Patterns.CHANCE.legalValues) { Patterns.CHANCE.valueError }
            _chance = value
            calculateBonus()
            calculateTotal()
        }

    var yahtzee
        get() = if (_yahtzee == -1) 0 else _yahtzee
        set(value) {
            require(yahtzee in Patterns.YAHTZEE.legalValues) { Patterns.YAHTZEE.valueError }
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

    override fun toString(): String {
        return ""
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


