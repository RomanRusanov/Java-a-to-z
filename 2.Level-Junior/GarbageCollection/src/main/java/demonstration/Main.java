package demonstration;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 24.08.2020
 * email roman9628@gmail.com
 * The class create  in infinite loop help see how GC work in VisualVM Tools.
 * VM Options -Xmx10m -XX:NewRatio=1
 */
public class Main {
    /**
     * The main method.
     * @param args String Args
     * @throws InterruptedException Sleep thread may throw.
     */
    public static void main(String[] args) throws InterruptedException {
        User userStrongRef = new User("-1");
        while (true) {

            for (int i = 0; i < 10000; i++) {
                new User("" + i);
            }
            Thread.sleep(500);
        }
    }

    /**
     * The method print to console HEAP usage.
     * @param comment Topic comment.
     */
    public static void info(String comment) {
        Runtime runtime = Runtime.getRuntime();
        System.out.printf("-=%s=-%n", comment);
        System.out.printf("Total memory: %,d%n", runtime.totalMemory());
        System.out.printf("Max memory: %,d%n", runtime.maxMemory());
        System.out.printf("Used memory:     %,d%n", runtime.totalMemory() - runtime.freeMemory());
        System.out.printf("Free memory:     %,d%n", runtime.freeMemory());
    }
}