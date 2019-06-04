package ru.rrusanov;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 30.05.2019
 * The functional interface provide add to map reference on method.
 */
@FunctionalInterface
public interface Action {
    /**
     * The method execute action on get value from map(actions).
     */
    void action();
}
