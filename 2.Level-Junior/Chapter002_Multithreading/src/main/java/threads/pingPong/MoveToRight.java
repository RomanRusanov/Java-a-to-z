package threads.pingPong;

import java.awt.Rectangle;

public class MoveToRight implements Direction {
    @Override
    public void moveTo(Rectangle rect) {
        rect(rect.getX() + 1);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
