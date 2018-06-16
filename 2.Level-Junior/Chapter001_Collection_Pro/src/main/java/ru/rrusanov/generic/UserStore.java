package ru.rrusanov.generic;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.05.2018
 *
 * Collection User class.
 */
public class UserStore extends AbstractStore<User> implements Store<User> {
    /**
     * Default constructor.
     */
    public UserStore() {
        super();
    }
    /**
     * Method add model to collection.
     *
     * @param model to add.
     */
    @Override
    public void add(User model) {
        this.models.add(model);
    }
    /**
     * Method replace new value model to existing id.
     *
     * @param id    unique to find model.
     * @param model new model to replace.
     * @return if operation success return true, otherwise false.
     */
    @Override
    public boolean replace(String id, User model) {
        return replace(id, model);
    }
    /**
     * Method find in collection model by id string.
     *
     * @param id string to find.
     * @return if find return that model.
     */
    @Override
    public User findById(String id) throws NotFoundException {
        return (User) super.findById(id);
    }
}
