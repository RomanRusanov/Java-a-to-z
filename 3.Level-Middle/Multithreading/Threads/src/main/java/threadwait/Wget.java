package threadwait;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.09.2020
 * email roman9628@gmail.com
 * The class print to console every 1 sec new string.
 */
public class Wget {
    /**
     * Main method.
     * @param args passed params.
     */
    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> {
                    for (int i = 0; i < 100; i++) {
                        print(i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        thread.start();
    }

    /**
     * The method print to console string with.
     * Every call start print from start position same string.
     * @param index passed number to print.
     */
    public static void print(int index) {
        System.out.print("\rLoading :" + index + "%");
    }
}