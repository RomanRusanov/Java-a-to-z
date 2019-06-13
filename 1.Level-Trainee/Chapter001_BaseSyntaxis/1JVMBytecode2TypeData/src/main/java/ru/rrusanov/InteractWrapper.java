package ru.rrusanov;

import java.util.Map;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 13.06.2019
 * The abstract class describe decorator methods.
 */
public abstract class InteractWrapper implements Interact {

    /**
     * The method take and save arguments from console.
     */
    @Override
    public void takeArgumentsFromConsole() {

    }

    /**
     * The method take and save user choose of action from menu.
     */
    @Override
    public void takeUserChoose() {

    }

    /**
     * The method execute action that user choose.
     */
    @Override
    public void executeAction() {

    }

    /**
     * The method print result to console.
     */
    @Override
    public void printResultToConsole() {

    }

    /**
     * The getter for field.
     * @return Map.
     */
    @Override
    public Map<String, Action> getActions() {
        return null;
    }

    /**
     * The setter for field.
     * @param value String(one symbol of action from menu).
     */
    @Override
    public void setUserChoose(String value) {

    }
}
