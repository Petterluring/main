package main


import com.player.Player
import com.score_table.ScoreColumn
import com.score_table.ScoreTable
import kotlin.reflect.KMutableProperty0

fun main() {
    val scoreColumn = ScoreColumn()
    scoreColumn.ones = 3 * 1
    scoreColumn.twos = 3 * 2
    scoreColumn.threes = 3 * 3
    scoreColumn.fours = 3 * 4
    scoreColumn.fives = 3 * 5
    scoreColumn.sixes = 3 * 6

    print(scoreColumn.bonus)
}