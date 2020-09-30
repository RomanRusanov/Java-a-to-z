package controlthreadwait;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 30.09.2020
 * email roman9628@gmail.com
 * The class describe wait method.
 */
public class ThreadsWithBarrier {
    /**
     * The main method. When count equals 5 then barrier unlock.
     * @param args Passed args.
     */
    public static void main(String[] args) {
        CountBarrier countBarrier = new CountBarrier(5);

        Thread thread1 = new Thread(() -> {
            countBarrier.await();
            System.out.println("await end");
        }, "Thread 1");

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                countBarrier.count();
                System.out.println(Thread.currentThread().getName()
                        + " " + Thread.currentThread().getState()
                        + " Iteration = " + i);
            }
        }, "Thread 2");
        thread1.start();
        thread2.start();
        System.out.println(Thread.currentThread().getName() + "Main complete");
    }
}