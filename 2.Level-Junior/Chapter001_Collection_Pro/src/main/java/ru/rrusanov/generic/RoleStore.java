package ru.rrusanov.generic;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 20.05.2018
 *
 * Collection Role class.
 */
public class RoleStore extends AbstractStore<Role> implements Store<Role> {
    /**
     * Method add model to collection.
     *
     * @param model to add.
     */
    @Override
    public void add(Role model) {
        super.add(model);
    }
    /**
     * Method replace new value model to existing id.
     *
     * @param id    unique to find model.
     * @param model new model to replace.
     * @return if operation success return true, otherwise false.
     */
    @Override
    public boolean replace(String id, Role model) {
        return super.replace(id, model);
    }
    /**
     * Method find in collection model by id string.
     *
     * @param id string to find.
     * @return if find return that model.
     */
    @Override
    public Role findById(String id) throws NotFoundException {
        return super.findById(id);
    }

}
