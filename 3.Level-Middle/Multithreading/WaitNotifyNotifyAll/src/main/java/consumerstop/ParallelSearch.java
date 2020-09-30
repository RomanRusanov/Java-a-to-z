package consumerstop;

import patternproducerconsumer.SimpleBlockingQueue;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 30.09.2020
 * email roman9628@gmail.com
 * The class describe how interrupt one thread from in another.
 * Producer thread(anonymous class) when stop add elements to queue,
 * call on consumer thread interrupt, and generate exception in method wait in
 * pool method, and consumer check if it interrupted when cycle break.
 */
public class ParallelSearch {
    /**
     * The main method.
     * @param args Passed args.
     */
    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        final Thread consumer = new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        try {
                            System.out.println(queue.poll());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        consumer.start();
        new Thread(
                () -> {
                    for (int index = 0; index != 3; index++) {
                        queue.offer(index);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    consumer.interrupt();
                }

        ).start();
    }
}