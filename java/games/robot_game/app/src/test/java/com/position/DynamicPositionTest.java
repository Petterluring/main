package com.position;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DynamicPositionTest {
    private final DynamicPosition position = new DynamicPosition(0, 0);

    // Constructor is tested in StaticPositionTest.java

    @Test
    void setRowCanAssignRow() {
        position.setRow(1);
        assertEquals(1, position.getRow());
    }

    @Test
    void setRowCanThrowException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            position.setRow(-1);
        });
    }

    @Test
    void setColumnCanAssignColumn() {
        position.setColumn(1);
        assertEquals(1, position.getColumn());
    }

    @Test
    void setColumnCanThrowException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            position.setColumn(-1);
        });
    }

    @Test
    void canGenerateRandomPosition() {
        for (int i = 0; i <= 10_000; i++) {
            int[] index = DynamicPosition.generateRandomIndex(10, 10);
            assertTrue(index[0] >= 0 && index[0] <= 10);
            assertTrue(index[1] >= 0 && index[1] <= 10);
        }
    }

    @Test
    void generateRandomIndexCanThrowException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            DynamicPosition.generateRandomIndex(1, -1);
        });
        assertThrows(IllegalArgumentException.class, ()-> {
            DynamicPosition.generateRandomIndex(-1, 1);
        });
    }
}
