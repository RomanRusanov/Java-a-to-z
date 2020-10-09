package completablefuture;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Pattern;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 05.08.2020
 * email roman9628@gmail.com
 * The class read config from file from defined path. Config expect param=value.
 * Pairs config store at HashMap key-param, value-value.
 */
public class Config {
    /**
     * The field contain relative path to file and file name.
     */
    private final String path;
    /**
     * The filed contain collection that store config pairs.
     */
    private final Map<String, String> values = new HashMap<>();
    /**
     * The field contain compiled pattern to match string.
     */
    private  final Pattern pattern = Pattern.compile("^[^##].*(=).*$");

    /**
     * The default constructor.
     * @param path String with relative path and file name.
     */
    public Config(final String path) {
        this.path = path;
    }

    /**
     * The method read from file lines (param=value)
     * and put to collection values.
     */
    public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            in.lines().filter(this::isContain).forEach(str -> {
                                String[] twoStrings = str.split("=");
                                this.values.put(twoStrings[0], twoStrings[1]); }
            );
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

    /**
     * The method return value from collection by passed key.
     * @param key String key to find.
     * @return String value.
     */
    public String value(String key) {
        if (!this.values.containsKey(key)) {
            throw new UnsupportedOperationException("Don't impl this method yet!");
        }
        return this.values.get(key);
    }

    /**
     * The method override toString.
     * @return String.
     */
    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}