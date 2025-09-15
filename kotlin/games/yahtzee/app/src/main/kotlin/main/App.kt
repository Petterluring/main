package main

import com.die.DiceSet
import com.die.Die
import kotlin.random.Random


fun main() {
    val threeOfAKindScores = buildSet {
        add(0)
        for (t1 in 1..6) {
            for (t2 in 1..6) {
                if (t1 == t2) continue
                add(t1 * 3 + t2 * 2)
            }
        }
    }
    println(threeOfAKindScores)
    println(threeOfAKindScores.size - 1)
}