package ru.rrusanov;
/** Class contains cell of chess board.
 * @author Roman Rusanov
 * @since 13.11.2017
 * @version 0.1
 */
public class Cell {
    /**
     * Constructor for cell.
     */
    Cell(int x, int y) throws ImpossibleCreateCellException {
        if ( x >= 1 && x <= 8 && y >= 1 && y <= 8 ) {
            this.x = x;
            this.y = y;
        } else {
            throw new ImpossibleCreateCellException("Wrong coordinate cell!");
        }
    }
    /**
     * x - horizontall cells.
     */
    private int x;
    /**
     * y - vertical cells.
     */
    private int y;
    /**
     * getter for x coordinate.
     */
    int getX() {
        return this.x;
    }
    /**
     * getter for y coordinate.
     */
    int getY() {
        return this.y;
    }
}
