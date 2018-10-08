package ru.rrusanov.bomberman;
import java.util.Random;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 7.10.2018
 *
 * The class describe Hero behavior.
 */
public class Hero {
    /**
     * The filed instance contain position on board.
     */
    private Cell position;
    /**
     * The filed contain current direction to move
     */
    private int direction = 0;
    /**
     * The default constructor create hero on position.
     * @param position start position.
     */
    public Hero(Cell position) {
        this.position = position;
    }
    /**
     * The setter for position field.
     * @param position cell
     */
    public void setPosition(Cell position) {
        this.position = position;
    }
    /**
     * The getter method.
     * @return cell
     */
    public Cell getPosition() {
        return position;
    }
    /**
     * The getter method.
     * @return
     */
    public int getDirection() {
        return direction;
    }
    /**
     * The method implements move behavior.
     * @return next cell to go.
     */
    public Cell move() {
        Cell result = position;
        // move to right side.
        if (this.direction == 0) {
            if(result.getX() + 1 <= 9) {
                result.setX(result.getX() + 1);
            } else {
                this.applyChangeDirection();
            }
        }
        // move to down side.
        if (this.direction == 1) {
            if(result.getY() - 1 >= 0) {
                result.setY(result.getY() - 1);
            } else {
                this.applyChangeDirection();
            }
        }
        // move to left side.
        if (this.direction == 2) {
            if(result.getX() - 1 >= 0) {
                result.setX(result.getX() - 1);
            } else {
                this.applyChangeDirection();
            }
        }
        // move to top side.
        if (this.direction == 3) {
            if(result.getY() + 1 <= 9) {
                result.setY(result.getY() + 1);
            } else {
                this.applyChangeDirection();
            }
        }
        return result;
    }
    /**
     * The method change direction to new random side(0 - 3 possible direction).
     */
    public void applyChangeDirection() {
        this.direction = new Random().nextInt(4);
    }
}
