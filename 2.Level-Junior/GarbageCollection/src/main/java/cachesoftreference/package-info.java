/**
 * Cache.java The class describe cache that store key value use soft reference.
 *  public Cache(WayGetValue<K,V> way) The default constructor.
 *  public void put(K key, V value) The method put pair to collection.
 *  public V get(K key) The method get from cache Value.
 *  public V getValue(K key, WayGetValue<K,V> way) The method return value.
 * WayGetValue.java The interface describe how get value.
 *  public V getValue(K key) The method get value.
 * ReadFromDiskWay.java The class create instance File from string.
 *  public File getValue(String key) The method get value.
 * CacheReadFromDisk.java The class Demonstrate how cache on soft reference work.
 *
 */
package cachesoftreference;