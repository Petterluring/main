package com.game.container

import com.agents.Agent
import com.agents.Home
import com.agents.Robot
import com.agents.Wolf
import com.agents.consumable.Consumable
import com.agents.consumable.Energy
import com.agents.consumable.Strength
import com.board.BoardManager

class ContainerFactory(private var _boardSize: Int) {
    private var _robotName: String = "Robot"
    private var _homeName: String = "Home"
    private var _wolfNames: List<String> = listOf("Curt", "Richard", "Maggie")

    var boardSize
        get() = _boardSize
        set(value) {
            require(value >= 10) { BOARDSIZEERROR }
            _boardSize = value
        }

    init {
        require(_boardSize >= 10) { BOARDSIZEERROR }
    }

    companion object {
        const val BOARDSIZEERROR = "Board size must at least be 10"
    }

    fun constructContainer(): Container {
        val boardManager = BoardManager(boardSize)
        val robot = Robot(_robotName, 0, 0, 15, 3)

        val wolves: List<Wolf> = listOf(
            Wolf(_wolfNames[0], 0, boardSize - 1, 1),
            Wolf(_wolfNames[1], boardSize - 1, 0, 1)
        )

        val home = Home(_homeName, boardSize - 1, boardSize - 1)

        val agents: List<Agent> = listOf(robot, home) + wolves
        for (agent in agents) {
            boardManager.positionAgent(agent)
        }

        val energyBars: List<Energy> = arrayListOf(
            Energy("E1", 0, 0, 5, 10),
            Energy("E2", 0, 0, 5, 10)
        )


        val strengthBars: List<Strength> = arrayListOf(
            Strength("E1", 0, 0, 1, 10),
            Strength("E2", 0, 0, 1, 10)
        )
        val consumables: List<Consumable> = energyBars + strengthBars
        for (consumable in consumables) {
            boardManager.positionAgentRandomly(consumable)
        }
        return Container(robot, wolves, energyBars, strengthBars, home, boardManager)
    }

    fun constructContainer(difficulty: String): Container? {
        return when(difficulty.uppercase()) {
            "EASY" -> getEasyContainer()
            "MEDIUM" -> getMediumContainer()
            "HARD" -> getHardContainer()
            else -> null
        }

    }

    private fun getEasyContainer(): Container {
        val boardManager = BoardManager(boardSize)
        val robot = Robot(_robotName, 0, 0, 30, 4)

        val wolves: List<Wolf> = listOf(
            Wolf(_wolfNames[0], 0, boardSize - 1, 1)
        )

        val home = Home(_homeName, boardSize - 1, boardSize - 1)

        val agents: List<Agent> = listOf(robot, home) + wolves
        for (agent in agents) {
            boardManager.positionAgent(agent)
        }

        val energyBars: List<Energy> = arrayListOf(
            Energy("E1", 0, 0, 10, 10),
            Energy("E2", 0, 0, 10, 10),
            Energy("E3", 0, 0, 10, 10)
        )


        val strengthBars: List<Strength> = arrayListOf(
            Strength("E1", 0, 0, 1, 10),
            Strength("E2", 0, 0, 1, 10),
            Strength("E3", 0, 0, 1, 10)
        )
        val consumables: List<Consumable> = energyBars + strengthBars
        for (consumable in consumables) {
            boardManager.positionAgentRandomly(consumable)
        }
        return Container(robot, wolves, energyBars, strengthBars, home, boardManager)
    }

    private fun getMediumContainer(): Container {
        val boardManager = BoardManager(boardSize)
        val robot = Robot(_robotName, 0, 0, 25, 4)

        val wolves: List<Wolf> = listOf(
            Wolf(_wolfNames[0], 0, boardSize - 1, 1),
            Wolf(_wolfNames[1], boardSize - 1, 0, 1)
        )

        val home = Home(_homeName, boardSize - 1, boardSize - 1)

        val agents: List<Agent> = listOf(robot, home) + wolves
        for (agent in agents) {
            boardManager.positionAgent(agent)
        }

        val energyBars: List<Energy> = arrayListOf(
            Energy("E1", 0, 0, 8, 10),
            Energy("E2", 0, 0, 8, 10),
            Energy("E2", 0, 0, 8, 10)
        )


        val strengthBars: List<Strength> = arrayListOf(
            Strength("E1", 0, 0, 1, 10),
            Strength("E2", 0, 0, 1, 10),
            Strength("E2", 0, 0, 1, 10)
        )
        val consumables: List<Consumable> = energyBars + strengthBars
        for (consumable in consumables) {
            boardManager.positionAgentRandomly(consumable)
        }
        return Container(robot, wolves, energyBars, strengthBars, home, boardManager)
    }

    private fun getHardContainer(): Container {
        val boardManager = BoardManager(boardSize)
        val robot = Robot(_robotName, 0, 0, 15, 3)

        val wolves: List<Wolf> = listOf(
            Wolf(_wolfNames[0], 0, boardSize - 1, 1),
            Wolf(_wolfNames[1], boardSize - 1, 0, 1),
            Wolf(_wolfNames[2], boardSize - 1, 1, 1)
        )

        val home = Home(_homeName, boardSize - 1, boardSize - 1)

        val agents: List<Agent> = listOf(robot, home) + wolves
        for (agent in agents) {
            boardManager.positionAgent(agent)
        }

        val energyBars: List<Energy> = arrayListOf(
            Energy("E1", 0, 0, 8, 10),
            Energy("E2", 0, 0, 8, 5)
        )


        val strengthBars: List<Strength> = arrayListOf(
            Strength("E1", 0, 0, 1, 10),
            Strength("E2", 0, 0, 1, 5)
        )
        val consumables: List<Consumable> = energyBars + strengthBars
        for (consumable in consumables) {
            boardManager.positionAgentRandomly(consumable)
        }
        return Container(robot, wolves, energyBars, strengthBars, home, boardManager)
    }
}