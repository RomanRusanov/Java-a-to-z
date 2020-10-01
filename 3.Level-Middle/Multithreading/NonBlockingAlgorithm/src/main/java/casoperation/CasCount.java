package casoperation;

import net.jcip.annotations.ThreadSafe;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 01.10.2020
 * email roman9628@gmail.com
 * The class implements non blocking counter.
 */
@ThreadSafe
public class CasCount {
    /**
     * The field contain instance atomic instance Integer.
     */
    private final AtomicReference<Integer> count = new AtomicReference<>();

    /**
     * The default constructor.
     */
    public CasCount() {
        this.count.set(0);
    }

    /**
     * The method increment count value.
     */
    public void increment() {
        Integer current;
        int currIncremented;
        do {
            current = this.count.get();
            if (current.equals(Integer.MAX_VALUE)) {
                throw new UnsupportedOperationException("Counter Integer = MAX_VALUE");
            }
            currIncremented = current + 1;
        } while (!this.count.compareAndSet(current, currIncremented));
    }

    /**
     * The method get current counter.
     * @return Integer value.
     */
    public int get() {
        return this.count.get();
    }
}