package objectmonitorcriticalsection;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.09.2020
 * email roman9628@gmail.com
 * Синхронизация методов класса Count и Count2 равносильна.
 * В Count2 более наглядно отображено, какой объект выступает в роли монитора.
 */
public class Count {
    /**
     * The field.
     */
    private int value;

    /**
     * The method.
     */
    public synchronized void increment() {
        value++;
    }

    /**
     * The getter.
     * @return Int.
     */
    public synchronized int get() {
        return value;
    }

    /**
     * The class.
     */
    public class Count2 {
        /**
         * The field.
         */
        private int value;
        /**
         * The method.
         */
        public void increment() {
            synchronized (this) {
                value++;
            }
        }

        /**
         * The getter.
         * @return Int.
         */
        public int get() {
            synchronized (this) {
                return value;
            }
        }
    }
}