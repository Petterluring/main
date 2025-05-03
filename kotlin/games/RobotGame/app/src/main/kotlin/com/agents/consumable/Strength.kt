package com.agents.consumable

class Strength(
    name: String,
    row: Int,
    column: Int,
    strengthValue: Int,
    roundsPresent: Int,
    emblem: String = "💪"):
    Consumable(name, emblem, row, column, strengthValue, roundsPresent) {

    val strengthValue: Int
        get() = _consumerValue
}