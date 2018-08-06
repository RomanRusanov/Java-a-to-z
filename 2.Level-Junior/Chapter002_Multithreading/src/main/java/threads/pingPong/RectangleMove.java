package threads.pingPong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {

    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        while(true) {
            // move to right;
            while (this.rect.getX() < 280) {
                this.rect.setX(this.rect.getX() + 1);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // move to up and left;
            while (this.rect.getY() > 10) {
                this.rect.setX(this.rect.getX() - 1.7);
                this.rect.setY(this.rect.getY() - 1.5);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // move to down and left;
            while (this.rect.getX() > 10) {
                this.rect.setX(this.rect.getX() - 1.5);
                this.rect.setY(this.rect.getY() + 1.7);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // move to down and right
            while (this.rect.getY() < 280) {
                this.rect.setX(this.rect.getX() + 1.4);
                this.rect.setY(this.rect.getY() + 1.1);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // move to up and right
            while (this.rect.getX() < 280) {
                this.rect.setX(this.rect.getX() + 1.5);
                this.rect.setY(this.rect.getY() - 1.5);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
