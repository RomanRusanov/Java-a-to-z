package ru.rrusanov.collection.simpleArrayList;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 07.06.2018
 *
 * Node class, contain data.
 * @param <E> generic type.
 */
public class Node<E> {
    /**
     * The field contain data.
     */
    E date;
    /**
     * The field next Node point.
     */
    Node<E> next;
    /**
     * Index equals position adding node to collection. Zero is first index in new collection of first element.
     */
    int index;
    /**
     * Default constructor.
     * @param date to store.
     */
    Node(E date) {
        this.date = date;
    }
}
