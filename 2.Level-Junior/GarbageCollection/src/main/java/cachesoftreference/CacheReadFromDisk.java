package cachesoftreference;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.08.2020
 * email roman9628@gmail.com
 * The class Demonstrate how cache on soft reference work.
 * The program runs with -Xmx3m key to restrict max heap size.
 */
public class CacheReadFromDisk {
    /**
     * The method demonstrate when cache run first time key not exist and
     * read from not cache. Second invoke with same key value provide read from
     * cache. After GC clean soft reference cache is empty and first read not
     * from cache.
     * @param args Args.
     */
    public static void main(String[] args) {
        Cache<String, byte[]> cache = new Cache<>(new ReadFromDiskWay());
        print(cache.get("Address.txt"));
        print(cache.get("Address.txt"));
        activateGC();
        print(cache.get("Address.txt"));
        print(cache.get("Address.txt"));
        print(cache.get("Address.txt"));
    }

    /**
     * The method read file text and out to system out.
     * @param in BufferedReader stream print to console.
     */
    public static void print(byte[] in) {
        System.out.println(new String(in));
    }

    /**
     * The method creat in loop many instance class. When many instance
     * create overhead in heap activate GC and soft reference remove.
     */
    public static void activateGC() {
        for (int i = 0; i < 15_000_000; i++) {
            new Cache<>(new ReadFromDiskWay());
        }
        System.gc();
    }
}