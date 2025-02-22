package com.agents;

import com.position.Position;

/**
 * The player of robot_game plays as the robot. The Robot class is responsible
 * for keeping track of the robots energy, strenght, position and more. It can also move 
 * up, down, left and right on the board.
 */
public class Robot extends Agent {
    private int energy;
    private int strength;
    private final static String ENERGYERROR = "Energy must exceed 0";
    private final static String STRENGHTERROR = "Strenght must exceed 0";

    public Robot(String name, String emblem, Position position, int energy, int strength) throws IllegalArgumentException {
        super(name, emblem, position);
        if (energy <= 0) {
            throw new IllegalArgumentException(ENERGYERROR);
        }
        if (strength < 0) {
            throw new IllegalArgumentException(STRENGHTERROR);
        }
        this.energy = energy;
        this.strength = strength;
    }

    /**
     * Returns the row above the current row position of Robot.
     * The user should set the new position. 
     * @return - int type
     */
    public int moveUp() {
        return position.getRow() + 1;
    }

    /**
     * Returns the row below the current row position of Robot.
     * The user should set the new position. 
     * @return - int type
     */
    public int moveDown() {
        return position.getRow() - 1;
    }

    /**
     * Returns the column to the right of the current column position of Robot.
     * The user should set the new position. 
     * @return - int type
     */
    public int moveRight() {
        return position.getColumn() + 1;
    }

    /**
     * Returns the column to the left of the current row position of Robot.
     * The user should set the new position. 
     * @return - int type
     */
    public int moveLeft() {
        return position.getColumn() - 1;
    }


    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) throws IllegalArgumentException {
        if (energy <= 0) {
            throw new IllegalArgumentException(ENERGYERROR);
        }
        this.energy = energy;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) throws IllegalArgumentException {
        if (strength < 0) {
            throw new IllegalArgumentException(STRENGHTERROR);
        }
        this.strength = strength;
    }
}
