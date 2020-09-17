package threadstop;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.09.2020
 * email roman9628@gmail.com
 * The class demonstrate how stop thread execution.
 */
public class ThreadStop {
    /**
     * The main method.
     * @param args Passed args.
     * @throws InterruptedException sleep may throw.
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(
                () -> {
                    int count = 0;
                    while (!Thread.currentThread().isInterrupted()) {
                        System.out.println(count++);
                    }
                }
        );
        thread.start();
        Thread.sleep(1);
        thread.interrupt();
    }
}