package ru.rrusanov.simpleArrayList;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 07.06.2018
 *
 * Node class, contain data.
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
     * Default constructor.
     * @param date to store.
     */
    Node(E date) {
        this.date = date;
    }
}