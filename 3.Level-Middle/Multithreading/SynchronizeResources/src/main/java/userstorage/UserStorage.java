package userstorage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.HashMap;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 22.09.2020
 * email roman9628@gmail.com
 * The class describe structure that storage User instance.
 */
@ThreadSafe
public class UserStorage {
    /**
     * The class TreadSafe monitor instance of class.
     */
    @GuardedBy("this")

    private HashMap<Integer, User> storage = new HashMap<>();

    /**
     * The method add user to collection.
     * @param user Instance user.
     * @return True if user added, otherwise false.
     */
    public synchronized boolean add(User user) {
        if (this.storage.containsKey(user.getId())) {
            return false;
        }
        this.storage.put(user.getId(), user);
        return true;
    }

    /**
     * The method update user to collection.
     * @param user User for update.
     * @return True if user update, otherwise false.
     */
    public synchronized boolean update(User user) {
        if (this.storage.containsKey(user.getId())) {
            this.storage.replace(user.getId(), user);
            return true;
        }
        return false;
    }

    /**
     * The method delete user in collection.
     * @param user User for delete.
     * @return True if user delete, otherwise false.
     */
    public synchronized boolean delete(User user) {
        if (this.storage.containsKey(user.getId())) {
            this.storage.remove(user.getId());
            return true;
        }
        return false;
    }

    /**
     * The method check contain user in storage.
     * @param user User instance.
     * @return If user exist return true, otherwise false.
     */
    public synchronized boolean isUserExist(User user) {
        return this.storage.containsValue(user);
    }

    /**
     * The method transfer amount value from user to user.
     * @param fromId User id source.
     * @param toId User id destination.
     * @param amount Amount value to transfer.
     * @return If amount moved then return true, otherwise false.
     */
    public synchronized boolean transfer(int fromId, int toId, int amount) {
        User userFrom = this.storage.get(fromId);
        User userTo = this.storage.get(toId);
        if (userFrom == null || userTo == null || userFrom.getAmount() < amount) {
            return false;
        }
        userFrom.setAmount(userFrom.getAmount() - amount);
        userTo.setAmount(userTo.getAmount() + amount);
        return true;
    }
}