package com.score_table

import kotlin.compareTo


class ScoreColumn {
    private var _ones          = -1
    private var _twos          = -1
    private var _threes        = -1
    private var _fours         = -1
    private var _fives         = -1
    private var _sixes         = -1
    private var _bonus         =  0
    private var _pair          = -1
    private var _twoPair       = -1
    private var _threeOfAKind  = -1
    private var _fourOfAKind   = -1
    private var _smallStraight = -1
    private var _largeStraight = -1
    private var _fullHouse     = -1
    private var _chance        = -1
    private var _yahtzee       = -1
    private var _total         =  0

    companion object {
        private const val VALUE_ERROR = "Illegal value"
    }

    var ones
        get() = _ones
        set(value) {
            require(value in 0..5) {VALUE_ERROR}
            _ones = value
            calculateBonus()
            calculateTotal()
        }

    var twos
        get() = _twos
        set(value) {
            require(value in setOf(0, 2, 4, 6, 8, 10)) {VALUE_ERROR}
            _twos = value
            calculateBonus()
            calculateTotal()
        }

    var threes
        get() = _threes
        set(value) {
            require(value in setOf(0, 3, 6, 9, 12, 15)) {VALUE_ERROR}
            _threes = value
            calculateBonus()
            calculateTotal()
        }

    var fours
        get() = _fours
        set(value) {
            require(value in setOf(0, 4, 8, 12, 16, 20)) {VALUE_ERROR}
            _fours = value
            calculateBonus()
            calculateTotal()
        }

    var fives
        get() = _fives
        set(value) {
            require(value in setOf(0, 5, 10, 15, 20, 25)) {VALUE_ERROR}
            _fives = value
            calculateBonus()
            calculateTotal()
        }

    var sixes
        get() = _sixes
        set(value) {
            require(value in setOf(0, 6, 12, 18, 24, 30)) {VALUE_ERROR}
            _sixes = value
            calculateBonus()
            calculateTotal()
        }

    val bonus
        get() = _bonus

    var pair
        get() = _pair
        set(value) {
            require(value in setOf(0, 2, 4, 6, 8, 10, 12)) {VALUE_ERROR}
            _pair = value
            calculateBonus()
            calculateTotal()
        }

    var twoPair
        get() = _twoPair
        set(value) {
            require(value in setOf(0, 6, 8, 10, 12, 14, 16, 18, 20, 22)) {VALUE_ERROR}
            _twoPair = value
            calculateBonus()
            calculateTotal()
        }

    var threeOfAKind
        get() = _threeOfAKind
        set(value) {
            require(value in setOf(0, 3, 6, 9, 12, 15, 18)) {VALUE_ERROR}
            _threeOfAKind = value
            calculateBonus()
            calculateTotal()
        }

    var fourOfAKind
        get() = _fourOfAKind
        set(value) {
            require(value in setOf(0, 4, 8, 12, 16, 20, 24)) {VALUE_ERROR}
            _fourOfAKind = value
            calculateBonus()
            calculateTotal()
        }

    var smallStraight
        get() = _smallStraight
        set(value) {
            require(value in setOf(0, 15)) {VALUE_ERROR}
            _smallStraight = value
            calculateBonus()
            calculateTotal()
        }

    var largeStraight
        get() = _largeStraight
        set(value) {
            require(value in setOf(0, 20)) {VALUE_ERROR}
            _largeStraight = value
            calculateBonus()
            calculateTotal()
        }

    var fullHouse
        get() = _fullHouse
        set(value) {
            require(value in setOf(
                0, 7, 9, 11, 13, 15, 8, 12, 14, 16, 18, 17, 19,
                21, 22, 24, 23, 27, 20, 26, 28)) {VALUE_ERROR}
            _fullHouse = value
            calculateBonus()
            calculateTotal()
        }

    var chance
        get() = _chance
        set(value) {
            require(value in 0..6*5) {VALUE_ERROR}
            _chance = value
            calculateBonus()
            calculateTotal()
        }

    var yahtzee
        get() = _yahtzee
        set(value) {
            require(value in setOf(0, 50)) {VALUE_ERROR}
            _yahtzee = value
            calculateBonus()
            calculateTotal()
        }

    val total
        get() = _total

    private fun calculateBonus() {
        val total = listOf(_ones, _twos, _threes, _fours, _fives, _sixes).filter { it > -1 }.sum()
        _bonus = if (total >= 63) { 50 } else { 0 }
        }

    private fun calculateTotal() {
        _total = listOf(
            _ones, _twos, _threes, _fours, _fives, _sixes,
            _bonus, _pair, _twoPair, _threeOfAKind, _fourOfAKind,
            _smallStraight, _largeStraight, _fullHouse, _chance,
            _yahtzee).filter { it > -1 }.sum()
    }
}


