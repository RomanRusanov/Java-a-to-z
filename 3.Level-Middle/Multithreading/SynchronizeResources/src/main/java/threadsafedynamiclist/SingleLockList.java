package threadsafedynamiclist;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.rrusanov.collection.dynamicListBasedArray.DynamicList;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 25.09.2020
 * email roman9628@gmail.com
 * The class implements thread safe list.
 * @param <T> Type that list store.
 */
@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {
    /**
     * Object monitor.
     */
    @GuardedBy("this")
    /**
     * The instance not thread safe list.
     */
    private DynamicList<T> dynamicList = new DynamicList<>();

    /**
     * The method add element to lsit.
     * @param value Element to store.
     */
    public synchronized void add(T value) {
        this.dynamicList.add(value);
    }

    /**
     * The method get element from list.
     * @param index Index of element.
     * @return Stored element.
     */
    public synchronized T get(int index) {
        return this.dynamicList.get(index);
    }

    /**
     * The method return iterator.
     * @return Iterator.
     */
    @Override
    public synchronized Iterator<T> iterator() {
        return copy(this.dynamicList.iterator());
    }

    /**
     * The method return copy of iterator.
     * @param iterator Iterator source.
     * @return copy iterator.
     */
    private Iterator<T> copy(Iterator<T> iterator) {
        ArrayList<T> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result.iterator();
    }
}