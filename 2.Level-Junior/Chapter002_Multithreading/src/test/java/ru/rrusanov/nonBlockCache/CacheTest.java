package ru.rrusanov.nonBlockCache;
import org.junit.Before;
import org.junit.Test;
import java.util.concurrent.atomic.AtomicReference;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertFalse;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 08.09.2018
 *
 * The class test Cache.java class.
 */
public class CacheTest {
    /**
     * The field contain tested instance.
     */
    private Cache cache = new Cache();
    /**
     * The field contain instance that be added to cache.
     */
    private Base model1 = new Base("Ivan");
    /**
     * The method executes before each test.
     */
    @Before
    public void setUp() {
        this.cache.add(model1);
    }
    /**
     * Test add().
     */
    @Test
    public void whenModelAddThenItExistInCollection() {
        assertThat(model1.getId(), is(this.cache.get(model1.getId()).getId()));
    }
    /**
     * Test update().
     * @throws InterruptedException may throw join().
     */
    @Test
    public void whenUpdateBySecondThreadThenThrowException() throws InterruptedException {
        /*
          The field contain container for handled exception.
         */
        AtomicReference<Exception> exception = new AtomicReference<>();
        /*
          Thread first.
         */
        Thread thread1 = new Thread(
            () -> {
                Base modelToUpdate = new Base("Fedor");
                modelToUpdate.setId(this.model1.getId());
                this.cache.update(modelToUpdate);
            }
        );
        /*
          Thread second.
         */
        Thread thread2 = new Thread(
            () -> {
                Base modelToUpdate = new Base("Nikolay");
                modelToUpdate.setId(this.model1.getId());
                try {
                    this.cache.update(modelToUpdate);
                } catch (OptimisticException e) {
                    exception.set(e);
                }
            }
        );
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        assertThat(exception.get().getMessage(), is("Data all ready updated!"));
    }
    /**
     * Test delete().
     */
    @Test
    public void whenModelDeleteThenItNotPresentInCollection() {
        Base modelToDelete = model1;
        this.cache.delete(modelToDelete);
        assertFalse(this.cache.contains(modelToDelete));
    }
}