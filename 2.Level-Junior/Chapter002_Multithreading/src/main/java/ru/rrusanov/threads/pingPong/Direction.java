package ru.rrusanov.threads.pingPong;
import javafx.scene.shape.Rectangle;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 06.08.2018
 *
 * This interface describes the direction move.
 */
public interface Direction {
    /**
     * The method describe direction in with rectangle need move.
     * @param rect the instance to move.
     */
    void move(Rectangle rect);
}
