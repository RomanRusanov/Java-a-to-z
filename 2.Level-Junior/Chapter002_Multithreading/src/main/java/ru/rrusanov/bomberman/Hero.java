package ru.rrusanov.bomberman;

public class Hero {

    private Cell position;

    private int direction = 0;

    public Hero(Cell position) {
        this.position = position;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }

    public Cell getPosition() {
        return position;
    }

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

    public void applyChangeDirection() {
        // move to right side.
        if (this.direction == 3) {
            this.direction = 0;
        } else {
            this.direction++;
        }
    }
}
