package ru.rrusanov;

import java.util.Map;

/**
 * The interface describe what methods must be implemented.
 */
public interface Interact {
    /**
     * The method print menu to console.
     */
    void writeToConsoleMenu();

    /**
     * The method take and save arguments from console.
     */
    void takeArgumentsFromConsole();

    /**
     * The method take and save user choose of action from menu.
     */
    void takeUserChoose();

    /**
     * The method execute action that user choose.
     * @param action action that user choose.
     */
    void executeAction(String action);

    /**
     * The method print result to console.
     */
    void printResultToConsole();

    /**
     * The getter for field.
     * @return Map.
     */
    Map<String, Action> getActions();

    /**
     * The setter for field.
     * @param value String(one symbol of action from menu).
     */
    void setUserChoose(String value);
}
