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
    /**
     * Default constructor.
     */
    public UserStore() {
        this.models = new SimpleArray<>();
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
        int index = this.models.findIndex((User) this.findById(id));
        this.models.set(index, (User) model);
        return true;
    }
    /**
     * Method find in collection model by id string.
     *
     * @param id string to find.
     * @return if find return that model.
     */
    @Override
    public Base findById(String id) throws UserNotFoundException {
        for(int i = 0; i < this.models.getSize(); i++) {
            Base base = (Base) this.models.get(i);
            if (base.getId().equals(id))
                return base;
        }
        throw new UserNotFoundException("User not present in collection!");
    }
}
