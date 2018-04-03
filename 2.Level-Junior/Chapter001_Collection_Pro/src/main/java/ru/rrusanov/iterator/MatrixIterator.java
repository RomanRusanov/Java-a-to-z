package ru.rrusanov.iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 18.03.2018
 *
 * MatrixIterator class define new iterator type for array interaction.
 */
public class MatrixIterator implements Iterator<Integer> {
    /**
     * Field contains instance of array passe to constructor.
     */
    private final int[][] values;
    /**
     * Field contains counter index outer array position.
     */
    private int indexOut;
    /**
     * Field contains counter index inner array position.
     */
    private int indexIn;
    /**
     * Default constructor.
     * @param values array to process.
     */
    public MatrixIterator(int[][] values) {
        this.values = values;
        this.indexOut = 0;
        this.indexIn = 0;
    }
    /**
     * Method return true if values instance has not yet iterable value.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        return !(indexOut == this.values.length - 1 && indexIn == this.values[indexOut].length);
    }
    /**
     * Return Integer value in current position index, and displace index into next position element.
     * Also can throw NoSuchElementException if in array index place out last element.
     * @return Integer or throw exception.
     */
    @Override
    public Integer next() {
        int result = 0;
        if (!(this.values.length == 0) && this.hasNext()) {
            if (indexIn >= this.values[indexOut].length) {
                indexOut = ++indexOut;
                indexIn = 0;
            }
            if (indexOut < this.values.length) {
                result = this.values[this.indexOut][this.indexIn++];
            }
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }
}
