package jcip;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test class.
 */
public class CountTest {

    /**
     * Класс описывает нить со счетчиком.
     */
    private class ThreadCount extends Thread {
        /**
         * The field.
         */
        private final Count count;

        /**
         * The default constructor.
         * @param count instance of counter.
         */
        private ThreadCount(final Count count) {
            this.count = count;
        }

        /**
         * The method.
         */
        @Override
        public void run() {
            this.count.increment();
        }
    }

    /**
     * Test check counter.
     * @throws InterruptedException Join may throw.
     */
    @Test
    public void whenExecute2ThreadThen2() throws InterruptedException {
        //Создаем счетчик.
        final Count count = new Count();
        //Создаем нити.
        Thread first = new ThreadCount(count);
        Thread second = new ThreadCount(count);
        //Запускаем нити.
        first.start();
        second.start();
        //Заставляем главную нить дождаться выполнения наших нитей.
        first.join();
        second.join();
        //Проверяем результат.
        assertEquals(count.get(), 2);
    }
}