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

    /**
     * Overide toString() method.
     * @return String with coordinates of this cell.
     */
    @Override
    public String toString() {
        return "Cell{x=" + this.x + ", y=" + this.y + '}';
    }
    /**
     * Overide eqals() method.
     * @return true if cells have same position on board.
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || this.getClass() != otherObject.getClass()) return false;
        Cell other = (Cell) otherObject;
        if (this.x == other.x && this.y == other.y) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * hashcode() method.
     * @return int value of hashcode cell (x + y).
     */
    public int hashcode() {
        int result = 17;
        result *= getX();
        result *= getY();
        return result;
    }
}
