package ru.rrusanov.threads.userStorage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 14.08.2018
 *
 *
 */
@ThreadSafe
public class UserStore {

    private Map<Integer, User> collection;

    public UserStore() {
        this.collection = new TreeMap<>();
    }

    public boolean add(User user) {
        boolean result = false;
        if (!this.collection.containsKey(user.getId())) {
            this.collection.put(user.getId(), user);
            result = true;
        }
        return result;
    }

    public boolean update(User user) {
        boolean result = false;
        return result;
    }

    public boolean delete(User user) {
        boolean result = false;
        if (!this.collection.containsKey(user.getId())) {
            this.collection.remove(user.getId());
            result = true;
        }
        return result;
    }

    @GuardedBy("this")
    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        User from = this.collection.get(fromId);
        User to = this.collection.get(toId);
        if (from != null && to != null && from.getAmount() >= amount) {
            from.setAmount(from.getAmount() - amount);
            to.setAmount(to.getAmount() + amount);
            result = true;
        }
        return result;
    }
}
