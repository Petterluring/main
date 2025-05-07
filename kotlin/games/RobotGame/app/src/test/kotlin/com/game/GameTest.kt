package com.game

import com.agents.Robot
import com.game.container.ContainerFactory
import org.junit.jupiter.api.Test
import java.io.StringReader
import java.io.StringWriter
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class GameTest {
    private val containerFactory = ContainerFactory(10)
    private val container = containerFactory.constructContainer()
    private val game = Game(container)
    private val writer = StringWriter()

    @Test
    fun canQuitGame() {
        val reader = StringReader("quit\n")
        game.start(reader, writer)
        assertTrue(writer.toString().endsWith("Quitting game...\n"))
    }

    @Test
    fun canIdentifyInvalidInput() {
        val input = StringReader("wiefowejf\nquit\n")

        game.start(input, writer)
        assertTrue(writer.toString().contains("Not a valid input"))
    }

    @Test
    fun canIdentifyInvalidDirections() {
        val input = StringReader("g\nquit\n")
        game.start(input, writer)

        assertTrue(writer.toString().contains("Direction is not valid\n"))
    }

    @Test
    fun robotCanMoveUp() {
        val robot = container.robot
        val boardManager = container.boardManager
        boardManager.clearPosition(robot.row, robot.column)
        robot.setPosition(5, 5)
        boardManager.positionAgent(robot)

        val reader = StringReader("w\nquit\n")
        game.start(reader, writer)

        assertEquals(4, robot.row)
        assertEquals(5, robot.column)
        assertNull(boardManager.getAgent(5, 5))
        assertNotNull(boardManager.getAgent(4, 5))
        assertTrue(boardManager.getAgent(4, 5) is Robot)

    }

    @Test
    fun robotCanMoveRight() {
        val robot = container.robot
        val boardManager = container.boardManager
        boardManager.clearPosition(robot.row, robot.column)
        robot.setPosition(5, 5)
        boardManager.positionAgent(robot)

        val reader = StringReader("d\nquit\n")
        game.start(reader, writer)

        assertEquals(5, robot.row)
        assertEquals(6, robot.column)
        assertNull(boardManager.getAgent(5, 5))
        assertNotNull(boardManager.getAgent(5, 6))
        assertTrue(boardManager.getAgent(5, 6) is Robot)
    }

    @Test
    fun robotCanMoveDown() {
        val robot = container.robot
        val boardManager = container.boardManager
        boardManager.clearPosition(robot.row, robot.column)
        robot.setPosition(5, 5)
        boardManager.positionAgent(robot)

        val reader = StringReader("s\nquit\n")
        game.start(reader, writer)

        assertEquals(6, robot.row)
        assertEquals(5, robot.column)
        assertNull(boardManager.getAgent(5, 5))
        assertNotNull(boardManager.getAgent(6, 5))
        assertTrue(boardManager.getAgent(6, 5) is Robot)
    }

    @Test
    fun robotCanMoveLeft() {
        val robot = container.robot
        val boardManager = container.boardManager
        boardManager.clearPosition(robot.row, robot.column)
        robot.setPosition(5, 5)
        boardManager.positionAgent(robot)

        val reader = StringReader("a\nquit\n")
        game.start(reader, writer)

        assertEquals(5, robot.row)
        assertEquals(4, robot.column)
        assertNull(boardManager.getAgent(5, 5))
        assertNotNull(boardManager.getAgent(5, 4))
        assertTrue(boardManager.getAgent(5, 4) is Robot)
    }

    @Test
    fun robotCanConsumeEnergy() {
        val robot = container.robot
        val boardManager = container.boardManager
        val energy = container.energyBars[0]

        boardManager.clearPosition(energy.row, energy.column)
        energy.setPosition(1, 0)
        boardManager.positionAgent(energy)

        val reader = StringReader("s\nquit\n")
        game.start(reader, writer)

        assertEquals(15 - 1 + 5, robot.energy)
    }

    @Test
    fun robotCanConsumeStrength() {
        val robot = container.robot
        val boardManager = container.boardManager
        val strength = container.strengthBars[0]

        boardManager.clearPosition(strength.row, strength.column)
        strength.setPosition(1, 0)
        boardManager.positionAgent(strength)

        val reader = StringReader("s\nquit\n")
        game.start(reader, writer)

        assertEquals(3 + 1, robot.strength)
    }

    @Test
    fun robotCanLoseStrength() {
        val robot = container.robot
        val boardManager = container.boardManager
        val wolf = container.wolves[0]

        boardManager.clearPosition(wolf.row, wolf.column)
        wolf.setPosition(1, 0)
        boardManager.positionAgent(wolf)

        val reader = StringReader("s\nquit\n")
        game.start(reader, writer)

        assertEquals(3 - 1, robot.strength)
    }

    @Test
    fun robotCanGoHome() {
        val robot = container.robot
        val boardManager = container.boardManager

        boardManager.clearPosition(robot.row, robot.column)
        robot.setPosition(8, 9)
        boardManager.positionAgent(robot)

        val reader = StringReader("s\n")
        game.start(reader, writer)

        assertTrue(writer.toString().contains("You reached home"))
    }

    @Test
    fun robotConsumeEnergyAfterMove() {
        val robot = container.robot
        assertEquals(15, robot.energy)

        val reader = StringReader("s\nquit\n")
        game.start(reader, writer)

        assertEquals(14, robot.energy)
    }

    @Test
    fun wolfCanConsumeStrenght() {
        val robot = container.robot
        val boardManager = container.boardManager
        assertEquals(3, robot.strength)

        val wolf = container.wolves[0]
        boardManager.clearPosition(wolf.row, wolf.column)
        wolf.setPosition(1, 1)
        boardManager.positionAgent(wolf)

        val reader = StringReader("d\nquit\n")

        game.start(reader, writer)

        assertEquals(2, robot.strength)
    }

    @Test
    fun robotCanStarve() {
        val robot = container.robot
        robot.energy = 1

        val reader = StringReader("d\n")
        game.start(reader, writer)
        assertEquals(0, robot.energy)
        assertTrue(writer.toString().contains("Out of energy"))
    }

    @Test
    fun robotCanBeEaten() {
        val container = containerFactory.constructContainer()
        val robot = container.robot
        val wolf = container.wolves[0]
        val boardManager = container.boardManager

        boardManager.clearPosition(wolf.row, wolf.column)
        wolf.setPosition(1, 1)
        boardManager.positionAgent(wolf)
        robot.strength = 1

        val reader = StringReader("d\n")
        val game = Game(container)
        game.start(reader, writer)
        assertEquals(0, robot.strength)
        assertTrue(writer.toString().contains("The wolves ate"))
    }

}