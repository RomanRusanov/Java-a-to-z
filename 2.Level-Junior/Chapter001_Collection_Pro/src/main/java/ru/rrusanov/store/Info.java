package ru.rrusanov.store;
import java.util.ArrayList;
import java.util.List;
import ru.rrusanov.store.Store.User;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 26.07.2018
 *
 *
 */
public class Info {

    private List<User> added;

    private List<User> changed;

    private List<User> removed;

    public Info() {
        this.added = new ArrayList<>();
        this.changed = new ArrayList<>();
        this.removed = new ArrayList<>();
    }

    public void addedAdd(User user) {
        this.added.add(user);
    }

    public void changedAdd(User user) {
        this.changed.add(user);
    }

    public void removedAdd(User user) {
        this.removed.add(user);
    }
}
