package ru.rrusanov;
/** Class contains cell of chess board.
 * @author Roman Rusanov
 * @since 13.11.2017
 * @version 0.1
 */
public class Cell {
    /**
     * Maximum value cells on board.
     */
    private static final int EIGHT = 8;
    /**
     * Minimum value cells on board.
     */
    private static final int ONE = 1;
    /**
     * Constructor for cell.
     * @param x horizontal cells.
     * @param y vertical cells.
     * @throws ImpossibleCreateCellException Possibly wrong value x,y for create cell.
     */
    Cell(int x, int y) throws ImpossibleCreateCellException {
        if (x >= ONE && x <= EIGHT && y >= ONE && y <= EIGHT) {
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
     * @return x coordinate.
     */
    int getX() {
        return this.x;
    }
    /**
     * getter for y coordinate.
     * @return y coordinate.
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
     * @param otherObject compare the object.
     * @return true if cells have same position on board.
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        Cell other = (Cell) otherObject;
        return this.x == other.x && this.y == other.y;
    }
    /**
     * hashcode() method.
     * @return int value of hashcode cell (x + y).
     */
    public int hashCode() {
        int result = 1;
        result *= this.x;
        result *= this.y;
        return result;
    }
}
