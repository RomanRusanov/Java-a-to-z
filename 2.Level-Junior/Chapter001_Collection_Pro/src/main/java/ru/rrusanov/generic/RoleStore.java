package ru.rrusanov.generic;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 20.05.2018
 *
 * RoleStore class.
 * @param <Role> type, that collection be contain.
 */
public class RoleStore<Role> implements Store {

    /**
     * Method add model to collection.
     *
     * @param model to add.
     */
    @Override
    public void add(Base model) {

    }

    /**
     * Method replace new value model to existing id.
     *
     * @param id    unique to find model.
     * @param model new model to replace.
     * @return if operation success return true, otherwise false.
     */
    @Override
    public boolean replace(String id, Base model) {
        return false;
    }

    /**
     * Method find in collection model by id string.
     *
     * @param id string to find.
     * @return if find return that model.
     */
    @Override
    public Base findById(String id) {
        return null;
    }
}
