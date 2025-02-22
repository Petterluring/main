package com.position;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * This test class include the abstract class
 * Position.java
 */
public class StaticPositionTest {
    private Position position = new StaticPosition(0, 0);

    @Test
    void constructorCanAssignVariables() {
        assertEquals(0, position.getColumn());
        assertEquals(0, position.getRow());
    }

    @Test
    void constructorCanThrowExceptions() {
        assertThrows(IllegalArgumentException.class, () -> {
            new StaticPosition(1, -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new StaticPosition(-1, 1);
        });
    }
}
