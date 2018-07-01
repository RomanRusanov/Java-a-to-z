package ru.rrusanov.hashMap;
import java.util.*;

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

    private Entry<K, V>[] collection;

    private int size;

    private int elementCounter;

    public HashMap(int size) {
        this.collection = new Entry[size];
        this.size = this.collection.length;
        this.elementCounter = 0;
    }

    public int hash(K key) {
        return (key == null ? 0 : key.hashCode() % size);
    }

    public void growAndReHash() {
        Entry<K, V>[] newCollection = new Entry[this.collection.length + 1];
        this.size++;
        for (Entry item : collection) {
            Entry<K, V> entry = item;
            newCollection[this.hash(entry.getKey())] = item;
        }
        this.collection = newCollection;
    }

    public Entry<K, V>[] removeNullsElements() {
        Entry<K, V>[] newCollection = new Entry[this.elementCounter];
        int index = 0;
        for (Entry item : this.collection) {
            if (item.getKey() != null) {
                newCollection[index++] = item;
            }
        }
        return newCollection;
    }
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

    V get(K key) {
        return this.collection[this.hash(key)].getValue();
    }

    boolean delete(K key) {
        boolean result = false;
        int hash = this.hash(key);
        if (this.collection[hash].getKey() == key) {
            this.collection[hash] = null;
            this.elementCounter--;
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<Entry<K, V>>() {

            private Entry<K,V>[] elements = removeNullsElements();

            private int counter = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (this.elements.length != this.counter) {
                    result = true;
                }
                return result;
            }

            @Override
            public Entry<K, V> next() throws NoSuchElementException {
                if (hasNext()) {
                    return this.elements[this.counter++];
                }
                throw new NoSuchElementException("No more element to iterate!");
            }

            public ArrayList<V> sortAscendingOrder() {
                ArrayList<V> sortedValues = new ArrayList<>(this.elements.length);
                for (Entry<K,V> item : this.elements) {
                    sortedValues.add(item.getValue());
                }
                sortedValues.sort(new Comparator<V>() {
                    @Override
                    public int compare(V o1, V o2) {
                        int result = 0;
                        if (o1 > o2){

                        }
                        return result;
                    }
                });
                return sortedValues;
            }

        };
    }
}
