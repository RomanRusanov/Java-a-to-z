package threadswitcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 22.10.2020
 * email roman9628@gmail.com
 * Реализовать класс Switcher. Нить А печатает первой,
 * нить В всегда второй. Нити работают вечно.
 */
public class Switcher {
    /**
     * The instance with logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(Switcher.class.getName());
    /**
     * The field contain barrier instance, what switch two thread sequence.
     */
    private static final MasterSlaveBarrier BARRIER = new MasterSlaveBarrier(true);

    /**
     * The main method.
     * @param args Passed args.
     * @throws InterruptedException exception.
     */
    public static void main(String[] args) throws InterruptedException {
        Thread first = new Thread(
                () -> {
                    while (true) {
                        BARRIER.tryMaster();
                        System.out.println("Thread A");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        BARRIER.doneMaster();
                    }
                }
        );
        Thread second = new Thread(
                () -> {
                    while (true) {
                        BARRIER.trySlave();
                        System.out.println("Thread B");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        BARRIER.doneSlave();
                    }
                }
        );
        first.start();
        second.start();
        first.join();
        second.join();
    }
}