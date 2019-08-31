package ru.rrusanov.TDD;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 4.08.2019
 *
 * The class use RegExp check input sting. If string contain key values that store in map, when replace them.
 * If map not contain keys in map, then throw IllegalStateException,
 * if input string contain not used keys, then throw IllegalStateException.
 */
public class SimpleGenerator {
    /**
     * The field contain pair to process.
     */
    private HashMap<String, String> pairs = new HashMap<>();
    /**
     * The field contain pair that be used.
     */
    private HashMap<String, String> usedPairs = new HashMap<>();
    /**
     * The field contain string what be target for the regexp.
     */
    private String inputString;
    /**
     * The field contain compiled pattern regex.
     */
    private final Pattern KEYS = Pattern.compile("\\$\\{\\w+}");

    /**
     * The method add par to collection.
     * @param key String key.
     * @param value String value.
     */
    public void addPair(String key, String value) {
        this.pairs.put(key, value);
    }

    /**
     * The method Setter for filed.
     * @param inputString String.
     */
    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    /**
     * The method main process find in input string keys values and replace them.
     * @return processed string.
     * @throws IllegalStateException If map not contain keys in map, then throw IllegalStateException,
     * if input string contain not used keys, then throw IllegalStateException.
     */
    public String process() throws IllegalStateException {
        String result = inputString;
        Matcher matcher = KEYS.matcher(this.inputString);
        while (matcher.find()) {
            String keyFind = inputString.substring(matcher.start() + 2, matcher.end() - 1);
            result = result.replace("${" + keyFind + "}", this.checkKey(keyFind));
            this.usedPairs.put(keyFind, this.pairs.get(keyFind));
        }
        if (this.usedPairs.size() != this.pairs.size()) {
            throw new IllegalStateException("Input string don't use all pairs in map!");
        }
        return result;
    }

    /**
     * The method check if key exist in collection, then return it value, otherwise throw exception.
     * @param key String key.
     * @return String value.
     * @throws IllegalStateException If map not contain keys in map, then throw IllegalStateException.
     */
    public String checkKey(String key) throws IllegalStateException{
        if (!this.pairs.containsKey(key)) {
            throw new IllegalStateException("Key not fount in map. Pair not exist!");
        }
        return this.pairs.get(key);
    }
}
