package casoperation;

import net.jcip.annotations.ThreadSafe;
import java.util.concurrent.atomic.AtomicReference;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 01.10.2020
 * email roman9628@gmail.com
 * The class describe Stack with thread safe CAS operation.
 */
@ThreadSafe
public class CASStack<T> {
    /**
     * The field contain ref to head element.
     */
    private final AtomicReference<Node<T>> head = new AtomicReference<>();

    /**
     * The method add element to stack.
     * CAS operation not blocking other threads method compareAndSet atomic,
     * if another thread call it return false.
     * @param value Value to insert.
     */
    public void push(T value) {
        Node<T> temp = new Node<>(value);
        Node<T> ref;
        do {
            ref = head.get();
            temp.next = ref;
        } while (!head.compareAndSet(ref, temp));
    }

    /**
     * The method return head element.
     * ref - reference to head element.
     * temp - reference to next element in head node.
     * !head.compareAndSet(ref, temp) compare head reference with ref reference
     * if they equals head change to tmp reference and return true, out cycle.
     * If not equals repeat cycle.
     * ref.next = null remove reference to next element, because this node be
     * removed from stack, and next element not need more.
     * @return Stored T element value.
     */
    public T poll() {
        Node<T> ref;
        Node<T> temp;
        do {
            ref = head.get();
            if (ref == null) {
                throw new IllegalStateException("Stack, is empty");
            }
            temp = ref.next;
        } while (!head.compareAndSet(ref, temp));
        ref.next = null;
        return ref.value;
    }

    private static final class Node<T> {
        final T value;

        Node<T> next;

        public Node(final T value) {
            this.value = value;
        }
    }
}