package interruptblockedthread;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.09.2020
 * email roman9628@gmail.com
 * The class demonstrate if we call sleep or wait method, we must call
 * Thread.currentThread().interrupt() in catch section.
 */
public class ThreadStop {
    /**
     * The main method.
     * @param args Passed args.
     * @throws InterruptedException sleep may throw.
     */
    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        try {
                            System.out.println("start ...");
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        progress.start();
        Thread.sleep(1000);
        progress.interrupt();
        progress.join();
    }
}