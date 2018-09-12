package ru.rrusanov.collection.hashMap;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 28.06.2018
 * @param <K> key instance.
 * @param <V> data associated with key.
 *
 * The class Entry.java describes instance that store one data entry.
 */
public class Entry<K, V>  {
    /**
     * The field contain key value.
     */
    private K key;
    /**
     * The field contain data associated with key.
     */
    private V value;
    /**
     * The default constructor.
     * @param key generic class key.
     * @param value generic data associated with key.
     */
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    /**
     * The method return key value.
     * @return generic key.
     */
    public K getKey() {
        return key;
    }
    /**
     * The method return data value associated with key.
     * @return data value.
     */
    public V getValue() {
        return value;
    }
    /**
     * The method return hashcode.
     * @return int value.
     */
    @Override
    public int hashCode() {
        return 31 * ((this.key == null ? 0 : this.key.hashCode())
                + (this.value == null ? 0 : this.value.hashCode()));
    }
    /**
     * The method compare to Entry by fields key and value.
     * @param o passed object.
     * @return If equals by fields, return true, otherwise false.
     */
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
