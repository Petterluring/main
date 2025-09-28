package com.pattern

class PatternCalculator {
    private var _diceValues: List<Int> = listOf()
    private val occurences: MutableMap<Int, Int> = mutableMapOf()

    var diceValues: List<Int>
        get() = _diceValues
        set(value) {
            require(value.size == 5) {"There must be exactly 5 values in 'diceValues'"}
            value.forEach { v -> require(v in 1..6) {
                "Each value 'v' must be in the range 1 <= v <= 6 in 'diceValues'"
                }
            }
            if (occurences.isNotEmpty()) { occurences.clear() }
            value.forEach { v ->
                occurences[v] = (occurences[v] ?: 0) + 1
            }
            _diceValues = value
        }

    fun calculate(): PatternScore {
        check(_diceValues.isNotEmpty()) {"diceValues must be set before any calculations can be made."}
        return PatternScore(
            onesToSixes(1),
            onesToSixes(2),
            onesToSixes(3),
            onesToSixes(4),
            onesToSixes(5),
            onesToSixes(6),
            pair(),
            twoPair(),
            threeOfAKind(),
            fourOfAKind(),
            smallStraight(),
            largeStraight(),
            fullHouse(),
            chance(),
            yahtzee()
        )
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
        var score = 0
        if (occurences.size == 2 || occurences.size == 3) {
            occurences.forEach { (dieValue, count) ->
                score += if (count == 2 || count == 3) { dieValue * 2 } else 0
            }
        }
        return score
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