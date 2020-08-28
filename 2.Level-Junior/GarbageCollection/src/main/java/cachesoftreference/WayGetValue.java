package cachesoftreference;

/**
 * The interface describe how get value.
 * @param <K> Key objet.
 * @param <V> Value objet.
 */
public interface WayGetValue<K, V> {
    /**
     * The method get value.
     * @return V value.
     */
    public V getValue(K key);
}
