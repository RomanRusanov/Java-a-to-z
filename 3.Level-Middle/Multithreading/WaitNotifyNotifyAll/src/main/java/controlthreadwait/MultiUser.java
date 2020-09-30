package controlthreadwait;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 29.09.2020
 * email roman9628@gmail.com
 * The class demonstrate the slave thread start only after master thread start.
 */
public class MultiUser {
    /**
     * The main method.
     * @param args Passed params.
     */
    public static void main(String[] args) {
        Barrier barrier = new Barrier();
        Thread master = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " started");
                    barrier.on();
                },
                "Master"
        );
        Thread slave = new Thread(
                () -> {
                    barrier.check();
                    System.out.println(Thread.currentThread().getName() + " started");
                },
                "Slave"
        );

        slave.start();
        master.start();
    }
}