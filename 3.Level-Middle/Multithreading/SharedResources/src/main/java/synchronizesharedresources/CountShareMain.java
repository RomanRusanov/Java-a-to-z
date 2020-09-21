package synchronizesharedresources;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.09.2020
 * email roman9628@gmail.com
 * Чтобы добиться атомарности не атомарных операций в Java используется
 * механизм синхронизации. Ключевое слово записывается после модификатора доступа.
 * Одновременно с объектом может работать только одна нить. Если две нити пробуют
 * выполнить один и тот же синхронизированный метод, то одна из нитей переходить
 * в режим блокировки до тех пор пока первая нить не закончить работу с этим
 * методом.
 *
 * Синхронизация делают параллельную программу последовательной.
 */
public class CountShareMain {
    /**
     * The main method.
     * @param args passed args.
     * @throws InterruptedException join may throw.
     */
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Thread first = new Thread(count::increment);
        Thread second = new Thread(count::increment);
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println(count.get());
    }
}