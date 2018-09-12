package ru.rrusanov.collection.setHashTable;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 23.06.2018
 *
 * The class describe data item for array stored in HashSet class.
 * @param <E> Generic type that collection store.
 */
public class DataItem<E> {
    /**
     * The field contain data of generic type.
     */
    private E data;
    /**
     * The constructor adding data to private field.
     * @param data stored data.
     */
    public DataItem(E data) {
        this.data = data;
    }
    /**
     * The getter return data stored in private field.
     * @return data stored.
     */
    public E getKey() {
        return this.data;
    }
}
