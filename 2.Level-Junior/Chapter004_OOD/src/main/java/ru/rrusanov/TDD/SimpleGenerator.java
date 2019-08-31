package ru.rrusanov.TDD;

import java.util.Iterator;
import java.util.LinkedList;
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
    private LinkedList<Pair> pairs = new LinkedList<>();
    /**
     * The field contain pair that be used.
     */
    private LinkedList<Pair> usedPairs = new LinkedList<>();
    /**
     * The field contain string what be target for the regexp.
     */
    private String inputString;
    /**
     * The field contain compiled pattern regex.
     */
    private final Pattern keys = Pattern.compile("\\$\\{\\w+}");

    /**
     * The method add par to collection.
     * @param pair Pair to add.
     */
    public void addPair(Pair pair) {
        this.pairs.add(pair);
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
        Matcher matcher = keys.matcher(this.inputString);
        while (matcher.find()) {
            String keyFind = inputString.substring(matcher.start() + 2, matcher.end() - 1);
            result = result.replace("${" + keyFind + "}", this.findByKey(keyFind).getValue());
            this.markPairAsUsed(keyFind);
        }
        if (this.usedPairs.size() != this.pairs.size()) {
            throw new IllegalStateException("Input string don't use all pairs in map!");
        }
        return result;
    }

    /**
     * The method put pair in collection what contain used pairs, if pair all ready present when skip.
     * @param key String.
     */
    public void markPairAsUsed(String key) {
        Iterator<Pair> iterator = this.usedPairs.iterator();
        boolean exist = false;
        while (iterator.hasNext()) {
            Pair currentPair = iterator.next();
            if (currentPair.getKey().equals(key)) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            Pair used = this.findByKey(key);
            this.usedPairs.add(used);
        }
    }

    /**
     * The method find pair by key value.
     * @param key String.
     * @return Pair.
     */
    public Pair findByKey(String key) {
        Pair result = new Pair();
        Iterator<Pair> iterator = this.pairs.iterator();
        while (iterator.hasNext()) {
            Pair currentPair = iterator.next();
            if (currentPair.getKey().equals(key)) {
                result = currentPair;
            }
        }
        if (result.getKey().equals("empty")) {
            throw new IllegalStateException("Key not found in collection!");
        }
        return result;
    }
}
