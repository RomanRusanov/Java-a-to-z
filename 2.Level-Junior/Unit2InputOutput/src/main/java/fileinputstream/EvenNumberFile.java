package fileinputstream;
import java.io.FileInputStream;
/**
 * @author Roman Rusanov
 * @version 0.1
 * email roman9628@gmail.com
 * The class Read from file numbers and check even number or not.
 * @since 04.08.2020
 */
public class EvenNumberFile {
    /**
     * The main method.
     * @param args String.
     */
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                Integer currentInt = Integer.parseInt(line);
                System.out.printf("Number - %d is even - %b%n", currentInt, isEvenNumber(currentInt));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The method check is number even or not.
     * @param number passed number.
     * @return If even return true.
     */
    public static boolean isEvenNumber(Integer number) {
        return number % 2 == 0;
    }
}