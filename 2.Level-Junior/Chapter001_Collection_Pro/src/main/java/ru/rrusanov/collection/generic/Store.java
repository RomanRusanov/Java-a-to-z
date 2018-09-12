package ru.rrusanov.collection.generic;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.05.2018
 *
 * Interface Store.
 * @param <T> generic type, that collection be contain.
 */
public interface Store<T extends Base> {
    /**
     * Method add model to collection.
     * @param model to add.
     */
    void add(T model);
    /**
     * Method replace new value model to existing id.
     * @param id unique to find model.
     * @param model new model to replace.
     * @return if operation success return true, otherwise false.
     */
    boolean replace(String id, T model);
    /**
     * Method find in collection model by id string.
     * @param id string to find.
     * @return if find return that model.
     */
    T findById(String id);
}