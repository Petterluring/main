package com.game

import com.agents.*
import com.agents.consumable.Energy
import com.agents.consumable.Strength
import com.game.container.Container
import com.game.settings.DirectionKeys


class Game(private val container: Container) {

    private var directionKeys: DirectionKeys = DirectionKeys(
        'w', 'd', 's', 'a'
    )

    private var isHome = false
    private var isDead = false
    private var isStarved = false


    fun start() {
        val boardManager = container.boardManager
        val robot = container.robot
        do {
            println(boardManager.boardToString())
            println(robot.statsToString())
            print("Enter a direction: ")

            val input = readln().lowercase()
            if (input.equals("quit")) {
                println("Quiting game...")
                break
            }

            // From here, the only valid input is a direction, which is one character
            if (input.length > 1) {
                println("Not a valid input")
                continue
            }

            val direction = input.single()
            val validDirection = direction in setOf(
                directionKeys.north,
                directionKeys.east,
                directionKeys.south,
                directionKeys.west
            )

            if (!validDirection) {
                println("Direction is not valid")
                continue
            }

            val oldRow = robot.row
            val oldColumn = robot.column

            // Move robot
            when(direction) {
                directionKeys.north -> robot.moveUp()
                directionKeys.east -> robot.moveRight()
                directionKeys.south -> robot.moveDown()
                directionKeys.west -> robot.moveLeft()
            }

            val newRow = robot.row
            val newColumn = robot.column
            if (!boardManager.validPosition(newRow, newColumn)) {
                println("You cannot move outside the bounds of the board")
                container.robot.setPosition(oldRow, oldColumn)
                continue
            }

            // Does the robot run into other agents?
            if (boardManager.getAgent(newRow, newColumn) != null) {
                //robotInteraction(boardManager.getAgent(newRow, newColumn)!!, robot)
                val agent = boardManager.getAgent(newRow, newColumn)
                when {
                    agent is Energy -> {
                        val energy = agent as Energy
                        robot.energy += energy.energyValue
                        boardManager.positionAgentRandomly(energy)
                    }
                    agent is Strength -> {
                        val strength = agent as Strength
                        robot.strength += strength.strengthValue
                        boardManager.positionAgentRandomly(strength)
                    }
                    agent is Wolf -> {
                        val wolf = agent as Wolf
                        robot.strength -= wolf.attackValue
                        boardManager.positionAgentRandomly(wolf)
                    }
                    agent is Home -> {
                        isHome = true
                        break
                    }
                }
            }
            boardManager.clearPosition(oldRow, oldColumn)
            boardManager.positionAgent(robot)
            robot.energy -= 1

            // Move wolves
            for (wolf in container.wolves) {
                boardManager.clearPosition(wolf.row, wolf.column)
                val (row, column) = wolf.moveCloserToAgent(robot.row, robot.column)
                if (boardManager.getAgent(row, column) is Robot) {
                    robot.strength -= wolf.attackValue
                    boardManager.positionAgentRandomly(wolf)
                } else {
                    boardManager.positionAgent(wolf)
                }
            }

            if (robot.energy == 0) {
                isStarved = true
            } else if (robot.strength == 0) {
                isDead = true
            }
        } while (!isHome && !isDead && !isStarved)

        if (isHome) {
            println("You reached home and won the game!!")
        } else if (isDead) {
            println("You died because of the wolves")
        } else if (isStarved) {
            println("You died because of starvation")
        }
    }
}