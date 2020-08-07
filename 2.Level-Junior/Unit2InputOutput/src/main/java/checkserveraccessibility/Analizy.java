package checkserveraccessibility;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 07.08.2020
 * email roman9628@gmail.com
 * The class Analyze text log and find periods when server down and up.
 */
public class Analizy {
    /**
     * The field contain compiled pattern to match string.
     */
    private  final Pattern pattern = Pattern.compile("^(2|3|4|5)00\\s"
            + "[0-2][0-9]:[0-5][0-9]:[0-5][0-9]$");
    /**
     * The field contain collection with all periods then server is down.
     */
    private List<String> unavailablePeriods = new ArrayList<>();
    /**
     * The field contain flag then find start period server down.
     */
    private boolean startFind = false;
    /**
     * The field contain string in one period that find in source log.
     */
    StringBuilder startEndString = new StringBuilder();

    /**
     * The method star all process. Load. Save.
     * @param source String with server log
     *               ./2.Level-Junior/Unit2InputOutput/data/server.log
     * @param target String where save output file
     *               ./2.Level-Junior/Unit2InputOutput/data/unavailable.csv
     */
    public void unavailable(String source, String target) {
        load(source);
        save(this.unavailablePeriods, target);
    }

    /**
     * The method read from file lines (status time) example (200 10:56:01)
     * and then call processLine method to chek and store.
     * @param pathServerLog String whit source server log.
     */
    public void load(String pathServerLog) {
        try (BufferedReader in = new BufferedReader(new FileReader(pathServerLog))) {
            in.lines().filter(this::isContain).forEach(str -> {
                String[] twoStrings = str.split(" ");
                processLine(twoStrings);
                 });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The method check if log next string start with 400 or 500
     * then mark flag startFind and next string must
     * start with 200 or 300 status and after we store complete string.
     * @param twoStrings Array with two strings [0] status [1] time.
     */
    public void processLine(String[] twoStrings) {
        if (!startFind && (twoStrings[0].equals("400") || twoStrings[0].equals("500"))) {
            startEndString.append(twoStrings[1]).append(";");
            startFind = true;
        }
        if (startFind && (twoStrings[0].equals("200") || twoStrings[0].equals("300"))) {
            startEndString.append(twoStrings[1]);
            unavailablePeriods.add(startEndString.toString());
            startFind = false;
            startEndString.setLength(0);
        }
    }

    /**
     * The method save list to file on disk.
     * @param log Filtered list.
     * @param file File name.
     */
    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String s : log) {
                out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The method compile regex, and chek string match pattern regex.
     * @param source String for check.
     * @return If match return true, otherwise false.
     */
    public boolean isContain(String source) {
        return pattern.matcher(source).find();
    }
}