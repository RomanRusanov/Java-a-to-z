package ru.rrusanov.threads.dynamicListBasedArrayVer2;
import java.util.Iterator;

public interface CollectionDecorator<E> {

    void add(E element);

    E get(int index);

    Iterator<E> iterator();
}
