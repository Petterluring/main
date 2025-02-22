package com.agents;

import com.position.Position;

/**
 * Base class for the different agents on the board.
 */
public abstract class Agent {
    protected Position position;
    protected String name;
    protected String emblem;

    public Agent(String name, String emblem, Position position) {
        this.name = name;
        this.emblem = emblem;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getEmblem() {
        return emblem;
    }
}
