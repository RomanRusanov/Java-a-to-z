package ru.rrusanov.store;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.rrusanov.store.Store.User;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 26.07.2018
 *
 * The class contain list with users that be added, changed or removed.
 */
public class Info {
    /**
     * The field contain Users that be added.
     */
    private Map<Integer, User> added;
    /**
     * The field contain Users that be changed.
     */
    private Map<Integer, User> changed;
    /**
     * The field contain Users that be removed.
     */
    private Map<Integer, User> removed;
    /**
     * The default constructor.
     */
    public Info() {
        this.added = new HashMap<>();
        this.changed = new HashMap<>();
        this.removed = new HashMap<>();
    }
    /**
     * The method add user to instance added list.
     * @param user was add.
     */
    public void addedAdd(User user) {
        this.added.put(user.getId(), user);
    }
    /**
     * The method add user to instance changed list.
     * @param user was changed.
     */
    public void changedAdd(User user) {
        this.added.put(user.getId(), user);
    }
    /**
     * The method add user to instance removed list.
     * @param user was removed.
     */
    public void removedAdd(User user) {
        this.added.put(user.getId(), user);
    }
    /**
     * The getter for added list.
     * @return array list with added Users.
     */
    public Map<Integer, User> getAdded() {
        return this.added;
    }
    /**
     * The getter for changed list.
     * @return array list with changed Users.
     */
    public Map<Integer, User> getChanged() {
        return this.changed;
    }
    /**
     * The getter for removed list.
     * @return array list with removed Users.
     */
    public Map<Integer, User> getRemoved() {
        return this.removed;
    }
}
