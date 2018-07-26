package ru.rrusanov.store;
import java.util.ArrayList;
import java.util.List;
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
    private List<User> added;
    /**
     * The field contain Users that be changed.
     */
    private List<User> changed;
    /**
     * The field contain Users that be removed.
     */
    private List<User> removed;
    /**
     * The default constructor.
     */
    public Info() {
        this.added = new ArrayList<>();
        this.changed = new ArrayList<>();
        this.removed = new ArrayList<>();
    }
    /**
     * The method add user to instance added list.
     * @param user was add.
     */
    public void addedAdd(User user) {
        this.added.add(user);
    }
    /**
     * The method add user to instance changed list.
     * @param user was changed.
     */
    public void changedAdd(User user) {
        this.changed.add(user);
    }
    /**
     * The method add user to instance removed list.
     * @param user was removed.
     */
    public void removedAdd(User user) {
        this.removed.add(user);
    }
    /**
     * The getter for added list.
     * @return array list with added Users.
     */
    public List<User> getAdded() {
        return this.added;
    }
    /**
     * The getter for changed list.
     * @return array list with changed Users.
     */
    public List<User> getChanged() {
        return this.changed;
    }
    /**
     * The getter for removed list.
     * @return array list with removed Users.
     */
    public List<User> getRemoved() {
        return this.removed;
    }
}
