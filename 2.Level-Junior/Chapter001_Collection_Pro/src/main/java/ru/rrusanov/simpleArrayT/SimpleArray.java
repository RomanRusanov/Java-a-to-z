package ru.rrusanov.simpleArrayT;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 20.05.2018
 *
 * SimpleArray class wrapper on array.
 */
public class SimpleArray<T>  implements Iterable<T> {

    private T models[];

    private int index = 0;


    public void add(T model) {
        if (index < 5) {
            models[index++] = model;
        } else {
            throw new ArrayIndexOutOfBoundsException("Max models = 5");
        }
    }
    public void set(int index, T model) {
        if (index < 5) {
            models[index] = model;
        } else {
            throw new ArrayIndexOutOfBoundsException("Index model out of range");
        }
    }
    public void delete(int index) {
        if (index < 5) {
            models[index] = null;
        } else {
            throw new ArrayIndexOutOfBoundsException("Index model out of range");
        }
    }
    public T get(int index) {
        if (index < 5) {
            return models[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Index model out of range");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            /**
             * Position next;
             */
            int position = 0;
            /**
             * Method return true if Iterator contain Integer values left, otherwise false.
             * @return boolean
             */
            @Override
            public boolean hasNext() {
                boolean result = false;
                while (position < 5) {
                    result = true;
                }
                return result;
            }
            /**
             * Method return next Integer element in iterator.
             * @return Integer.
             */
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return models[position++];
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
