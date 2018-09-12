package ru.rrusanov.collection.tree;
import java.util.Iterator;
import java.util.Optional;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 05.07.2018
 *
 * The interface SimpleTree.
 * @param <E> generic type that collection stored.
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Added element child in parent.
     * Parent may have list of child.
     * @param child child.
     * @param parent parent.
     * @return If added when return true, otherwise false.
     */
    boolean add(E parent, E child);
    /**
     * The method find in tree collection node with passed value, and return them wrapped Optional class(can create
     * empty instance of Node<E>).
     * @param value that node store.
     * @return if collection contain Node with that value then return Node<E>, otherwise return Optional.empty.
     */
    Optional<Node<E>> findBy(E value);
    /**
     * Returns an iterator over elements of type E.
     *
     * @return an Iterator.
     */
    @Override
    Iterator<E> iterator();
}
