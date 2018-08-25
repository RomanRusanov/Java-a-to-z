package ru.rrusanov.threads.dynamicListBasedArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 07.06.2018
 *
 * Test DynamicList.java.
 */
public class DynamicListTest {
    /**
     * The field contain instance of tested class.
     */
    private DynamicList<Integer> dynamicList = new DynamicList<>();
    /**
     * Section execute before each tests.
     */
    @Before
    public void before() {
        this.dynamicList.add(1);
        this.dynamicList.add(2);
        this.dynamicList.add(3);
    }
    /**
     * Test add and get methods.
     */
    @Test
    public void whenAddElementsThenReturnThem() {
        Assert.assertThat(this.dynamicList.get(0), is(1));
        Assert.assertThat(this.dynamicList.get(1), is(2));
        Assert.assertThat(this.dynamicList.get(2), is(3));
    }
    /**
     * Test Iterator.
     */
    @Test
    public void whenIteratorCreateWhenNextReturnElementsSequentially() {
        Iterator<Integer> iterator = this.dynamicList.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThat(iterator.next(), is(1));
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThat(iterator.next(), is(2));
        Assert.assertThat(iterator.next(), is(3));
        Assert.assertFalse(iterator.hasNext());
    }
    /**
     * Test fail-fast behavior.
     */
    @Test (expected = ConcurrentModificationException.class)
    public void whenCollectionChangedThenTrowException() {
        Iterator<Integer> iterator = this.dynamicList.iterator();
        this.dynamicList.add(4);
        iterator.hasNext();
    }
    /**
     * Test concurrency iterator.
     */
    @Test
    public void whenOneThreadGetNextElementThenSecondThreadGetNextElement() {
        /**
         * The field contain instance of iterator for test.
         */
        Iterator<Integer> iterator = this.dynamicList.iterator();
        /**
         * The inner class thread1, implements concurrency behavior.
         */
        class DynamicList1 extends Thread {
            @Override
            public void run() {
                Assert.assertEquals(iterator.next(), new Integer(1));
            }
        }
        /**
         * The inner class thread2, implements concurrency behavior.
         */
        class DynamicList2 extends Thread {
            @Override
            public void run() {
                Assert.assertEquals(iterator.next(), new Integer(2));
            }
        }
        Thread thread1 = new Thread(new DynamicList1());
        Thread thread2 = new Thread(new DynamicList2());
        thread1.start();
        thread2.start();
    }
    /**
     * Test concurrency add and get.
     * @throws InterruptedException method join may throw.
     */
    @Test
    public void whenOneThreadAddElementsThenSecondThreadAddElements() throws InterruptedException {
        /**
         * The inner class thread1, implements concurrency behavior.
         */
        class DynamicList1 extends Thread {
            @Override
            public void run() {
                dynamicList.add(5);
                dynamicList.add(6);
                dynamicList.add(7);
                dynamicList.add(8);
            }
        }
        /**
         * The inner class thread2, implements concurrency behavior.
         */
        class DynamicList2 extends Thread {
            @Override
            public void run() {
                dynamicList.add(9);
                dynamicList.add(10);
                dynamicList.add(11);
                dynamicList.add(12);
            }
        }
        Thread thread1 = new Thread(new DynamicList1());
        Thread thread2 = new Thread(new DynamicList2());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        for (int i = 0; i < 8; i++) { // 8 - number added elements in collection.
            Assert.assertThat(this.dynamicList.get(i + 3), is(i + 5));
        }
    }
}