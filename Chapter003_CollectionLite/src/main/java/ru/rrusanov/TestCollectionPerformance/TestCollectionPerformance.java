package ru.rrusanov.TestCollectionPerformance;

import java.util.Collection;
import java.util.Iterator;
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
        this.length = FIFTEEN;
        this.random = new Random();
    }
    /**
     * Constant for string length.
     */
    private static final int FIFTEEN = 15;
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
     * Method add elements in collection and return elapsed time.
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
     * Method delete elements in collection and return elapsed time.
     *
     * @param collection A collection in which deleted elements.
     * @param amount The number of elements to delete.
     * @return How many millisecond need to delete.
     */
    public long delete(Collection<String> collection, int amount) {
        Iterator iterator = collection.iterator();
        int index = 0;
        long start = currentTime();
        while (iterator.hasNext() && index < amount) {
            iterator.next();
            iterator.remove();
            index++;
        }
        long end = currentTime();
        return end - start;
    }
    /**
     * Methods compute current system time in nano seconds.
     *
     * @return Current time in nano seconds.
     */
    public long currentTime() {
        return System.nanoTime();
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
    /**
     * Print table result.
     * @param collection Collection to action.
     * @param typeCollection String to comment.
     * @param amount Number element to action test.
     */
    public void printTable(Collection<String> collection, String typeCollection, int amount) {
        System.out.printf("\n\n%7.15s %12s %7s %25s", "Collection", "Elements", "Action", "Elapsed time in nano sec.");
        long result = this.add(collection, amount);
        System.out.printf("\n%-10.15s %,12d %7s %,25d", typeCollection, amount, "add", result);
        result = this.delete(collection, amount);
        System.out.printf("\n%-10.15s %,12d %7s %,25d", typeCollection, amount, "delete", result);
    }
}
