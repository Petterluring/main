package com.board

import com.agents.Agent
import com.agents.DynamicAgent
import kotlin.random.Random


/**
 * The board is where the Robot game is played. All kinds
 * of agents acts on board.
 */
class BoardManager(private val size: Int) {
    private val board: MutableList<MutableList<Agent?>> = MutableList(size) { MutableList(size) {null} }

    init {
        require(size >= 5) {"Board size is too small"}
    }

    companion object {
        private const val ROWERROR: String = "Row must confine with board indices"
        private const val COLUMNERROR: String = "Column must confine with board indices"
    }


    fun positionAgent(agent: Agent) {
        val row: Int = agent.row
        val column: Int = agent.column

        require(row in 0..< size) { ROWERROR }
        require(column in 0..< size) { COLUMNERROR }

        board[row][column] = agent
    }

    fun positionAgentRandomly(agent: DynamicAgent): Pair<Int, Int> {
        var row: Int
        var column: Int
        do {
            val position = Pair(Random.nextInt(size), Random.nextInt(size))
            row = position.first
            column = position.second
        } while(board[row][column] != null)
        agent.setPosition(row, column)
        board[row][column] = agent
        return Pair(row, column)
    }

    fun getAgent(row: Int, column: Int): Agent? {
        require(row in 0..< size) { ROWERROR }
        require(column in 0..< size) { COLUMNERROR }
        return board[row][column]
    }

    fun validPosition(row: Int, column: Int): Boolean {
        return row in 0..< size && column in 0..< size
    }

    fun clearPosition(row: Int, column: Int) {
        require(row in 0..< size) { ROWERROR }
        require(column in 0..< size) { COLUMNERROR }
        board[row][column] = null
    }

    fun boardToString() : String {
        val sBuilder: StringBuilder = StringBuilder()
        for (row in board) {
            for (agent in row) {
                if (agent == null) {
                    sBuilder.append(" . ")
                } else {
                    sBuilder.append(" ${agent.emblem} ")
                }
            }
            sBuilder.append("\n")
        }
        return sBuilder.toString()
    }

}