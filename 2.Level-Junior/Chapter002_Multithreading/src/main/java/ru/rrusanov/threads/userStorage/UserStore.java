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
 * The UserStore.java class contain thread safe method transfer.
 */
@ThreadSafe
public class UserStore {
    /**
     * The field contain collection of users instance.
     */
    private Map<Integer, User> collection;
    /**
     * Default constructor.
     */
    public UserStore() {
        this.collection = new TreeMap<>();
    }
    /**
     * The method add user to collection.
     * @param user to add.
     * @return if user not present add and return true, otherwise false.
     */
    @GuardedBy("this")
    public synchronized boolean add(User user) {
        boolean result = false;
        if (!this.collection.containsKey(user.getId())) {
            this.collection.put(user.getId(), user);
            result = true;
        }
        return result;
    }
    /**
     * The method remove user from collection.
     * @param user to remove.
     * @return if user present when remove and return true, otherwise false.
     */
    @GuardedBy("this")
    public synchronized boolean delete(User user) {
        boolean result = false;
        if (this.collection.containsKey(user.getId())) {
            this.collection.remove(user.getId());
            result = true;
        }
        return result;
    }
    /**
     * The method find user in collection.
     * @param user to find.
     * @return if user present when return true, otherwise false.
     */
    @GuardedBy("this")
    public synchronized boolean find(User user) {
        return this.collection.containsKey(user.getId());
    }
    /**
     * The method transfer amount value from user to user.
     * @param fromId id user to take amount value.
     * @param toId id user to give amount value.
     * @param amount value.
     * @return if transfer successful true, otherwise false.
     */
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
