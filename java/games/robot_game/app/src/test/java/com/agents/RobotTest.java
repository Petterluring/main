package com.agents;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.position.DynamicPosition;

/**
 * This test class includes testing of Agent.java as well
 */
public class RobotTest {
    private final Robot robot = new Robot(
            "Robot",
            "T",
            new DynamicPosition(0, 0),
            2,
            2);

    @Test
    void constructorAssignsVariablesCorrectly() {
        assertEquals("Robot", robot.getName());
        assertEquals("T", robot.getEmblem());
        assertNotNull(robot.getPosition());
        assertEquals(2, robot.getEnergy());
        assertEquals(2, robot.getStrength());
    }

    @Test
    void constructorCanThrowExceptions() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Robot("Robot", "T", null, 5, -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Robot("Robot", "T", null, 0, 2);
        });
    }

    @Test
    void setEnergyCanAssignEnergyVariable() {
        robot.setEnergy(4);
        assertEquals(4, robot.getEnergy());
    }

    @Test
    void setEnergyCanThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            robot.setEnergy(0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            robot.setEnergy(-1);
        });
    }

    @Test
    void setStrengthCanAssignStrengthVariable() {
        robot.setStrength(4);
        assertEquals(4, robot.getStrength());
    }

    @Test
    void setStrengthCanThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            robot.setStrength(-2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            robot.setStrength(-1);
        });

    }
}
