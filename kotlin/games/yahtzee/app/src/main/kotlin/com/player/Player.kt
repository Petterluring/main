package com.player

import com.die.DiceSet
import com.die.Die

class Player(
    val firstName: String,
    val  lastName: String
) {

    val dice: DiceSet = DiceSet(listOf(
        Die(1, 6),
        Die(1, 6),
        Die(1, 6),
        Die(1, 6),
        Die(1, 6),
        )
    )

    val name: String
        get() = "$firstName $lastName"

    val initials: String
        get() = "${firstName.first()}${lastName.first()}"

}