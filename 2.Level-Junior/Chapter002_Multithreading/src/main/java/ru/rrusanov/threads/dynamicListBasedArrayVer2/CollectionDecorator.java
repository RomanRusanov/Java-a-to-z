package ru.rrusanov.threads.dynamicListBasedArrayVer2;
import java.util.Iterator;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 12.09.2018
 *
 * The interface describe decorator.
 * @param <E> generic type.
 */
public interface CollectionDecorator<E> {
    /**
     * The method add element to wrapped collection.
     * @param element generic type.
     */
    void add(E element);
    /**
     * The method return element from wrapped collection.
     * @param index index in collection.
     * @return element.
     */
    E get(int index);
    /**
     * The method return iterator wrapped collection.
     * @return Iterator<generic type>
     */
    Iterator<E> iterator();
}
