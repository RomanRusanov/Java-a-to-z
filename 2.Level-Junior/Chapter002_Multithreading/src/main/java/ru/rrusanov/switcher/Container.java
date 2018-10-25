package ru.rrusanov.switcher;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 25.10.2018
 * <p>
 * The class .
 */
public class Container {

    private StringBuilder storedString = new StringBuilder();

    public void add(int value) {
        this.storedString.append(String.valueOf(value));
    }

    public StringBuilder getStoredString() {
        return storedString;
    }
}
