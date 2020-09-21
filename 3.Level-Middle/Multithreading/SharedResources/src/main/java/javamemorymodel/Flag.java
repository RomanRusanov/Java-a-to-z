package javamemorymodel;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.09.2020
 * email roman9628@gmail.com
 * Может возникнуть ситуация, что главная нить запишет новое значение переменной
 * в кеш процессора, а дополнительная нить будет продолжать читать переменную
 * flag из регистра. Эта ситуация называется проблемой видимости (share
 * visibility problem). Чтобы ее решить, можно использовать синхронизацию.
 * Но, в данном случае, она избыточна. В Java есть облегченный механизм
 * синхронизации - volatile. Его можно использовать только в том случае, когда
 * общий ресурс не обновляется в зависимости от своего состояния. Например,
 * для инкремента его использовать нельзя. volаtile - это ключевое слово,
 * которое используется для полей класса. Если поле класса обозначено volatile,
 * то чтение и запись переменной будет происходить только из RAM памяти процессора.
 */
public class Flag {
    /**
     * The filed contain shared.
     */
    private static volatile boolean flag = true;

    /**
     * The main method.
     * @param args Passed params.
     * @throws InterruptedException Sleep and join may throw.
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(
                () -> {
                    while (flag) {
                        System.out.println(Thread.currentThread().getName());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        thread.start();
        Thread.sleep(1000);
        flag = false;
        thread.join();
    }
}