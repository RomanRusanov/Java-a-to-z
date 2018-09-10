package ru.rrusanov.threads.pingPong;
import javafx.scene.shape.Rectangle;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 06.08.2018
 *
 * This class describes the rectangle move.
 */
public class RectangleMove implements Runnable {
    /**
     * The field contain instance of rectangle.
     */
    private final Rectangle rect;
    /**
     * The default constructor.
     *
     * @param rect rectangle to be moved.
     */
    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }
    /**
     * The method implements run method inherit from interface Runnable.
     */
    @Override
    public void run() {
        // direction init.
        MoveDownAndLeft moveDownAndLeft = new MoveDownAndLeft();
        MoveDownAndRight moveDownAndRight = new MoveDownAndRight();
        MoveUpAndLeft moveUpAndLeft = new MoveUpAndLeft();
        MoveUpAndRight moveUpAndRight = new MoveUpAndRight();
        /*
          The field contain direction to move.
         */
        Direction direction = new MoveToRight();
        // rectangle moved.
        do {
            direction.move(this.rect);
            if (this.rect.getX() > 290) {
                direction = moveUpAndLeft;
            }
            if (this.rect.getY() < 0) {
                direction = moveDownAndLeft;
            }
            if (this.rect.getX() < 0) {
                direction = moveDownAndRight;
            }
            if (this.rect.getY() > 290) {
                direction = moveUpAndRight;
            }
        } while (!Thread.interrupted());
    }
}
