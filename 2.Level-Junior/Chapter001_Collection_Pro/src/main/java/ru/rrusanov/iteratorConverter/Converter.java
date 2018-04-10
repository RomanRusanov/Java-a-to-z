package ru.rrusanov.iteratorConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 20.03.2018
 *
 * Class convert object Iterator<Iterator<Integer>> to Iterator<Integer>
 */
public class Converter {
    /**
     * Field contain Iterator of iterators.
     */
    private ArrayList<Iterator<Integer>> itIn = new ArrayList<>();
    /**
     * Field pointer to current iterator.
     */
    private int position = 0;
    /**
     * Method fill list of iterators.
     * @param iterators to conversion.
     */
    public void fillList(Iterator<Iterator<Integer>> iterators) {
        while (iterators.hasNext()) {
            this.itIn.add(iterators.next());
        }
    }
    /**
     * Method convert iterator(iterators(Integer)) to iterator(integer) including all in iterators elements.
     * @param it iterator to conversion.
     * @return converted iterator.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        /**
         * new anonymous class describes iterator.
         */
        return new Iterator<Integer>() {
            /**
             * Method check has iterator next element.
             * @return true if element exist, otherwise false.
             */
            @Override
            public boolean hasNext() {
                fillList(it);
                boolean result = false;
                while (position < itIn.size()) {
                    if (itIn.get(position).hasNext()) {
                        result = true;
                        break;
                    } else {
                        position++;
                    }
                }
                return result;
            }

            /**
             * Method return next element.
             * @return Next Integer element.
             * @throws NoSuchElementException if no more element in iterator.
             */
            @Override
            public Integer next() throws NoSuchElementException {
                fillList(it);
                int result = -1;
                while (position < itIn.size()) {
                    if (itIn.get(position).hasNext()) {
                        result = itIn.get(position).next();
                        break;
                    } else {
                        position++;
                    }
                }
                if (result == -1) {
                    throw new NoSuchElementException();
                }
                return result;
            }
        };
    }
}
