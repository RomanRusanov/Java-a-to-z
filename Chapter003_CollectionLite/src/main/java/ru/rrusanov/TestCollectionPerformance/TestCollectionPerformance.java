package ru.rrusanov.TestCollectionPerformance;

import java.util.Collection;
import java.util.Random;

/**
 * Class test performance collection LinkedList, ArrayList, TreeSet.
 * Compute how many time need each collection
 * to add and remove first n elements.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 11.01.18
 */
public class TestCollectionPerformance {
    /**
     * Default constructor.
     */
    public TestCollectionPerformance() {
        characters = "ABC123";
        this.length = 15;
        this.random = new Random();
    }
    /**
     * The characters of that string is used to generate random strings in method generateString().
     */
    private final String characters;
    /**
     * The value of length is used to generate random string length in method generateString().
     */
    private final int length;
    /**
     * The randomize generator.
     */
    private final Random random;
    /**
     * Method add elements in collection.
     *
     * @param collection A collection in which added elements.
     * @param amount The number of elements to add.
     * @return How many millisecond need to add.
     */
    public long add(Collection<String> collection, int amount) {
        long start = currentTime();
        for (int i = 0; i < amount; i++) {
            collection.add(generateString());
        }
        long end = currentTime();
        return end - start;
    }
    /**
     * Method delete elements in collection.
     *
     * @param collection A collection in which deleted elements.
     * @param amount The number of elements to delete.
     * @return How many millisecond need to delete.
     */
    public long delete(Collection<String> collection, int amount) {
        return -1;
    }
    /**
     * Methods compute current system time in milliseconds.
     *
     * @return Current time in milliseconds.
     */
    public long currentTime(){
        return System.currentTimeMillis();
    }
    /**
     * Generate random string.
     *
     * random - Randomize generator.
     * characters - The set of characters which will form the string.
     * length - The length of the string.
     * @return Generated string.
     */
    public String generateString() {
        char[] text = new char[this.length];
        for (int i = 0; i < this.length; i++) {
            text[i] = this.characters.charAt(this.random.nextInt(this.characters.length()));
        }
        return new String(text);
    }
}
