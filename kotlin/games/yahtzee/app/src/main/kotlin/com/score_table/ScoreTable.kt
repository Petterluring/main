package com.score_table

import com.player.Player

class ScoreTable(val players: List<Player>) {
    private val _scoreColumns = mutableMapOf<Player, ScoreColumn>()

    init {
        players.forEach { player -> _scoreColumns.put(player, ScoreColumn()) }
    }

    fun getScoreColumn(player: Player?): ScoreColumn? {
        return _scoreColumns[player]
    }

    fun removePlayer(player: Player) {
        if (_scoreColumns[player] != null) { _scoreColumns.remove(player) }
    }

}