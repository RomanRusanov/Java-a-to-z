package ru.rrusanov.bomberman;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 4.10.2018
 *
 * The class describe cell implementation.
 */
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
     * Constructor take two int coordinate for position new cell.
     * @param x coordinate.
     * @param y coordinate.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Constructor take cell value for position new cell.
     * @param position Cell
     */
    public Cell(Cell position) {
        this.x = position.x;
        this.y = position.y;
    }
    /**
     * The method setter field.
     * @param x coordinate value.
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * The method setter field.
     * @param y coordinate value.
     */
    public void setY(int y) {
        this.y = y;
    }
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
