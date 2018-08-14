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
    @GuardedBy("method-add()")
    public synchronized boolean add(User user) {
        boolean result = false;
        if (!this.collection.containsKey(user.getId())) {
            this.collection.put(user.getId(), user);
            result = true;
        }
        return result;
    }
}
