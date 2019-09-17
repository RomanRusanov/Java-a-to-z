package ru.rrusanov.seaBattle;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 17/09/2019
 * The class .
 */
public class Up implements Directions {

    @Override
    public Point nextPoint(Point start) {
        return new Point(start.getX(), start.getY() + 1);
    }
}
