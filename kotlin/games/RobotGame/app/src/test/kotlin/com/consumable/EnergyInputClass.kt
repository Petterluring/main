package com.consumable

import com.agents.consumable.Energy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Covers the testing of Consumable.
 */
class EnergyInputClass {
    val energy = Energy("Name", 0, 0,1, 1)

    @Test
    fun canInitProperties() {
        assertEquals(1, energy.energyValue)
        assertEquals(1, energy.roundsPresent)
    }

    @Test
    fun canThrowInInit() {
        assertThrows<IllegalArgumentException> {
            Energy("Name",0, 0,0, 1)
        }
        assertThrows<IllegalArgumentException> {
            Energy("Name",0, 0,1, 0)
        }
    }

    @Test
    fun currentRoundCanSet() {
        energy.currentRound = 4
        assertEquals(4, energy.currentRound)

        assertThrows<IllegalArgumentException> {
            energy.currentRound = -1
        }
        assertThrows<IllegalArgumentException> {
            energy.currentRound = 0
        }
    }

    @Test
    fun canDecrementCurrentRound() {
        energy.currentRound = 5
        energy.decrementCurrentRound()
        assertEquals(4, energy.currentRound)
    }


}