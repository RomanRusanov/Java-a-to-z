package ru.rrusanov.dynamicLinkedListBasedNode;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 08.09.2018
 * @param <E> generic type.
 *
 * The class describes data container.
 */
public class Node<E> {
    /**
     * The field contain data.
     */
    E data;
    /**
     * The field link to next container node.
     */
    Node<E> next;
    /**
     * Default constructor.
     * @param data Generic type, data to be stored in node.
     */
    public Node(E data) {
        this.data = data;
    }
}
