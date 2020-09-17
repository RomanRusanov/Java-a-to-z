package threadstate;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.09.2020
 * email roman9628@gmail.com
 * The class .
 */
public class ThreadState {
    public static void main(String[] args) {
        Thread first = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName());
                }
        );
        Thread second = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName());
                }
        );
        first.start();
        second.start();
        while (
                first.getState() != Thread.State.TERMINATED
                && second.getState() != Thread.State.TERMINATED
        ) {
            System.out.println(Thread.currentThread().getName()
                    + Thread.currentThread().getState());
        }
        System.out.println("Thread (first, second) TERMINATED");
        System.out.println(first.getName() + first.getState());
        System.out.println(second.getName() + second.getState());
    }
}