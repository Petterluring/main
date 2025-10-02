package main


import com.player.Player
import com.score_table.ScoreTable
import kotlin.reflect.KMutableProperty0

fun main() {
    val jon = Player("Jon", "Doe")
    val lisa = Player("Lisa", "Anderson")
    val jacob = Player("Jacob", "Mitchel")
    val scoreTable = ScoreTable(listOf(jon, lisa, jacob))

    val scoreColumn = scoreTable.getScoreColumn(jon)
    if (scoreColumn != null) {
        scoreColumn.ones = 5
        scoreColumn.twos = 5*2
        scoreColumn.threes = 5*3
        scoreColumn.fours = 5*4
        scoreColumn.fives = 5*5
        scoreColumn.sixes = 5*6
    }

    println(scoreTable.toString())
}