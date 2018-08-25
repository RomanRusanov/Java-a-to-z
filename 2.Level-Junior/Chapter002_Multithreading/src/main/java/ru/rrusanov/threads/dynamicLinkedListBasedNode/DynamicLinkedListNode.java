package ru.rrusanov.threads.dynamicLinkedListBasedNode;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 09.06.2018
 * @param <E> generic type.
 *
 * Dynamic list based on linked nodes.
 */
@ThreadSafe
public class DynamicLinkedListNode<E> implements Iterable<E> {
    /**
     * The field contain link to last added element in collection.
     */
    private Node<E> first;
    /**
     * Getter for field size.
     * @return current size collection.
     */
    @GuardedBy("this")
    public synchronized int getSize() {
        return this.size;
    }
    /**
     * The field counter elements in collection.
     */
    private int size;
    /**
     * The method add element in collection.
     * @param data generic type that collection store.
     */
    @GuardedBy("this")
    public synchronized void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }
    /**
     * The method return data that store in node.
     * @param index order number that node be added in collection.
     * @return data that contain node.
     */
    @GuardedBy("this")
    public synchronized E get(int index) {
        int position = this.size - index;
        Node<E> current = first;
        Node<E> result = first;
        for (int i = 0; i < position; i++) {
            result = current.next;
            current = result;
        }
        return result.data;
    }
    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    @GuardedBy("this")
    public synchronized Iterator<E> iterator() {
        return new Iterator<E>() {
            /**
             * The field need to check fail fast behavior.
             */
            private int failFast = size;
            /**
             * The field count how many method next return elements.
             */
            private int positionIt = 1;
            /**
             * The method check iterator has next element.
             * @return Return true, if more left elements to iterate, otherwise return false.
             * @throws ConcurrentModificationException Throw when collection modified, after iterator create.
             */
            @Override
            @GuardedBy("this")
            public synchronized boolean hasNext() throws ConcurrentModificationException {
                if (size != failFast) {
                    throw new ConcurrentModificationException("Collection has been modified!");
                }
                return positionIt <= size;
            }
            /**
             * The method return next element in iteration.
             * @return element.
             * @throws NoSuchElementException Throw if no more elements to iterate.
             */
            @Override
            @GuardedBy("this")
            public synchronized E next() throws NoSuchElementException {
                if (hasNext()) {
                    return get(positionIt++);
                }
                throw new NoSuchElementException("No more elements left in collection");
            }
        };
    }
}
