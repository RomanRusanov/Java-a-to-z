package ru.rrusanov.threads.pingPong;
import javafx.scene.shape.Rectangle;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 06.08.2018
 *
 * This class describes the move to down and right rectangle.
 */
public class MoveDownAndRight implements Direction {
    /**
     * The method describe direction in with rectangle need move.
     * @param rect the instance to move.
     */
    @Override
    public void move(Rectangle rect) {
        rect.setX(rect.getX() + 1.6);
        rect.setY(rect.getY() + 1.2);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
