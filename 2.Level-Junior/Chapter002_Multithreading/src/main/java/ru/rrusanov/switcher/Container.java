package ru.rrusanov.switcher;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 25.10.2018
 *
 * The class describe container that store string and append new int value to string.
 */
public class Container {
    /**
     * The field contain stored string.
     */
    private StringBuilder storedString = new StringBuilder();
    /**
     * The method add int value to stored string at the end of string.
     * @param value int to add.
     */
    public void add(int value) {
        this.storedString.append(String.valueOf(value));
    }
    /**
     * The getter method return field.
     * @return stored string.
     */
    public StringBuilder getStoredString() {
        return storedString;
    }

}
