package cachesoftreference;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
        Cache<String, File> cache = new Cache<>(new ReadFromDiskWay());
        print(cache.get(new String ("2.Level-Junior/GarbageCollection"
                + "/src/main/resources/Address.txt")));
        print(cache.get(new String("2.Level-Junior/GarbageCollection"
                + "/src/main/resources/Address.txt")));
        activateGC();
        print(cache.get(new String("2.Level-Junior/GarbageCollection"
                + "/src/main/resources/Address.txt")));
        print(cache.get(new String("2.Level-Junior/GarbageCollection"
                + "/src/main/resources/Address.txt")));
        print(cache.get(new String("2.Level-Junior/GarbageCollection"
                + "/src/main/resources/Address.txt")));
    }

    /**
     * The method read file text and out to system out.
     * @param file File to read.
     */
    public static void print(File file) {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
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