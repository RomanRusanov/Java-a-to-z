package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 06.10.2020
 * email roman9628@gmail.com
 * The class example describe how work async process.
 * Describe api CompletableFuture class.
 */
public class FatherSon {
    /**
     * Describe process Father work.
     * @throws InterruptedException InterruptedException.
     */
    private static void iWork() throws InterruptedException {
        int count = 0;
        while (count < 10) {
            System.out.println("Вы: Я работаю");
            TimeUnit.SECONDS.sleep(1);
            count++;
        }
    }

    /**
     * Describe process son goes to take out the trash.
     * @return Void.
     */
    public static CompletableFuture<Void> goToTrash() {
        return CompletableFuture.runAsync(
                () -> {
                    System.out.println("Сын: Мам/Пам, я пошел выносить мусор");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Сын: Мам/Пап, я вернулся!");
                }
        );
    }

    /**
     * thenApply(), thenAccept(), thenRun()
     *
     * Данные методы позволяют прописать методы-колбэки (callback).
     * Callback-метод – это метод, который будет вызван после выполнения
     * асинхронной задачи. Обратите внимание, что все эти методы также
     * возвращают CompletableFuture.
     *
     * Этот метод ничего не возвращает, а позволяет выполнить задачу типа
     * Runnable после выполнения асинхронной задачи. Допишем первый пример,
     * чтобы сын шел мыть руки.
     * @throws Exception Exception.
     */
    public static void thenRunExample() throws Exception {
        CompletableFuture<Void> gtt = goToTrash();
        gtt.thenRun(() -> {
            int count = 0;
            while (count < 3) {
                System.out.println("Сын: я мою руки");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
            System.out.println("Сын: Я помыл руки");
        });
        iWork();
    }

    /**
     * Describe when son goes to shop, and he need buy milk.
     * @param product What product bought son.
     * @return Product name.
     */
    public static CompletableFuture<String> buyProduct(String product) {
        return CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("Сын: Мам/Пам, я пошел в магазин");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Сын: Мам/Пап, я купил " + product);
                    return product;
                }
        );
    }

    /**
     * Describe process when async work return result.
     * @throws Exception Exception.
     */
    public static void supplyAsyncExample() throws Exception {
        CompletableFuture<String> bm = buyProduct("Молоко");
        iWork();
        System.out.println("Куплено: " + bm.get());
    }

    /**
     * Допустим вы не хотите запускать отдельную задачу, а хотите, чтобы просто
     * было выполнено какое-то действие. В отличие от thenRun(), этот метод
     * имеет доступ к результату CompletableFuture. Допишем второй пример,
     * чтобы сын убрал молоко в холодильник.
     * @throws Exception Exception.
     */
    public static void thenAcceptExample() throws Exception {
        CompletableFuture<String> bm = buyProduct("Молоко");
        bm.thenAccept((product) -> System.out.println("Сын: Я убрал " + product + " в холодильник "));
        iWork();
        System.out.println("Куплено: " + bm.get());
    }

    /**
     * Этот метод принимает Function. Также имеет доступ к результату. Как раз
     * благодаря этому, мы можем произвести преобразование полученного
     * результата. Допишем второй пример. Например, вы хотите, чтобы после того,
     * как сын принес молоко, налил вам его в кружку. Однако результат
     * преобразования станет доступным только при вызове get().
     * @throws Exception Exception.
     */
    public static void thenApplyExample() throws Exception {
        CompletableFuture<String> bm = buyProduct("Молоко")
                .thenApply((product) -> "Сын: я налил тебе в кружку " + product + ". Держи.");
        iWork();
        System.out.println(bm.get());
    }

    /**
     * Данный метод используется, если действия зависимы. Т.е. сначала должно
     * выполниться одно, а только потом другое. Например, вам принципиально,
     * чтобы сын сначала выбросил мусор, а только потом сходил за молоком.
     * В ситуации можно записать так.
     * @throws Exception Exception.
     */
    public static void thenComposeExample() throws Exception {
        CompletableFuture<Void> result = buyProduct("Молоко").thenCompose(a -> goToTrash());
        iWork();
    }

    /**
     * Данный метод используется если действия могут быть выполнены независимо
     * друг от друга. Причем в качестве второго аргумента, нужно передавать
     * BiFunction – функцию, которая преобразует результаты двух задач во что-то
     * одно. Например, первого сына вы посылаете выбросить мусор, а второго
     * сходить за молоком. В этой ситуации можно поступить так.
     * @throws Exception Exception.
     */
    public static void thenCombineExample() throws Exception {
        CompletableFuture<String> result = buyProduct("Молоко")
                .thenCombine(buyProduct("Хлеб"), (r1, r2) -> "Куплены " + r1 + " и " + r2);
        iWork();
        System.out.println(result.get());
    }

    /**
     * Describe async process with out return statement.
     * @param name String.
     * @return String name.
     */
    public static CompletableFuture<Void> washHands(String name) {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ", моет руки");
        });
    }

    /**
     * Это метод возвращает ComputableFuture<Void>, при этом обеспечивает
     * выполнение всех задач. Например, вы зовете всех членов семью к столу.
     * Надо дождаться пока все помоют руки.
     * @throws Exception Exception.
     */
    public static void allOfExample() throws Exception {
        CompletableFuture<Void> all = CompletableFuture.allOf(
                washHands("Папа"), washHands("Мама"),
                washHands("Ваня"), washHands("Боря")
        );
        TimeUnit.SECONDS.sleep(3);
    }

    /**
     * Describe process with return String after complete.
     * @param name String.
     * @return String name.
     */
    public static CompletableFuture<String> whoWashHands(String name) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return name + ", моет руки";
        });
    }

    /**
     * Этот метод возвращает ComputableFuture<Object>. Результатом будет первая
     * выполненная задача. На том же примере мы можем, например, узнать,
     * кто сейчас моет руки. Результаты запуск от запуска будут различаться.
     * @throws Exception Exception.
     */
    public static void anyOfExample() throws Exception {
        CompletableFuture<Object> first = CompletableFuture.anyOf(
                whoWashHands("Папа"), whoWashHands("Мама"),
                whoWashHands("Ваня"), whoWashHands("Боря")
        );
        System.out.println("Кто сейчас моет руки?");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(first.get());
    }

    /**
     * The main method.
     * @param args Passed args.
     * @throws Exception Exception.
     */
    public static void main(String[] args) throws Exception {
//        FatherSon.runAsyncExample();
//        FatherSon.supplyAsyncExample();
//        FatherSon.thenAcceptExample();
//        FatherSon.thenApplyExample();
//        FatherSon.thenComposeExample();
//        FatherSon.thenCombineExample();
//        FatherSon.allOfExample();
        FatherSon.anyOfExample();
    }
}