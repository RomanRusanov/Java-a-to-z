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
     * The field contain flag that break infinite cycle.
     */
    private boolean interrupted;
    /**
     * The field contain direction to move.
     */
    private Direction direction;
    /**
     * The default constructor.
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
        this.direction = new MoveToRight();
        // rectangle moved.
        while (true) {
            this.direction.move(this.rect);
            if (this.rect.getX() > 290) {
                this.direction = moveUpAndLeft;
            }
            if (this.rect.getY() < 0) {
                this.direction = moveDownAndLeft;
            }
            if (this.rect.getX() < 0) {
                this.direction = moveDownAndRight;
            }
            if (this.rect.getY() > 290) {
                this.direction = moveUpAndRight;
            }
            if (this.interrupted) {
                break;
            }
        }
    }
    /**
     * The method set field value.
     * @param interrupted boolean value. If thread was interrupted then true. Otherwise false.
     */
    public void setInterrupted(boolean interrupted) {
        this.interrupted = interrupted;
    }
}
