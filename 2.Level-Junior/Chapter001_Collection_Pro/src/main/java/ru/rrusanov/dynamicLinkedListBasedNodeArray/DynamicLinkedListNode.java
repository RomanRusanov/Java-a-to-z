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
public class DynamicLinkedListNode<E> implements Iterable<E> {
//    /**
//     * The field contain array of nodes with all data.
//     */
//    private Node<E>[] container;
    /**
     * The field contain link to last added element in collection.
     */
    private Node<E> first;
    /**
     * The field contain position in array container.
     */
    private int size;
//    /**
//     * Default constructor.
//     */
//    public DynamicLinkedListNode() {
//        this.container = new Node[1];
//    }

    public void add(E node) {
        Node<E> newLink = new Node<>(node);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    public E get(int index) {
        int position = this.size - index;
        Node<E> current = first;
        Node<E> result = first;
        for (int i = 0; i < position; i++) {
            result = current.next;
            current = result;
        }
        return (E) result.data;
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
