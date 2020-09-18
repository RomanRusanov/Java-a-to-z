package threadstop;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.09.2020
 * email roman9628@gmail.com
 * The class create string with progressbar animation.
 */
public class ConsoleProgress implements Runnable {
    /**
     * The field contain index in array symbols what last used.
     */
    private int index = 0;
    /**
     * The field contain array symbols that print.
     */
    private char[] symbols = {'-', '\\', '|', '/'};
    /**
     * The method print to console string with next symbol from array symbols.
     * If array index last, when start from first position.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.print("\r load: " + animate());
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * The method return next character.
     * @return character from array symbols.
     */
    public char animate() {
        if (this.index == 4) {
            this.index = 0;
        }
        return this.symbols[index++];
    }

    /**
     * The main method.
     * @param args Passed args.
     */
    public static void main(String[] args) {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        progress.interrupt();
    }
}