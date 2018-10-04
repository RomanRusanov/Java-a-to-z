package ru.rrusanov.bomberman;

public class Cell {
    /**
     * x - horizontal cells.
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
     * Override toString() method.
     * @return String with coordinates of this cell.
     */
    @Override
    public String toString() {
        return "Cell{x=" + this.x + ", y=" + this.y + '}';
    }
    /**
     * Override equals() method.
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
        return 13 * (this.x + this.y);
    }


}
