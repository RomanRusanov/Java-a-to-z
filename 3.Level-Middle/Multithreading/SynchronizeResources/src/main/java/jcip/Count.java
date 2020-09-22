package jcip;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Нам необходимо создать класс, который будет иметь два метода: увеличить
 * внутренне поле на 1 и второй метод - получить значение этого поля.
 */
@ThreadSafe
public class Count {
    /**
     * The field.
     */
    @GuardedBy("this")
    private int value;

    /**
     * The method.
     */
    public synchronized void increment() {
        this.value++;
    }

    /**
     * The getter.
     * @return int.
     */
    public synchronized int get() {
        return this.value;
    }
}