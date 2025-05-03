package com.agents.consumable

import com.agents.Agent
import com.agents.DynamicAgent

/**
 * A consumable is an object that can be consumed by the robot. For instance, an
 * energy bar.
 */
abstract class Consumable(
    name: String,
    emblem: String,
    row: Int,
    column: Int,
    protected val _consumerValue: Int,
    protected val _roundsPresent: Int):
    DynamicAgent(name, emblem, row, column) {

    companion object {
        const val ROUNDSPRESENTERROR = "roundsPresent must exceed 0"
    }

    val roundsPresent: Int
        get() = _roundsPresent

    var currentRound: Int = _roundsPresent
        set(value) {
            require(value > 0) { ROUNDSPRESENTERROR}
            field = value
        }

    init {
        require(_consumerValue > 0) {"consumerValue must exceed 0"}
        require(_roundsPresent > 0) {ROUNDSPRESENTERROR}
    }

    fun decrementCurrentRound(): Int {
        return when {
            currentRound > 0 -> currentRound--
            else -> currentRound
        }
    }

}