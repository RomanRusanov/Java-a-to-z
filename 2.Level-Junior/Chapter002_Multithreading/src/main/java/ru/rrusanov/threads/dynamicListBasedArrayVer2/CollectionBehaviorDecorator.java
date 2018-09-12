package ru.rrusanov.threads.dynamicListBasedArrayVer2;
import java.util.Iterator;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 12.09.2018
 *
 * The class describe wrapper object.
 * @param <E> generic type.
 */
public class CollectionBehaviorDecorator<E> implements CollectionDecorator<E> {
    /**
     * The filed contain instance wrapped object.
     */
    private CollectionDecorator<E> wrapper;
    /**
     * Default constructor.
     * @param source wrapped object.
     */
    public CollectionBehaviorDecorator(CollectionDecorator source) {
        this.wrapper = source;
    }
    /**
     * The method return iterator wrapped collection.
     * @return Iterator<generic type>
     */
    @Override
    public synchronized Iterator<E> iterator() {
        return this.wrapper.iterator();
    }
    /**
     * The method add element to wrapped collection.
     * @param element generic type.
     */
    @Override
    public  synchronized void add(E element) {
        this.wrapper.add(element);
    }
    /**
     * The method return element from wrapped collection.
     * @param index index in collection.
     * @return element.
     */
    @Override
    public synchronized E get(int index) {
        return this.wrapper.get(index);
    }
}