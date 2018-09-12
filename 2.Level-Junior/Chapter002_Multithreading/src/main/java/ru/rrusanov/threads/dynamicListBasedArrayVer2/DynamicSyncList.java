package ru.rrusanov.threads.dynamicListBasedArrayVer2;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.ArrayList;
import java.util.Iterator;

@ThreadSafe
public class DynamicSyncList<E> extends CollectionBehaviorDecorator<E> {

    public DynamicSyncList(CollectionDecorator source) {
        super(source);
    }

    @Override
    @GuardedBy("this")
    public synchronized Iterator<E> iterator() {
        return this.copy(super.iterator());
    }

    public Iterator<E> copy(Iterator<E> iterator) {
        ArrayList<E> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result.iterator();
    }

    @Override
    public void add(E element) {
        super.add(element);
    }

    @Override
    public E get(int index) {
        return super.get(index);
    }
}
