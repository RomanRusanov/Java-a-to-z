package ru.rrusanov.tree;
import java.util.Iterator;
import java.util.Optional;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 05.07.2018
 *
 *
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

    Optional<Node<E>> findBy(E value);
    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator();
}
