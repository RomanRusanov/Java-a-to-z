package cachesoftreference;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.08.2020
 * email roman9628@gmail.com
 * The class describe cache that store key value use soft reference.
 * If Heap memory be low, than cache value removed.
 * K - key object.
 * V - value object.
 */
public class Cache<K,V> {
    /**
     * The map contain key(soft reference instance, and V object associated
     * with key. If you want that key was String object, remember about
     * what String constant is interning and not remove GC.
     */
    private HashMap<K, SoftReference<V>> cache = new HashMap<>();
    /**
     * The field contain instance how process value.
     */
    private WayGetValue<K,V> currentWay;

    /**
     * The default constructor.
     * @param way instance implement interface.
     */
    public Cache(WayGetValue<K,V> way) {
        this.currentWay = way;
    }

    /**
     * The method put pair to collection.
     * @param key Key object.
     * @param value Value object.
     */
    public void put(K key, V value) {
        this.cache.put(key, new SoftReference<>(value));
    }

    /**
     * The method replace in existed key empty value that GC is removed.
     * @param key Key Object.
     * @param value Value Object.
     */
    public void replace(K key, V value) {
        this.cache.replace(key, new SoftReference<>(value));
    }
    /**
     * The method get from cache Value. If cache don't contain what key, then
     * invoke method public V getValue(K key, WayGetValue<K,V> way) that get value
     * from instance WayGetValue<K,V>, after stored value in cache and return it.
     * @param key Key object.
     * @return Value object.
     */
    public V get(K key) {
        V value;
        if (this.cache.containsKey(key)) {
            V strongRef = this.cache.get(key).get();
            if (strongRef == null) {
                value = this.getValue(key, this.currentWay);
                this.replace(key, value);
                System.out.println("-------Not cache operation");
            } else {
                value = strongRef;
                System.out.println("-------Read from cache!");
            }
        } else {
            value = this.getValue(key, this.currentWay);
            this.put(key, value);
            System.out.println("-------Not cache operation");
        }
        return value;
    }

    /**
     * The method return value. How return describe in WayGetValue instance.
     * @param key Key object.
     * @param way Instance that implement WayGetValue interface.
     * @return Value.
     */
    public V getValue(K key, WayGetValue<K,V> way) {
        return way.getValue(key);
    }
}