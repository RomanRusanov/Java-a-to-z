package ru.rrusanov.iteratorPrimeNumbers;

import java.util.Iterator;
import java.util.NoSuchElementException;
import ru.rrusanov.iteratorEvenNumbers.EvenIterator;

public class PrimeIterator  extends EvenIterator implements Iterator<Integer> {
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
            super(array);
            this.array = array;
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
            return super.hasNext();
        }
        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next() throws NoSuchElementException {
            return super.next();
        }
        /**
         * Find even number in array.
         *
         * @return int next even number in array.
         */
        public int find() {
            int result = -1;
            for (int i = index; i < this.array.length; i++) {
                if (this.array[i] > 1 && this.array[i] % 2 != 0) {
                    result = i;
                    break;
                }
            }
            return result;
        }

        public boolean prime() {

        }
    }


