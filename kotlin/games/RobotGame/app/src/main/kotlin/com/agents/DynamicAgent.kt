package com.agents

/*
* Base class for agents that may move on the board.
 */
abstract class DynamicAgent(
    name: String,
    emblem: String,
    row: Int,
    column: Int)
    : Agent(name, emblem, row, column) {

    fun setPosition(row: Int, column: Int) {
        _row = row
        _column = column
    }

    fun move(dr: Int, dc: Int) {
        _row += dr
        _column += dc
    }
}