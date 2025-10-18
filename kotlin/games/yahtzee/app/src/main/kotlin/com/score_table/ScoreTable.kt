package com.score_table

import com.player.Player

class ScoreTable(players: List<Player>) {
    private val _scoreColumns = mutableMapOf<Player, ScoreColumn>()

    init {
        players.forEach { player -> _scoreColumns.put(player, ScoreColumn()) }
    }

    fun getScoreColumn(player: Player): ScoreColumn? {
        return _scoreColumns[player]
    }

    fun removePlayer(player: Player) {
        if (_scoreColumns.containsKey(player)) { _scoreColumns.remove(player) }
    }

    fun addPlayer(player: Player) {
        require(!_scoreColumns.containsKey(player)) {"Player already exist."}
        _scoreColumns.put(player, ScoreColumn())
    }

    fun playerExists(player: Player): Boolean {
        return _scoreColumns.containsKey(player)
    }

    override fun toString(): String {
        val scoreNames = listOf("P", "Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "Bonus",
            "Pair", "TwoPair", "ThreeKind", "FourKind", "SmallStr", "LargeStr",
            "FullH", "Chance", "Yahtzee", "Total")

        val rows = scoreNames.size
        var maxLen = 0
        scoreNames.forEach { name -> maxLen = if (name.length > maxLen) name.length else maxLen }
        val columns = _scoreColumns.size + 1

        val matrix = MutableList(rows) { MutableList(columns) {""} }
        for (i in 0..< scoreNames.size) {
            val name = scoreNames[i]
            matrix[i][0] = " ".repeat(maxLen - name.length) + name
        }

        var column = 1
        _scoreColumns.forEach { player, scoreColumn ->
            matrix[0][column] = "  "                                                          + player.initials
            matrix[1][column] = "   "                                                         + scoreColumn.ones.toString()
            matrix[2][column] = " ".repeat( if (scoreColumn.twos         == 10) 2 else 3) + scoreColumn.twos.toString()
            matrix[3][column] = " ".repeat( if (scoreColumn.threes       >= 10) 2 else 3) + scoreColumn.threes.toString()
            matrix[4][column] = " ".repeat( if (scoreColumn.fours        >= 10) 2 else 3) + scoreColumn.fours.toString()
            matrix[5][column] = " ".repeat( if (scoreColumn.fives        >= 10) 2 else 3) + scoreColumn.fives.toString()
            matrix[6][column] = " ".repeat( if (scoreColumn.sixes        >= 10) 2 else 3) + scoreColumn.sixes.toString()
            matrix[7][column] = " ".repeat( if (scoreColumn.bonus        >= 10) 2 else 3) + scoreColumn.bonus.toString()
            matrix[8][column] = " ".repeat( if (scoreColumn.pair         >= 10) 2 else 3) + scoreColumn.pair.toString()
            matrix[9][column] = " ".repeat( if (scoreColumn.twoPair      >= 10) 2 else 3) + scoreColumn.twoPair.toString()
            matrix[10][column] = " ".repeat(if (scoreColumn.threeOfAKind >= 10) 2 else 3) + scoreColumn.threeOfAKind.toString()
            matrix[11][column] = " ".repeat(if (scoreColumn.fourOfAKind  >= 10) 2 else 3) + scoreColumn.fourOfAKind.toString()
            matrix[12][column] = " ".repeat(if (scoreColumn.smallStraight>= 10) 2 else 3) + scoreColumn.smallStraight.toString()
            matrix[13][column] = " ".repeat(if (scoreColumn.largeStraight>= 10) 2 else 3) + scoreColumn.largeStraight.toString()
            matrix[14][column] = " ".repeat(if (scoreColumn.fullHouse    >= 10) 2 else 3) + scoreColumn.fullHouse.toString()
            matrix[15][column] = " ".repeat(if (scoreColumn.chance       >= 10) 2 else 3) + scoreColumn.chance.toString()
            matrix[16][column] = " ".repeat(if (scoreColumn.yahtzee      >= 10) 2 else 3) + scoreColumn.yahtzee.toString()
            matrix[17][column] = " ".repeat(if (scoreColumn.total >= 100) 1 else if(scoreColumn.total >= 10) 2 else 3) +
                                     scoreColumn.total.toString()
            column++
        }
        return matrix.joinToString("") { row -> row.joinToString("") + "\n" }
    }

}