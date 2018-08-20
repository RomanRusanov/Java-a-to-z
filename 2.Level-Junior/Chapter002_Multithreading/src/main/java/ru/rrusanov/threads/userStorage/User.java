package ru.rrusanov.threads.userStorage;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 14.08.2018
 *
 * The User.java class explain user state.
 */
public class User {
    /**
     * The field contain unique id value.
     */
    private int id;
    /**
     * The field contain amount for user.
     */
    private int amount;
    /**
     * The default constructor.
     * @param amount value.
     */
    public User(int amount) {
        this.amount = amount;
        this.id = (int) System.currentTimeMillis() / (amount != 0 ? amount : 1);
    }
    /**
     * The method getter for id field.
     * @return id.
     */
    public int getId() {
        return id;
    }
    /**
     * The method getter for amount field.
     * @return amount value.
     */
    public int getAmount() {
        return amount;
    }
    /**
     * The method setter for id field.
     * @param id value.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * The method setter for amount field.
     * @param amount value.
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
    /**
     * The method compare to user object.
     * @param obj object to compare.
     * @return if equals return true, otherwise false.
     */
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
    /**
     * The method return hash value for user instance.
     * @return int value.
     */
    @Override
    public int hashCode() {
        return 31 * (this.id + this.amount);
    }
}
