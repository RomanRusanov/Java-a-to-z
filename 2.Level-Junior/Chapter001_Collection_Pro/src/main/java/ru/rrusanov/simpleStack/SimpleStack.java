package ru.rrusanov.simpleStack;
import ru.rrusanov.simpleArrayT.SimpleArray;
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
    private SimpleArray<T> collection = new SimpleArray<>();
    /**
     * The method return last added element and remove it from collection.
     * @return T data of deleted element.
     */
    public T poll() {
        T deletedElement = this.collection.get(this.collection.getSize() - 1);
        this.collection.delete(this.collection.getSize() - 1);
        return deletedElement;
    }
    /**
     * The method add element in collection.
     * @param value element of T type to add in collection.
     */
    public void push(T value) {
        this.collection.add(value);
    }
}
