package com.player

import com.die.DiceSet
import com.die.Die

class Player(
    val firstName: String,
    val  lastName: String,
    val      dice: DiceSet
) {
    val name: String
        get() = "$firstName $lastName"

    val initials: String
        get() = "${firstName.first()}${lastName.first()}"

}