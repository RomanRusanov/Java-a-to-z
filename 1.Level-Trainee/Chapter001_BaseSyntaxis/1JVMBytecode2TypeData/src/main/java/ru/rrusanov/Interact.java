package ru.rrusanov;

public interface Interact {
    /**
     * The field contain instance of Calculator class.
     */
    Calculator calculator = null;
    /**
     * The field contain value that user choose.
     */
    Integer userChoose = -1;
    /**
     * The field contain instance of ConsoleInput class.
     */
    ConsoleInput consoleInput = null;

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
