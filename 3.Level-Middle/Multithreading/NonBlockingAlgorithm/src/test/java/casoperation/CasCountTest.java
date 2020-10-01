package casoperation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The class check behavior CasCount.java.
 */
class CasCountTest {
    /**
     * The test check increment.
     * @throws InterruptedException join method may throw.
     */
    @Test
    void when2ThreadsWorkParallelWhenCounterEqualsIterations() throws InterruptedException {
        final CasCount counter = new CasCount();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
            }
        }, "thread1");
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
            }
        }, "thread2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertEquals(20, counter.get());
    }
}