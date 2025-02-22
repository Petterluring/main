package com.position;

/**
 * This class manages the board position of an agent. 
 * This includes keeping track of position, changing position and more.
 */
public abstract class Position {
    
    /**
     * A row and a column specifies a position, 
     * or index, on the board
     */
    protected int row;
    protected int column;

    protected static final String ROWBOUNDARYERROR = "Row must exceed 0";
    protected static final String COLUMNBOUNDARYERROR = "Column must exceed 0";


    public Position(int row, int column) throws IllegalArgumentException {
        if (row < 0) {
            throw new IllegalArgumentException(ROWBOUNDARYERROR);
        }
        if (column < 0) {
            throw new IllegalArgumentException(COLUMNBOUNDARYERROR);
        }
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
