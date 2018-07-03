package ru.rrusanov.hashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 28.06.2018
 * @param <K> key instance.
 * @param <V> data associated with key.
 *
 * The class describes collection with classic HashMap without collision handling. If exist collision put return false.
 */
public class HashMap<K, V> implements Iterable<Entry<K, V>> {
    /**
     * The field contain entry(key, value) elements.
     */
    private Entry<K, V>[] collection;
    /**
     * The field contain current value of collection size.
     */
    private int size;
    /**
     * The field contain current value of entry elements in collection.
     */
    private int elementCounter;
    /**
     * The default constructor.
     * @param size initial size of collection.
     */
    public HashMap(int size) {
        this.collection = new Entry[size];
        this.size = this.collection.length;
        this.elementCounter = 0;
    }
    /**
     * The method return hash value for key.
     * @param key The value of the key for which you want to compute a hash.
     * @return hash value.
     */
    public int hash(K key) {
        return (key == null ? 0 : key.hashCode() % size);
    }
    /**
     * The method return size of collection.
     * @return size value.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * The method resize(old length + 1) the collection field if call insert
     * method and no more left free entry in array,
     * and rehash all elements, because hash compute on collection length.
     */
    public void growAndReHash() {
        Entry<K, V>[] newCollection = new Entry[this.collection.length + 1];
        this.size++;
        for (Entry item : collection) {
            Entry<K, V> entry = item;
            newCollection[this.hash(entry.getKey())] = item;
        }
        this.collection = newCollection;
    }
    /**
     * The method need to iterator behavior support. Remove null elements from collection field.
     * And return copy with out null elements
     * @return Array Entry
     */
    public Entry<K, V>[] removeNullsElements() {
        Entry<K, V>[] newCollection = new Entry[this.elementCounter];
        int index = 0;
        for (Entry item : this.collection) {
            if (item != null && item.getKey() != null) {
                newCollection[index++] = item;
            }
        }
        return newCollection;
    }
    /**
     * The method insert new pair key and value in collection. Null key value not accepted.
     * @param key value
     * @param value associated value with key.
     * @return If pair added then return true, otherwise false.
     */
    boolean insert(K key, V value) {
        if (this.elementCounter == this.size) {
            this.growAndReHash();
        }
        boolean result = false;
        Entry newEntry = new Entry(key, value);
        int hash = this.hash(key);
        if (this.collection[hash] == null) {
            this.collection[hash] = newEntry;
            this.elementCounter++;
            result = true;
        }
        return result;
    }
    /**
     * The method return value associated with passed key value.
     * @param key value.
     * @return associated value with key.
     */
    V get(K key) {
        return this.collection[this.hash(key)].getValue();
    }
    /**
     * The method remove pair from collection.
     * @param key to remove
     * @return If pair remove then return true, otherwise false.
     */
    boolean delete(K key) {
        boolean result = false;
        int hash = this.hash(key);
        if (this.collection[hash] != null && this.collection[hash].getKey() == key) {
            this.collection[hash] = null;
            this.elementCounter--;
            result = true;
        }
        return result;
    }
    /**
     * Classic iterator for collection.
     * @return iterator instance.
     */
    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<Entry<K, V>>() {
            /**
             * The field contain array elements entry without nulls key values.
             */
            private Entry<K,V>[] elements = removeNullsElements();
            /**
             * The field contain counter how many elements iterator return.
             */
            private int counter = 0;
            /**
             * The method check has more elements to iterate.
             * @return True if exist element, otherwise false.
             */
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (this.elements.length != this.counter) {
                    result = true;
                }
                return result;
            }
            /**
             * The method return next element.
             * @return Entry<K, V>.
             * @throws NoSuchElementException If no more elements to iterate and call next method.
             */
            @Override
            public Entry<K, V> next() throws NoSuchElementException {
                if (hasNext()) {
                    return this.elements[this.counter++];
                }
                throw new NoSuchElementException("No more element to iterate!");
            }
        };
    }
}
