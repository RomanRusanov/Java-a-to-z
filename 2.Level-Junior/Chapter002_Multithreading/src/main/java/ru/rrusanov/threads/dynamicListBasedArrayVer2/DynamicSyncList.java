package ru.rrusanov.threads.dynamicListBasedArrayVer2;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 12.09.2018
 *
 * The class wrap collection that implement CollectionBehaviorDecorator.
 * @param <E> generic type.
 */
@ThreadSafe
public class DynamicSyncList<E> extends CollectionBehaviorDecorator<E> {
    /**
     * The default constructor.
     * @param source new object to wrap.
     */
    public DynamicSyncList(CollectionDecorator source) {
        super(source);
    }
    /**
     * The method return iterator wrapped collection.
     * @return Iterator<generic type>
     */
    @Override
    @GuardedBy("this")
    public synchronized Iterator<E> iterator() {
        return this.copy(super.iterator());
    }
    /**
     * The method do snapshot of iterator, and return new instance iterator, what not refer to wrapped collection.
     * @param iterator wrapped collection, what you for snapshot.
     * @return iterator.
     */
    public Iterator<E> copy(Iterator<E> iterator) {
        ArrayList<E> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result.iterator();
    }
    /**
     * The method add element to wrapped collection.
     * @param element generic type.
     */
    @Override
    @GuardedBy("this")
    public synchronized void add(E element) {
        super.add(element);
    }
    /**
     * The method return element from wrapped collection.
     * @param index index in collection.
     * @return element.
     */
    @Override
    @GuardedBy("this")
    public synchronized E get(int index) {
        return super.get(index);
    }
}