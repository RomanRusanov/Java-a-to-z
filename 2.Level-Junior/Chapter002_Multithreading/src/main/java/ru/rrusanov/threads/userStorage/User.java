package ru.rrusanov.threads.userStorage;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 14.08.2018
 *
 *
 */
public class User {

    private int id;

    private int amount;

    public User(int amount) {
        this.amount = amount;
        this.id = (int) System.currentTimeMillis() / (amount != 0 ? amount : 1);
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        User userObj = (User) obj;
        return this.amount == userObj.amount && this.id == userObj.id;
    }

    @Override
    public int hashCode() {
        return 31 * (this.id + this.amount);
    }
}
