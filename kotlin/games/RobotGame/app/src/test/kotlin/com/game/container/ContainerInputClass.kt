package com.game.container

import com.agents.Home
import com.agents.Robot
import com.agents.Wolf
import com.agents.consumable.Energy
import com.agents.consumable.Strength
import com.board.BoardManager
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class ContainerInputClass {
    private val boardSize = 10
    private val container = Container(
        Robot("Robot", 0, 0, 15, 3),
        arrayListOf(
            Wolf("Curt", 0, boardSize - 1, 1),
            Wolf("Richard", boardSize - 1, 0, 1)
        ),
        arrayListOf(
            Energy("E1", 0, 0, 5, 10),
            Energy("E2", 0, 0, 5, 10)
        ),
        arrayListOf(
            Strength("E1", 0, 0, 1, 10),
            Strength("E2", 0, 0, 1, 10)
        ),
        Home("Home", boardSize - 1, boardSize - 1),
        BoardManager(boardSize)
    )


    @Test
    fun canGetDynamicAgents() {
        val agents = container.getDynamicAgents()
        assertTrue(agents.size == 7)
        for (agent in agents) {
            assertTrue {
                agent is Robot || agent is Wolf ||
                agent is Strength || agent is Energy
            }
        }
    }

    @Test
    fun canGetConsumables() {
        val agents = container.getConsumables()
        assertTrue(agents.size == 4)
        for (agent in agents) {
            assertTrue {
                agent is Strength || agent is Energy
            }
        }
    }
}