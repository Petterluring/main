package com.die

class DiceSet(private val dice: List<Die>) {

    fun rollAll(): List<Int> {
        return dice.map { die -> die.roll() }
    }

    /**
     * Selects particular dice to be rolled.
     * The dice are selected by specifying their indices in the list of dice.
     * */
    fun selectiveRoll(vararg indices: Int): List<Int> {
        require(indices.size in 1..dice.size) {
            "Amount of indices 's' must be in the range 1 <= s <= ${dice.size}"
        }

        indices.forEach {
            i -> require(i in 0..dice.size - 1) {
                "Each index i must be in the range 0 <= i <= ${dice.size - 1}"
            }
        }

        val occurences = MutableList(dice.size) { 0 }
        indices.forEach { i -> occurences[i]++ }
        occurences.forEach { o -> require(o in 0..1) {
            "Each unique index may occur at most once."
            }
        }

        indices.forEach { i -> dice[i].roll() }
        return getDiceValues()
    }

    fun getDiceValues(): List<Int> {
        return dice.map { die -> die.currentValue }
    }

    fun getDiceAmount(): Int { return dice.size }
}