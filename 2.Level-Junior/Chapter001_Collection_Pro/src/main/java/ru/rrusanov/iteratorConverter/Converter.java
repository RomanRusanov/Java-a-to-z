package ru.rrusanov.iteratorConverter;
import java.util.Iterator;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 20.03.2018
 *
 *
 */
public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }
        };
    }
}
