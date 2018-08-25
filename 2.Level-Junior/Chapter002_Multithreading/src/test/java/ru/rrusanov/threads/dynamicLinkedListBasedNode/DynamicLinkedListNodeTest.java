package ru.rrusanov.threads.dynamicLinkedListBasedNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 10.06.2018
 *
 * Test DynamicLinkedListNode.java.
 */
public class DynamicLinkedListNodeTest {
    /**
     * The field contain instance of tested class.
     */
    private DynamicLinkedListNode<Integer> dynamicLinkedListNode = new DynamicLinkedListNode();
    /**
     * Section execute before each tests.
     */
    @Before
    public void setUp() {
        this.dynamicLinkedListNode.add(1);
        this.dynamicLinkedListNode.add(2);
        this.dynamicLinkedListNode.add(3);
        this.dynamicLinkedListNode.add(4);
    }
    /**
     * Test add and get methods.
     */
    @Test
    public void whenAddElementsThenReturnThem() {
        Assert.assertThat(this.dynamicLinkedListNode.get(1), is(1));
        Assert.assertThat(this.dynamicLinkedListNode.get(4), is(4));
    }
    /**
     * Test Iterator.
     */
    @Test
    public void whenIteratorCreateWhenNextReturnElementsSequentially() {
        Iterator<Integer> iterator = this.dynamicLinkedListNode.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThat(iterator.next(), is(1));
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThat(iterator.next(), is(2));
        Assert.assertThat(iterator.next(), is(3));
        Assert.assertThat(iterator.next(), is(4));
        Assert.assertFalse(iterator.hasNext());
    }
    /**
     * Test fail-fast behavior.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenCollectionChangedThenTrowException() {
        Iterator<Integer> iterator = this.dynamicLinkedListNode.iterator();
        this.dynamicLinkedListNode.add(5);
        iterator.hasNext();
    }
    /**
     * Test the method getSize().
     */
    @Test
    public void whenCallThenReturnCollectionSize() {
        Assert.assertThat(this.dynamicLinkedListNode.getSize(), is(4));
    }
    /**
     * Test concurrency iterator.
     */
    @Test
    public void whenOneThreadGetNextElementThenSecondThreadGetNextElement() {
        /**
         * The field contain instance of iterator for test.
         */
        Iterator<Integer> iterator = this.dynamicLinkedListNode.iterator();
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
        class DynamicLinkedList1 extends Thread {
            @Override
            public void run() {
                dynamicLinkedListNode.add(5);
                dynamicLinkedListNode.add(6);
                dynamicLinkedListNode.add(7);
                dynamicLinkedListNode.add(8);
            }
        }
        /**
         * The inner class thread2, implements concurrency behavior.
         */
        class DynamicLinkedList2 extends Thread {
            @Override
            public void run() {
                dynamicLinkedListNode.add(9);
                dynamicLinkedListNode.add(10);
                dynamicLinkedListNode.add(11);
                dynamicLinkedListNode.add(12);
            }
        }
        Thread thread1 = new Thread(new DynamicLinkedList1());
        Thread thread2 = new Thread(new DynamicLinkedList2());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        for (int i = 0; i < 8; i++) { // 8 - number added elements in collection.
            Assert.assertThat(this.dynamicLinkedListNode.get(i + 5), is(i + 5));
        }
    }
}