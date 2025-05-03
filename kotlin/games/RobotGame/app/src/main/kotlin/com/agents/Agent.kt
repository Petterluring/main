package com.agents


/*
* Base class for the different agents on the board.
* Classes inheriting from this class have a stationary position.
* */
abstract class Agent(
    protected var _name: String,
    protected var _emblem: String,
    protected var _row: Int,
    protected var _column: Int) {

    var name: String
        get() = _name
        set(value) {
            _name = value
        }

    var emblem: String
        get() = _emblem
        set(value) {
            _emblem = value
        }

    val row: Int
        get() = _row


    val column: Int
        get() = _column


    fun getPosition(): Pair<Int, Int> {
        return Pair(_row, _column)
    }




}