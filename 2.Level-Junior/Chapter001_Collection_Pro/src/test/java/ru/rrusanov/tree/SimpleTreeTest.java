package ru.rrusanov.tree;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 05.07.2018
 *
 *  The class SimpleTreeTest.java test class: Node.java, Tree.java.
 */
public class SimpleTreeTest {
    /**
     * The field contain instance of tested class.
     */
    private Tree<Integer> tree = new Tree<>(new Node<>(1));
    /**
     * The method call before each test run.
     */
    @Before
    public void before() {
        this.tree.add(1, 2);
        this.tree.add(1, 3);
        this.tree.add(1, 4);
        this.tree.add(4, 5);
        this.tree.add(5, 6);
    }
    /**
     * The test check add method.
     */
    @Test
    public void whenAddNodeThenItExistInTree() {
        this.tree.add(4, 7);
        assertThat(this.tree.findBy(7), is(Optional.of(new Node<>(7))));
    }
    /**
     * The test check equals behavior.
     */
    @Test
    public void whenSameStructureOfNodesThenTheyEquals() {
        Tree<Integer> treeSecond = new Tree<>(new Node<>(1));
        treeSecond.add(1, 2);
        treeSecond.add(1, 3);
        treeSecond.add(1, 4);
        treeSecond.add(4, 5);
        treeSecond.add(5, 6);
        assertEquals(this.tree.findBy(1), treeSecond.findBy(1));
    }
    /**
     * The test check hashCode behavior.
     */
    @Test
    public void whenNodeDateEqualsThenHashCodeEquals() {
        assertEquals(new Node<>(1).hashCode(), new Node<>(1).hashCode());
        assertNotEquals(new Node<>(2).hashCode(), new Node<>(1).hashCode());
        assertNotEquals(this.tree.findBy(1).hashCode(), new Node<>(1).hashCode());
    }
    /**
     * The test iterator behavior.
     * The behavior fastFail not implemented because iterator instance immutable.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenIteratorCreateNextReturnElementIfNoMoreElementsThrowException() {
        Iterator<Integer> iterator = this.tree.iterator();
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(6));
        assertFalse(iterator.hasNext());
        iterator.next();
    }
    /**
     * The test check findBy method and collection behavior.
     */
    @Test
    public void when6ElFindLastThen6AndWhen6ElFindNotExitThenOptionEmpty() {
        assertThat(
                this.tree.findBy(6).isPresent(),
                is(true)
        );
        assertThat(
                this.tree.findBy(7).isPresent(),
                is(false)
        );
    }
}