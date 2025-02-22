package com.agents;

import com.position.DynamicPosition;

public class Strength extends Agent {
    private int strengthAmount;
    private static final String STRENGTHAMOUNTERROR = "The amount of strength must at least be 0";

    public Strength(String name, String emblem, DynamicPosition position, int strengthAmount)
            throws IllegalArgumentException {
        super(name, emblem, position);
        if (strengthAmount < 0) {
            throw new IllegalArgumentException(STRENGTHAMOUNTERROR);
        }
        this.strengthAmount = strengthAmount;
    }

    public void setStrengthAmount(int strengthAmount) {
        if (strengthAmount < 0) {
            throw new IllegalArgumentException(STRENGTHAMOUNTERROR);
        }
        this.strengthAmount = strengthAmount;
    }

    public int getStrengthAmount() {
        return strengthAmount;
    }
}
