package com.agents;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.position.DynamicPosition;

public class EnergyTest {
    private final Energy energy = new Energy(
        "Energy",
        "T",
        new DynamicPosition(0, 0),
        5);
    
    @Test
    void constructorCanAssignVariables() {
        assertEquals(5, energy.getEnergyAmount());
    }

    @Test
    void constructorCanThrowExceptions() {
        assertThrows(IllegalArgumentException.class, ()-> {
            new Energy(null, null, null, 0);
        });
    }

    @Test
    void setEnergyAmountCanSetEnergyAmount() {
        energy.setEnergyAmount(3);
        assertEquals(3, energy.getEnergyAmount());
    }

    @Test
    void setEnergyCanThrowExceptions() {
        assertThrows(IllegalArgumentException.class, ()-> {
            energy.setEnergyAmount(0);
        });
        assertThrows(IllegalArgumentException.class, ()-> {
            energy.setEnergyAmount(-1);
        });
    }
}
