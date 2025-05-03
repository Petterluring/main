package com.agent

import com.agents.Robot
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


/*
* This class include the testing of Agent and Dynamic agent*/


class RobotInputClass {
    private final val robot = Robot("Name",0, 0, 1, 2)


    @Test
    fun canInitProperties() {
        assertTrue { "Name".equals(robot.name) }
        assertEquals(0, robot.row)
        assertEquals(0, robot.column)
        assertEquals(1, robot.energy)
        assertEquals(2, robot.strength)
    }

    @Test
    fun canSetPosition() {
        robot.setPosition(3, 4)
        assertEquals(3, robot.row)
        assertEquals(4, robot.column)
    }

    @Test
    fun canGetPosition() {
        val (row, column) = robot.getPosition()
        assertEquals(0, row)
        assertEquals(0, column)
    }

    @Test
    fun canSetEnergy() {
        robot.energy = 5
        assertEquals(5, robot.energy)
        robot.energy = -4
        assertEquals(0, robot.energy)

    }

    @Test
    fun canSetStrenght() {
        robot.strength = 5
        assertEquals(5, robot.strength)
        robot.strength = -5
        assertEquals(0, robot.strength)
    }

    @Test
    fun canMovePosition() {
        robot.move(2, 3)
        assertEquals(2, robot.row)
        assertEquals(3, robot.column)

        robot.move(-4, -6)
        assertEquals(-2, robot.row)
        assertEquals(-3, robot.column)
    }


    @Test
    fun canMoveUp() {
        val (row, column) = robot.moveUp()
        assertEquals(-1, row)
        assertEquals(0, column)

        assertEquals(-1, robot.row)
        assertEquals(0, robot.column)
    }

    @Test
    fun canMoveDown() {
        val (row, column) = robot.moveDown()
        assertEquals(1, row)
        assertEquals(0, column)

        assertEquals(1, robot.row)
        assertEquals(0, robot.column)

    }

    @Test
    fun canMoveLeft() {
        val (row, column) = robot.moveLeft()
        assertEquals(0, row)
        assertEquals(-1, column)

        assertEquals(0, robot.row)
        assertEquals(-1, robot.column)

    }

    @Test
    fun canMoveRight() {
        val (row, column) = robot.moveRight()
        assertEquals(0, row)
        assertEquals(1, column)

        assertEquals(0, robot.row)
        assertEquals(1, robot.column)

    }

}