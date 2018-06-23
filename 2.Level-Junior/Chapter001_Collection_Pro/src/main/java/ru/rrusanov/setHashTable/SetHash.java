package ru.rrusanov.setHashTable;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 22.06.2018
 *
 * The class implements set behavior based on array.
 * @param <E> Generic type that collection store.
 */
public class SetHash<E> {
    /**
     * The field contain all element of set.
     */
    private DataItem<E>[] collection;
    /**
     * The field size of array to store DataItems elements.
     */
    private int collectionSize;
    /**
     * The field actual counter stored element in set.
     */
    private int elementCounter;
    /**
     * The constructor initialize set with specific size.
     * @param size The size with the set initialize.
     */
    public SetHash(int size) {
        this.collection = new DataItem[size];
        this.collectionSize = this.collection.length;
        this.elementCounter = 0;
    }
    /**
     * The constructor initialize set with size = 10.
     */
    public SetHash() {
        this.collection = new DataItem[10];
        this.collectionSize = this.collection.length;
        this.elementCounter = 0;
    }
    /**
     * The method return int hash value = (data element hashcode modulus collection size).
     * @param dataItem DataItem to calculate hash value.
     * @return int hash value.
     */
    public int getHash(DataItem dataItem) {
        return dataItem.getKey().hashCode() % collectionSize;
    }
    /**
     * The method initialize new set with size + 1(DataItem) of old set.
     * Copy old set to new, and calculate new hash value for old values.
     */
    public void growAndReHash() {
        DataItem<E>[] newCollection = new DataItem[this.collection.length + 1];
        this.collectionSize++;
        for (DataItem item : collection) {
            newCollection[this.getHash(item)] = item;
        }
        this.collection = newCollection;
    }
    /**
     * The method add new element to set. Check if element exist in set then skip adding.
     * @param e element of generic type to adding.
     * @return True if element added, otherwise false.
     */
    boolean add(E e) {
        boolean result = false;
        if (this.collectionSize == elementCounter) {
            growAndReHash();
        }
        DataItem<E> newItem = new DataItem<>(e);
        int hashValue = this.getHash(newItem);
        if (this.collection[hashValue] == null || (!this.collection[hashValue].getKey().equals(newItem.getKey()))) {
            this.collection[hashValue] = newItem;
            this.elementCounter++;
            result = true;
        }
        return result;
    }
    /**
     * The method check contain set that element.
     * @param e element to check
     * @return True if contain, otherwise false.
     */
    boolean contains(E e) {
        boolean result = false;
        DataItem<E> newItem = new DataItem<>(e);
        int hashValue = this.getHash(newItem);
        if (this.collection[hashValue] != null && this.collection[hashValue].getKey().equals(newItem.getKey())) {
            result = true;
        }
        return result;
    }
    /**
     * The method remove element from set. Deleted element position replaced by reference.
     * @param e Element to remove from set.
     * @return True if element removed, otherwise false.
     */
    boolean remove(E e) {
        boolean result = false;
        DataItem<E> newItem = new DataItem<>(e);
        int hashValue = this.getHash(newItem);
        if (this.contains(e)) {
            this.collection[hashValue] = null;
            this.elementCounter--;
            result = true;
        }
        return result;
    }
}
