package ru.rrusanov.TDD;

import java.util.Objects;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 31/08/2019
 * The class describe Pair key and value.
 */
public class Pair {
    /**
     * The field contain key.
     */
    private String key;
    /**
     * The field contain value.
     */
    private String value;

    /**
     * Default constructor.
     */
    public Pair() {
        this.key = "empty";
        this.value = "empty";
    }

    /**
     * Constructor create pair by using passed values.
     * @param key String
     * @param value String.
     */
    public Pair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Method override equals, provide correct comparison.
     * @param o passed pair to compare.
     * @return boolean. If pair have equals filed values then return true, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) o;
        return key.equals(pair.key)
                && value.equals(pair.value);
    }

    /**
     * Method compute the hash value take for base value from class fields.
     * @return int hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    /**
     * Method override toString method for correct output.
     * @return Sting with fields values.
     */
    @Override
    public String toString() {
        return "Pair{key=" + key + ", value=" + value + "}";
    }

    /**
     * The getter for field.
     * @return String.
     */
    public String getKey() {
        return key;
    }

    /**
     * The setter for field.
     * @param key String.
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * The getter for field.
     * @return String.
     */
    public String getValue() {
        return value;
    }

    /**
     * The setter for field.
     * @param value String.
     */
    public void setValue(String value) {
        this.value = value;
    }
}
