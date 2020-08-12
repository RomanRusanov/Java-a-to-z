package arhivateproject;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 11.08.2020
 * email roman9628@gmail.com
 * The class chek args passed in program from console.
 * java -jar pack.jar -d=c:\project\job4j\ -e=class -o=project.zip
 * -d directory - которую мы хотим архивировать
 * -e exclude - исключить файлы *.xml
 * -o output - во что мы архивируем.
 */
public class ArgZip {
    /**
     * The field contain all args.
     */
    private final String[] args;
    /**
     * The field contain line separator symbol.
     */
    private static final String NEW_LINE = System.lineSeparator();
    /**
     * The field contain regex pattern to check each args.
     */
    private  final Pattern correctArg = Pattern.compile("^-(d|e|o)=.*$");
    /**
     * The field contain collection that store all pairs params.
     */
    private final Map<String, String> params = new HashMap<>();

    /**
     * The default constructor.
     * @param args Strings args.
     */
    public ArgZip(String[] args) {
        this.args = args;
        this.parse(this.args);
    }

    /**
     * The method check all args are correct an all present.
     * @return If args not correct"-param=value", and
     * less three args then return false, otherwise true.
     */
    public boolean valid() {
        if (args.length != 3) {
            throw new IllegalArgumentException("Too run necessary three params!" + NEW_LINE
                    + "java -jar pack.jar -d=c:\\project\\job4j\\ -e=class -o=project.zip" + NEW_LINE
                    + "-d root directory to start" + NEW_LINE
                    + "-e exclude files with extension class" + NEW_LINE
                    + "-o output file");
        }
        for (String arg : this.args) {
            if (!correctArg.matcher(arg).find()) {
                throw new IllegalArgumentException("Parameter not correct! " + NEW_LINE
                        + "Correct: -(d|e|o)=value");
            }
        }
        return true;
    }

    /**
     * The method check that two params passed and parse them.
     * We cut of first symbol in each params after delimit string on strings
     * first string - key, second string value.
     * @param args array strings with params and value.
     */
    public void parse(String[] args) {
        if (this.valid()) {
            for (String arg : args) {
                arg = arg.substring(1);
                String[] param = arg.split("(=)");
                this.params.put(param[0], param[1]);
            }
        }
    }

    /**
     * The getter for directory param.
     * @return String with root work folder.
     */
    public String directory() {
        return this.params.get("d");
    }

    /**
     * The getter for exclude param.
     * @return String with extension to exclude from list files to archive.
     */
    public String exclude() {
        return this.params.get("e");
    }

    /**
     * The getter for output param.
     * @return String with archive file name(zip).
     */
    public String output() {
        return this.params.get("o");
    }
}