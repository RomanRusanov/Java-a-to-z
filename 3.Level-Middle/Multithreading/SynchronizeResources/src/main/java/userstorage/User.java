package userstorage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Objects;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 22.09.2020
 * email roman9628@gmail.com
 * The class describe User.
 */
@ThreadSafe
public class User {
    /**
     * The class TreadSafe monitor instance of class.
     */
    @GuardedBy("this")
    /**
     * The field contain user id unique value.
     */
    private volatile int id;
    /**
     * The field contain user amount.
     */
    private volatile int amount;

    /**
     * The default constructor.
     * @param id User id.
     * @param amount int value.
     */
    public User(int id, int amount) {
        this.amount = amount;
        this.id = id;
    }

    /**
     * The getter for field.
     * @return int id value.
     */
    public synchronized int getId() {
        return id;
    }
    /**
     * The getter for field.
     * @return Amount value.
     */
    public synchronized int getAmount() {
        return amount;
    }

    /**
     * The setter for field.
     * @param amount int value.
     */
    public synchronized void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * The method check equals two instance.
     * @param o passed object.
     * @return If equals return true, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id
                && amount == user.amount;
    }

    /**
     * The method generate hashcode.
     * @return int value hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }
}