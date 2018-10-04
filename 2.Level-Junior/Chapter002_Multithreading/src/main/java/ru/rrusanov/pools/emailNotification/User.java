package ru.rrusanov.pools.emailNotification;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 14.08.2018
 *
 * The User.java class explain user state.
 */
public class User {
    /**
     * The field contain name value.
     */
    private String name;
    /**
     * The field contain email address of user.
     */
    private String email;
    /**
     * The default constructor.
     * @param name value.
     * @param email value.
     */
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    /**
     * The method getter for name field.
     * @return id.
     */
    public String getName() {
        return this.name;
    }
    /**
     * The method getter for email field.
     * @return amount value.
     */
    public String getEmail() {
        return this.email;
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
        return this.name.equals(userObj.name) && this.email.equals(userObj.email);
    }
    /**
     * The method return hash value for user instance.
     * @return int value.
     */
    @Override
    public int hashCode() {
        return 31 * (this.name.hashCode() + this.email.hashCode());
    }
}
