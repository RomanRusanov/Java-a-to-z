package nonblockingcache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The class check behavior NonBlockingCache.java.
 */
class NonBlockingCacheTest {
    /**
     * The field contain instance of test class.
     */
    private NonBlockingCache cache;
    /**
     * The field contain instance base model.
     */
    private Base base1;
    /**
     * The field contain instance base model.
     */
    private Base base2;
    /**
     * The field contain instance base model.
     */
    private Base base3;
    /**
     * The field contain instance base model.
     */
    private Base base4;

    /**
     * The method execute before each test.
     */
    @BeforeEach
    void setup() {
        cache = new NonBlockingCache();
        base1 = new Base(1, 1, "base1");
        base2 = new Base(2, 1, "base2");
        base3 = new Base(1, 1, "base3");
        base4 = new Base(1, 2, "base4");
    }

    /**
     * The test check when add model with different id then they present in cache.
     * @throws InterruptedException Method join may throw.
     */
    @Test
    void whenAdd2ModelThenTheyPresentICache() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            cache.add(base1);
        }, "thread 1");
        Thread thread2 = new Thread(() -> {
            cache.add(base2);
        }, "thread 2");
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        assertTrue(cache.isContain(base1));
        assertTrue(cache.isContain(base2));
    }

    /**
     * The test check if try update model with equals id and version different
     * (current stored +1) then update in cache.
     *
     * @throws InterruptedException Method join may throw.
     */
    @Test
    void whenIdEqualsAndVersionDifferent1PlusThenUpdateIt() throws InterruptedException {
        cache.add(base1);
        Thread thread1 = new Thread(() -> {
            cache.update(base4);
        }, "thread 1");
        thread1.start();
        thread1.join();
        assertTrue(cache.isContain(base4));
        assertFalse(cache.isContain(base1));
    }

    /**
     * The test check if try update model with equals id and version different
     * not (current stored +1) then throw exception.
     * @throws InterruptedException Method join may throw.
     */
    @Test
    void whenIdEqualsAndVersionDifferentNot1PlusThrowException() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            cache.add(base1);
        }, "thread 1");
        thread1.start();
        thread1.join();
        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread thread = new Thread(
                () -> {
                    try {
                        cache.update(base3);
                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );
        thread.start();
        thread.join();
        assertTrue(cache.isContain(base1));
        assertFalse(cache.isContain(base3));
        assertEquals("Version model passed different from expect,"
                + " possible data corruption!", ex.get().getMessage()
        );
    }

    /**
     * The test check if model remove from cache, then this model not present.
     */
    @Test
    void whenModelRemovedThenItNotExistInCache() {
        cache.add(base1);
        cache.add(base2);
        cache.delete(base2);
        assertTrue(cache.isContain(base1));
        assertFalse(cache.isContain(base2));
    }
}