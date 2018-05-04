package ru.rrusanov.iteratorConverter;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 20.03.2018
 *
 * Class convert object Iterator<Iterator<Integer>> to Iterator<Integer>.
 */
public class Converter {
    /**
     *  Method convert from Iterator1<Iterator2<Integer>> in sequence Iterator<Integer> contains all Iterators2.
     * @param it iterator to conversion.
     * @return Iterator<Integer> contains all Iterators2.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            /**
             * Pointer to internal iterator.
             */
            Iterator<Integer> current = it.next();
            /**
             * Method return true if Iterator contain Integer values left, otherwise false.
             * @return boolean
             */
            @Override
            public boolean hasNext() {
                boolean result = false;
                while (it.hasNext() || current.hasNext()) {
                    if (current.hasNext()) {
                        result = true;
                        break;
                    } else {
                        current = it.next();
                    }
                }
                return result;
            }
            /**
             * Method return next Integer element in iterator.
             * @return Integer.
             */
            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return current.next();
            }
        };
    }
}
