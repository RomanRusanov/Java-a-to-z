package ru.rrusanov.dynamicLinkedListBasedNodeArray;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 09.06.2018
 * @param <E> generic type.
 *
 * Dynamic list based on array linked nodes.
 */
public class DynamicLinkedListNode<E> extends Iterable<E> {
    /**
     * The field contain array of nodes with all data.
     */
    private Node<E>[] container;
    /**
     * The field contain link to last added element in collection.
     */
    private Node<E> first;
    /**
     * The field contain position in array container.
     */
    private int position = 0;
    /**
     * Default constructor.
     */
    public DynamicLinkedListNode() {
        this.container = new Node[1];
    }

    public void add(E node) {
        if (this.container.length - 1 == this.position) {
            this.container = Arrays.copyOf(this.container, this.container.length + 1);
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
