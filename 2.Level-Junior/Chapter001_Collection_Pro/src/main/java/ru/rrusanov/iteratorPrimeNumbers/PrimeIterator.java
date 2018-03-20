package ru.rrusanov.iteratorPrimeNumbers;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 20.03.2018
 *
 * PrimeIterator class define new iterator type for array that return only primes numbers.
 */
public class PrimeIterator implements Iterator<Integer> {
    /**
     * Contain passed array.
     */
    private int[] array;
    /**
     * Index current position of iterator.
     */
    private int index;
    /**
     * Default constructor.
     *
     * @param array passed for iteration.
     */
    public PrimeIterator(final int[] array) {
        this.array = array;
        this.index = 0;
    }
    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        if (this.find() != -1) {
            result = true;
        }
        return result;
    }
    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Integer next() throws NoSuchElementException {
        int result;
        int current = this.find();
        if (current != -1) {
            result = this.array[current];
            index = ++current;
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }
    /**
     * Find prime number in array.
     *
     * @return int next even number in array.
     */
    public int find() {
        int result = -1;
        for (int i = index; i < this.array.length; i++) {
            if (this.array[i] > 1 && this.prime(this.array[i])) {
                result = i;
                break;
            }
        }
        return result;
    }
    /**
     * Check passed number if it prime when return true.
     *
     * @param number int number to check.
     * @return boolean result check.
     */
    public boolean prime(int number) {
        boolean result = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}


