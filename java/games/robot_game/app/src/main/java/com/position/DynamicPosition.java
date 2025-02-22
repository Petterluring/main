package com.position;

import java.util.Random;

/**
 * Extends Position.java by adding
 * functionality for changing position.
 */
public class DynamicPosition extends Position {
    private static Random randomGen = new Random();

    public DynamicPosition(int row, int column) {
        super(row, column);
    }

    public void setRow(int row) {
        if (row < 0) {
            throw new IllegalArgumentException(ROWBOUNDARYERROR);
        }
        this.row = row;
    }

    public void setColumn(int column) {
        if (column < 0) {
            throw new IllegalArgumentException(COLUMNBOUNDARYERROR);
        }
        this.column = column;
    }

    /**
     * Generates a random position
     * 
     * @param maxRow    - Maximum row that can be generated
     * @param maxColumn - Maximum column that can be generated
     * @return - Returns an int array containing the random row and column
     */
    public static int[] generateRandomIndex(int maxRow, int maxColumn) {
        if (maxRow < 0) {
            throw new IllegalArgumentException(ROWBOUNDARYERROR);
        }
        if (maxColumn < 0) {
            throw new IllegalArgumentException(COLUMNBOUNDARYERROR);
        }
        int row = randomGen.nextInt(maxRow + 1);
        int column = randomGen.nextInt(maxColumn + 1);
        return new int[] { row, column };
    }
}
