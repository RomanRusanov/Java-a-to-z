package ru.rrusanov.waitNotifyNotifyAll.parallelSearch;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 30.08.2018
 *
 *  The class describe two threads(producer and consumer) when producer stop, then consumer thread terminate.
 */
public class ParallelSearch {
    /**
     * Main method.
     * @param args params for program.
     */
    public static void main(String[] args) {
        /*
          The field contain collection(queue) two threads work together.
         */
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        /*
          The consumer thread.
         */
        final Thread consumer = new Thread(
            () -> {
                while (!queue.getProducerStop()) {
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
        /*
          The producer thread.
         */
        new Thread(
            () -> {
                for (int index = 0; index != 3; index++) {
                    try {
                        queue.offer(index);
                        if (index == 2) {
                            queue.setProducerStop(true);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        ).start();
    }
}
