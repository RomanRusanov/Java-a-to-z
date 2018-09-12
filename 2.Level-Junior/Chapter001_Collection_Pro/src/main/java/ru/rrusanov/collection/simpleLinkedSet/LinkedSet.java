package ru.rrusanov.collection.simpleLinkedSet;
import ru.rrusanov.collection.dynamicLinkedListBasedNode.DynamicLinkedListNode;
import java.util.Iterator;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 19.06.2018
 *
 * SimpleLinkedSet.java Class implements behavior linked set. Inside use DynamicLinkedListNode<T> class to store element in collection.
 * @param <T> generic type.
 */
public class LinkedSet<T> extends DynamicLinkedListNode<T> implements Iterable<T> {
    /**
     * THe field contain all stored elements.
     */
    private DynamicLinkedListNode<T> collection = new DynamicLinkedListNode<>();
    /**
     * The method add element in collection if element not exist in that collection.
     * @param model element to add.
     */
    @Override
    public void add(T model) {
        if (!this.checkExist(model)) {
            this.collection.add(model);
        }
    }
    /**
     * The method return iterator for collection instance(SimpleArray).
     * @return Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return this.collection.iterator();
    }
    /**
     * The method check present in collection argument node passed.
     * @param model node to check.
     * @return true if exist, otherwise false.
     */
    boolean checkExist(T model) {
        boolean result = false;
        for (T value : collection) {
            if (model.equals(value)) {
                result = true;
            }
        }
        return result;
    }
    /**
     * The method return data that store in node.
     * @param index order number that node be added in collection.
     * @return data store in node.
     */
    @Override
    public T get(int index) {
        return this.collection.get(index);
    }
    /**
     * The method return collection size.
     * @return int value current size.
     */
    @Override
    public int getSize() {
        return this.collection.getSize();
    }
}