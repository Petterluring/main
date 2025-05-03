package com.agents


/*
* The protagonist of robot game. The goal of the robot is to reach home.
* */

class Robot(
    name: String,
    row: Int, // board row
    column: Int, // board column
    private var _energy: Int,
    private var _strength: Int,
    emblem: String = "🤖"
) : DynamicAgent(name, emblem, row, column) {

    var energy: Int
        get() = _energy
        set(value) {
            if (value >= 0) {
                _energy = value
            } else {
                _energy = 0
            }
        }

    var strength: Int
        get() = _strength
        set(value) {
            if (value >= 0) {
                _strength = value
            } else {
                _strength = 0
            }
        }

    fun moveUp(): Pair<Int, Int> {
        return Pair(--_row, _column)
    }

    fun moveDown(): Pair<Int, Int> {
        return Pair(++_row, _column)
    }

    fun moveLeft(): Pair<Int, Int> {
        return Pair(_row, --_column)
    }

    fun moveRight(): Pair<Int, Int> {
        return Pair(_row, ++_column)
    }

    fun statsToString(): String {
        val sBuilder = StringBuilder()
        sBuilder.append("Energy: $_energy\n")
        sBuilder.append("Strength: $_strength")
        return sBuilder.toString()
    }
}