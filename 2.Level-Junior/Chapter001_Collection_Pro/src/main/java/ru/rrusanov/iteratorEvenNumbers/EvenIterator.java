package ru.rrusanov.iteratorEvenNumbers;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 20.03.2018
 *
 * EvenIterator class define new iterator type for array that return only even numbers.
 */
public class EvenIterator implements Iterator<Integer> {
    /**
     * Contain passed array.
     */
    private int[] array;
    /**
     * Index current position of iterator.
     */
    private int index;
    public EvenIterator() {
        this.array = new int[]{};
        this.index = 0;
    }
    /**
     * Default constructor.
     *
     * @param array passed for iteration.
     */
    public EvenIterator(final int[] array) {
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
     * Find even number in array.
     *
     * @return int next even number in array.
     */
    public int find() {
        int result = -1;
        for (int i = index; i < this.array.length; i++) {
            if (this.array[i] % 2 == 0) {
                result = i;
                break;
            }
        }
        return result;
    }
}
