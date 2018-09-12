package ru.rrusanov.collection.simpleStackAndQueue;
import ru.rrusanov.collection.simpleArrayList.SimpleArrayList;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 11.06.2018
 *
 * SimpleStack collection with behavior classic stack LIFO(last in first out).
 * @param <T> generic type, that collection be contain.
 */
public class SimpleStack<T> {
    /**
     * The field contain all data<T> elements.
     */
    private SimpleArrayList<T> collection = new SimpleArrayList<>();
    /**
     * The method return last added element and remove it from collection.
     * @return T data of deleted element.
     */
    public T poll() {
        return this.collection.delete();
    }
    /**
     * The method add element in collection.
     * @param value element of T type to add in collection.
     */
    public void push(T value) {
        this.collection.add(value);
    }
}