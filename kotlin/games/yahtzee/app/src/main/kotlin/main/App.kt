package main

import com.die.DiceSet
import com.die.Die
import kotlin.random.Random


fun main() {
    val diceSet = DiceSet(
        listOf(
            Die(1, 6),
            Die(1, 6),
            Die(1, 6),
            Die(1, 6),
            Die(1, 6)
        )
    )

    diceSet.selectiveRoll(4, 4)
}