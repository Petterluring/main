package com.agents;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.position.DynamicPosition;

public class StrengthTest {
    private final Strength strength = new Strength(
        "Test",
        "T",
        new DynamicPosition(0, 0),
        5);
    
    @Test
    void constructorCanAssignVariables() {
        assertEquals(5, strength.getStrengthAmount());
    }

    @Test
    void constructorCanThrowExceptions() {
        assertThrows(IllegalArgumentException.class, ()-> {
            new Strength(null, null, null, -1);
        });
    }

    @Test
    void setStrengthAmountCanSetStrengthAmount() {
        strength.setStrengthAmount(3);
        assertEquals(3, strength.getStrengthAmount());
    }

    @Test
    void setStrengthCanThrowExceptions() {
        assertThrows(IllegalArgumentException.class, ()-> {
            strength.setStrengthAmount(-1);
        });
    }
}

