package limitfiledownload;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 11.08.2020
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
     * The method get value by passed key string.
     * @param key String - key.
     * @return String value.
     */
    public String get(String key) {
        return values.get(key);
    }

    /**
     * The method check that two params passed and parse them.
     * We cut of first symbol in each params after delimit string on strings
     * first string - key, second string value.
     * @param args array strings with params and value.
     */
    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("First parameter not found!");
        }
        if (args.length == 1) {
            throw new IllegalArgumentException("Second parameter not found!");
        }
        for (String arg : args) {
            arg = arg.substring(1);
            String[] param = arg.split("(=)");
            this.values.put(param[0], param[1]);
        }
    }

    /**
     * The method take array with params, and return instance with complete process.
     * @param args Array Strings. Source data.
     * @return Instance with complete parsed that store in collection.
     */
    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }
}