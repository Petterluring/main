package com.agents.consumable

class Energy(
    name: String,
    row: Int,
    column: Int,
    energyValue: Int,
    roundsPresent: Int,
    emblem: String = "🍓"):
    Consumable(name, emblem, row, column, energyValue, roundsPresent) {

    val energyValue: Int
        get() = _consumerValue
}