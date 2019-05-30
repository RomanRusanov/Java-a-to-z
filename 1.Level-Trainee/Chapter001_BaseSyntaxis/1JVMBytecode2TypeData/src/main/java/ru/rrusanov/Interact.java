package ru.rrusanov;

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
     * The method exucute action that user choose.
     */
    void executeAction();

    /**
     * The method print result to console.
     */
    void printResultToConsole();
}
