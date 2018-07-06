package ru.rrusanov.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 05.07.2018
 *
 *
 */
public class Node<E extends Comparable<E>> implements Comparable<E> {

    private final List<Node<E>> children = new ArrayList<>();

    private final E value;

    public Node(final E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public void add(Node<E> child) {
        this.children.add(child);
    }

    public List<Node<E>> leaves() {
        return this.children;
    }

    @Override
    public int compareTo(E value) {
        return this.value.compareTo(getValue());
    }


    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }
}
