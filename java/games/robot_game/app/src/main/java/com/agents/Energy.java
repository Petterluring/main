package com.agents;

import com.position.DynamicPosition;

/**
 * The Energy class is used by Robot to increase its energy.
 */
public class Energy extends Agent {
    private int energyAmount;
    private static final String ENERGYAMOUNTERROR = "The amount of energy must exceed 0";

    public Energy(String name, String emblem, DynamicPosition position, int energyAmount)
            throws IllegalArgumentException {
        super(name, emblem, position);
        if (energyAmount <= 0) {
            throw new IllegalArgumentException(ENERGYAMOUNTERROR);
        }
        this.energyAmount = energyAmount;
    }

    public void setEnergyAmount(int energyAmount) {
        if (energyAmount <= 0) {
            throw new IllegalArgumentException(ENERGYAMOUNTERROR);
        }
        this.energyAmount = energyAmount;
    }

    public int getEnergyAmount() {
        return energyAmount;
    }

}
