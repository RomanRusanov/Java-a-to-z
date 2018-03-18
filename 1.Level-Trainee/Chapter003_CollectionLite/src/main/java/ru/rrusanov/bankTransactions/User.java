package ru.rrusanov.bankTransactions;

import static java.util.Objects.hash;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.02.2018
 *
 * Class define User.
 */
public class User {
    /**
     * Name data of user.
     */
    private String name;
    /**
     * Passport id for user.
     */
    private String passport;
    /**
     * Default constructor.
     * @param name name of user.
     * @param passport unique string.
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Getter for name field.
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name field.
     * @param name String name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for passport field.
     * @return String passport.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Setter for passport field.
     * @param passport String passport.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Override equals method.
     * @param obj object to compare.
     * @return boolean if equal true, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        User temp = (User) obj;
        return temp.getName().equals(this.getName()) && temp.getPassport().equals(this.getPassport());
    }

    /**
     * Override hashCode() method.
     * @return int hash sum of all fields instance.
     */
    @Override
    public int hashCode() {
        return hash(this.name, this.passport);
    }
}
