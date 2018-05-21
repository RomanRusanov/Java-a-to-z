package ru.rrusanov.generic;

import ru.rrusanov.simpleArrayT.SimpleArray;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.05.2018
 *
 * UserStore class.
 * @param <User> type must be User, that collection be contain.
 */
public class UserStore<User> implements Store {
    /**
     * The field contains all models.
     */
    private SimpleArray<User> models;

    public UserStore() {
        this.models = new SimpleArray<User>();
    }

    /**
     * Method add model to collection.
     *
     * @param model to add.
     */
    @Override
    public void add(Base model) {
        this.models.add((User) model);
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
        Base result;
        for (User item : models) {
            if(item) 
        }
    }
}
