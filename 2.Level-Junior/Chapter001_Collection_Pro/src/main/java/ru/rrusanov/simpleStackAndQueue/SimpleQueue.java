package ru.rrusanov.simpleStackAndQueue;
import ru.rrusanov.simpleArrayList.SimpleArrayList;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 13.06.2018
 *
 * SimpleQueue collection with behavior classic queue FIFO(first in first out).
 * @param <T> generic type, that collection be contain.
 */
public class SimpleQueue<T> {
    /**
     * The field contain all data<T> elements.
     */
    private SimpleArrayList<T> collection = new SimpleArrayList<>();
    /**
     * The method return first added element and remove it from collection.
     * @return T data of deleted element.
     */
    public T poll() {
        return this.collection.delete(this.collection.getSize() - 1);
    }
    /**
     * The method add element in collection.
     * @param value element of T type to add in collection.
     */
    public void push(T value) {
        this.collection.add(value);
    }
}
