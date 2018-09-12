package ru.rrusanov.threads.dynamicListBasedArrayVer2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.rrusanov.collection.dynamicListBasedArray.DynamicList;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 12.09.2018
 *
 * The test check DynamicSyncList.java class behavior.
 */
public class DynamicSyncListTest {
    /**
     * The field contain not synchronized list.
     */
    private DynamicList<Integer> nonSyncList = new DynamicList<>();
    /**
     * The field contain wrapped non synchronized list, in to synchronized collection.
     */
    private DynamicSyncList<Integer> list = new DynamicSyncList<>(nonSyncList);
    /**
     * The method execute before each test.
     */
    @Before
    public void setUp() {
        this.nonSyncList.add(1);
        this.nonSyncList.add(2);
        this.nonSyncList.add(3);
    }
    /**
     *  The test iterator.
     * @throws InterruptedException may throw join.
     */
    @Test
    public void whenIteratorCreatedAfterMutateCollectionThenNoThrowModificationConcurrentException() throws InterruptedException {
        Thread thread1 = new Thread(
                () -> {
                    Iterator<Integer> iterator = this.list.iterator();
                    this.list.add(4);
                    Assert.assertThat(1, is(iterator.next()));
                    Assert.assertThat(2, is(iterator.next()));
                    Assert.assertThat(3, is(iterator.next()));
                    Assert.assertFalse(iterator.hasNext());
                }
        );
        thread1.start();
        thread1.join();
        Thread thread2 = new Thread(
                () -> {
                    Iterator<Integer> iterator = this.list.iterator();
                    this.list.add(5);
                    Assert.assertThat(1, is(iterator.next()));
                    Assert.assertThat(2, is(iterator.next()));
                    Assert.assertThat(3, is(iterator.next()));
                    Assert.assertThat(4, is(iterator.next()));
                    Assert.assertFalse(iterator.hasNext());
                }
        );
        thread2.start();
        thread2.join();
    }
}