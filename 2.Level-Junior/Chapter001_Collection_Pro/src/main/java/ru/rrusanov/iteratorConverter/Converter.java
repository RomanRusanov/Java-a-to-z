package ru.rrusanov.iteratorConverter;
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

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {

            Iterator<Integer> itIn = it.next();

            @Override
            public boolean hasNext() {
                return it.hasNext() || itIn.hasNext();
            }

            @Override
            public Integer next() {
                int result;
                while (true) {
                    if (itIn.hasNext()) {
                        result = itIn.next();
                        break;
                    } else {
                        itIn = it.next();
                    }
                }
                return result;
            }
        };
    }
}
