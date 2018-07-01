package ru.rrusanov.hashMap;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 28.06.2018
 * @param <K> key instance.
 * @param <V> data associated with key.
 *
 * The class describes instance that store one data entry.
 */
public class Entry<K, V>  {

    private K key;

    private V value;


    public Entry(K key, V value) {
        this.key = key;
        this.value = value;

    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return 31 * ((this.key == null ? 0 : this.key.hashCode())
                + (this.value == null ? 0 : this.value.hashCode()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Entry entryO = (Entry) o;
        return this.key.equals(entryO.key) && this.value.equals(entryO.value);
    }
}
