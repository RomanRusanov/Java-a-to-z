package ru.rrusanov.generic;
import ru.rrusanov.simpleArrayT.SimpleArray;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 07.06.2018
 *
 * Universal store class.
 */
abstract class AbstractStore<T> implements Store {
    /**
     * Field contain collection.
     */
    SimpleArray<T> models = new SimpleArray<>();
    /**
     * Method add model to collection.
     *
     * @param model to add.
     */
    void add(T model) {
        this.models.add(model);
    }
    /**
     * The method replace new value model to existing id.
     *
     * @param id    unique to find model.
     * @param model new model to replace.
     * @return if operation success return true, otherwise false.
     */
    boolean replace(String id, T model) {
        int index = this.models.findIndex((T) this.findById(id));
        this.models.set(index, model);
        return true;
    }
    /**
     * The method find in collection model by id string.
     *
     * @param id string to find.
     * @return if find return that model.
     */
    public Base findById(String id) throws UserNotFoundException, RoleNotFoundException {
        for(int i = 0; i < this.models.getSize(); i++) {
            Base base = (Base) this.models.get(i);
            if (base.getId().equals(id))
                return base;
        }
        if (this.models.get(0).getClass().getName().equals("User"))
            throw new UserNotFoundException("User not present in collection!");
            throw new RoleNotFoundException("Role not present in collection!");
    }
}