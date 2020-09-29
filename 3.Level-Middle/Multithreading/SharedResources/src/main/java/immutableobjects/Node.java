package immutableobjects;
import net.jcip.annotations.NotThreadSafe;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.09.2020
 * email roman9628@gmail.com
 * 1. Ниже приведен код не потокобезопасного класса, описывающего узел
 *    односвязного списка.
 * 2. Сделайте этот класс @Immutable.
 *
 * Правила создания Immutable объекта.
 * 1. Все поля отмечены final.
 * 2. Состояние объекта не изменяется после создания объекта.
 * @param <T> Type that node store.
 */
@NotThreadSafe
public class Node<T> {
    /**
     * The field contain reference to next node.
     */
    private final Node next;
    /**
     * The field contain value this node.
     */
    private final T value;

    /**
     * The default constructor.
     * @param next Reference to next node.
     * @param value Value this node.
     */
    public Node(Node next, T value) {
        this.next = next;
        this.value = value;
    }

    /**
     * The getter.
     * @return Node reference.
     */
    public Node getNext() {
        return next;
    }

    /**
     * The getter.
     * @return Value this node.
     */
    public T getValue() {
        return value;
    }
}