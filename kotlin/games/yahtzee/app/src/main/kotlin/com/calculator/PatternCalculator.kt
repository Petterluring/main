package com.calculator

class PatternCalculator(
    private val _diceValues: List<Int>
) {
    private val occurences: MutableMap<Int, Int> = mutableMapOf()
    init {
        require(_diceValues.size == 5) {"There must be exactly 5 values in _diceValues"}
        _diceValues.forEach { v -> require(v in 1..6) {
            "Each value 'v' must be in the range 1 <= v <= 6"
            }
        }
        _diceValues.forEach { v ->
            occurences[v] = (occurences[v] ?: 0) + 1
        }
    }

    fun calculate() {

    }

    private fun onesToSixes(value: Int): Int {
        return _diceValues.filter { it == value }.sum()
    }

    private fun pair(): Int {
        var score = 0
        occurences.forEach { (key, count) ->
            score = if (key*2 > score && count >= 2) { key*2 } else score
        }
        return score
    }

    private fun twoPair(): Int {
        if (occurences.size == 2 || occurences.size == 3) {
            var score = 0
            occurences.forEach { (dieValue, count) ->
                score += if (count == 2 || count == 3) { dieValue * 2 } else 0
            }
        }
        return 0
    }

    private fun threeOfAKind(): Int {
        var score = 0
        occurences.forEach { (dieValue, count) ->
            score = if (count >= 3) {dieValue * 3} else score
        }
        return score
    }

    private fun fourOfAKind(): Int {
        var score = 0
        occurences.forEach { (dieValue, count) ->
            score = if (count >= 4) {dieValue * 4} else score
        }
        return score
    }

    private fun smallStraight(): Int {
        return if (occurences.size == 5 && _diceValues.sum() == 15) { 15 } else 0
    }

    private fun largeStraight(): Int {
        return if (occurences.size == 5 && _diceValues.sum() == 20) { 20 } else 0
    }

    private fun fullHouse(): Int {
        if (occurences.size == 2) {
            var score = 0
            occurences.forEach { (dieValue, count) ->
                score += if (count == 2 || count == 3) { dieValue * count } else 0
            }
            return score
        }
        return 0
    }

    private fun chance(): Int {
        return _diceValues.sum()
    }

    private fun yahtzee(): Int {
        return if (occurences.size == 1) { 50 } else 0
    }
}