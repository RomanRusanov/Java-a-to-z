package ru.rrusanov.threads.dynamicListBasedArrayVer2;
import java.util.Iterator;

public class CollectionBehaviorDecorator<E> implements CollectionDecorator<E> {

    private CollectionDecorator<E> wrapper;

    public CollectionBehaviorDecorator(CollectionDecorator source) {
        this.wrapper = source;
    }

    @Override
    public Iterator<E> iterator() {
        return this.wrapper.iterator();
    }

    public void add(E element) {
        this.wrapper.add(element);
    }

    public E get(int index) {
        return this.wrapper.get(index);
    }
}
