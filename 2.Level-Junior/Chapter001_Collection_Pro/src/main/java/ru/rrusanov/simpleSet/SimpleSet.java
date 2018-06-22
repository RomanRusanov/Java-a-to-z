package ru.rrusanov.simpleSet;
import ru.rrusanov.simpleArrayT.SimpleArray;
import java.util.Iterator;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 18.06.2018
 *
 * Class implements behavior set. Inside use SimpleArray class to store element in collection.
 * @param <T> generic type, that collection be contain.
 */
public class SimpleSet<T> implements Iterable<T> {
    /**
     * THe field contain all stored elements.
     */
    private SimpleArray<T> collection = new SimpleArray<>();
    /**
     * The method add element in collection if element not exist in that collection.
     * @param model element to add.
     */
    public void add(T model) {
        Integer findIndex = this.collection.findIndex(model);
        if (findIndex.equals(-1)) {
            this.collection.add(model);
        }
    }
    /**
     * The method return element from collection using index.
     * @param index element that return method.
     * @return generic type from collection.
     */
    public T get(int index) {
        return this.collection.get(index);
    }
    /**
     * The method return iterator for collection instance(SimpleArray).
     * @return Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return this.collection.iterator();
    }
}
