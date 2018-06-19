package ru.rrusanov.dynamicLinkedListBasedNode;

import java.util.Objects;

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
    /**
     * The method compare Node object by field data.
     * @param o object to compare.
     * @return boolean result.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Node<E> node = (Node<E>) o;
        return this.data.equals(node.data);
    }
    /**
     * The method return hash of that object.
     * @return int hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
