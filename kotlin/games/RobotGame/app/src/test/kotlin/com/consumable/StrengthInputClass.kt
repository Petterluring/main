package com.consumable

import com.agents.consumable.Strength
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StrengthInputClass {
    private val strength: Strength = Strength("Name",0, 0,2, 5)

    @Test
    fun canGetStrength() {
        assertEquals(2, strength.strengthValue)
    }

}