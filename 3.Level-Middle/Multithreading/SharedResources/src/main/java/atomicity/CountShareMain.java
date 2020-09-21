package atomicity;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.09.2020
 * email roman9628@gmail.com
 * Какой вывод будет у этой программы? Очевидно, что число 2. Это не верно.
 *
 * Это связано с тем, что операция инкремента - эта упрощенная запись трех операций:
 *
 * 1. чтение переменной.
 *
 * 2. увеличение локальной оперенной на единицу.
 *
 * 3. запись локальной переменной в общий ресурс.
 *
 * Может возникнуть ситуация, что обе нити выполнять чтение переменной одновременно.
 * В результате этого общий ресурс обновиться на единицу, а не на два..
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