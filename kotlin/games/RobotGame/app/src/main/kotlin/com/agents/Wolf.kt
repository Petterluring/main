package com.agents

import kotlin.math.abs

class Wolf(
    name: String,
    row: Int,
    column: Int,
    private val _attackValue: Int,
    emblem: String = "🐺"

) : DynamicAgent(name, emblem, row, column) {

    val attackValue: Int
        get() = _attackValue

    init {
        require(_attackValue > 0) {"attackValue must exceed 0"}
    }

    fun moveCloserToAgent(row: Int, column: Int): Pair<Int, Int> {
        val dr = abs(row - _row)
        val dc = abs(column - _column)

        if (dr > dc) {
            if (_row > row) {
                _row--
            } else {
                _row++
            }
        } else if (dr < dc) {
            if (_column > column) {
                _column--
            } else {
                _column++
            }
        }
        return Pair(_row, _column)
    }

}