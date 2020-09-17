package threadstart;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.09.2020
 * email roman9628@gmail.com
 * The class demonstrate that two threads start in random priority.
 */
public class ConcurrentOutput {
    /**
     * Main method.
     * @param args passed params.
     */
    public static void main(String[] args) {
        Thread another = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        Thread second = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        another.start();
        second.start();
        System.out.println(Thread.currentThread().getName());

    }
}