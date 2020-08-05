package bufferedreader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 04.08.2020
 * email roman9628@gmail.com
 * The class read from file string lines. If line corresponds regex,
 * when add that line to list.
 */
public class LogFilter {
    /**
     * The field contain regex to check lines.
     */
    private static String regex = "^.*\\s(404)\\s\\d+$";

    /**
     * The method read from file and check lines.
     * @param file Source file.
     * @return List with string match pattern regex.
     */
    public static List<String> filter(String file) {
        List<String> result = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            List<String> lines = new ArrayList<>();
            in.lines().forEach(lines::add);
            for (String line : lines) {
                if (isContain(line, regex)) {
                    result.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Main method.
     * @param args Stings args.
     */
    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }

    /**
     * The method compile regex, and chek string match pattern regex.
     * @param source String for check.
     * @param regex String pattern regex.
     * @return If match return true, otherwise false.
     */
    public static boolean isContain(String source, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(source).find();
    }
}