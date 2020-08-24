package findfiles;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 22.08.2020
 * email roman9628@gmail.com
 * The class parse parameters passed as arguments and put them to collection.
 * Key - name param
 * Value - value for param.
 */
public class ArgsName {
    /**
     * The field contain collection that store all pairs params.
     */
    private final Map<String, String> values = new HashMap<>();
    /**
     * The field contain symbol for new line.
     */
    private String endLine = System.getProperty("line.separator");
    /**
     * The field contain patter for key value.
     */
    private Pattern key = Pattern.compile("^[-](.)");
    /**
     * The field contain patter for not key value.
     */
    private Pattern value = Pattern.compile("(^[^-].*)");

    /**
     * The method get value by passed key string.
     * @param key String - key.
     * @return String value.
     */
    public String get(String key) {
        return values.get(key);
    }

    /**
     * The method check that seven params passed and parse them.
     * We cut of first symbol in each params after delimit string on strings
     * first string - key, second string value.
     * @param args array strings with params and value.
     */
    private void parse(String[] args) {
        if (args.length != 7) {
            throw new IllegalArgumentException("Error! "
                    + "parameters not found!" + endLine
                    + "EXAMPLE: -jar find.jar -d c:\\ -n *.txt -m"
                    + " -o log.txt" + endLine
                    + "-d - directory to start find." + endLine
                    + "-n - file name:"
                    + "-m - mask, or -f - full name equals,"
                    + " or -r - regex." + endLine
                    + "-o - result file."
            );
        }
        String key = "";
        String value = "";
        boolean keyFind = false;
        boolean valueFind = false;
        for (String arg : args) {
            Matcher matcherKey = this.key.matcher(arg);
            Matcher matcherValue = this.value.matcher(arg);
            while (matcherKey.find()) {
                if (keyFind && !valueFind) {
                    this.values.put(key, "Empty Value");
                    keyFind = false;
                }
                key = matcherKey.group(1);
                keyFind = true;
            }
            while (matcherValue.find()) {
                value = matcherValue.group(1);
                valueFind = true;
            }
            if (keyFind && valueFind) {
                this.values.put(key, value);
                keyFind = false;
                valueFind = false;
            }
        }
    }

    /**
     * The method take array with params, and return instance with stored params.
     * @param args Array Strings. Source data.
     * @return Instance with complete parsed that store in collection.
     */
    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    /**
     * The method find first key with empty value.
     * @return String key value.
     */
    public String findKeyEmptyValue() {
        Optional<String> optionalEmpty = this.values.entrySet().stream()
                .filter(e -> "Empty Value".equals(e.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();
        return optionalEmpty.orElse("key not find");
    }
}