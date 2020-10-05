package executorservice;

import java.util.Objects;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 05.10.2020
 * email roman9628@gmail.com
 * The class describe model User.
 */
public class User {
    /**
     * The field contain name.
     */
    private String userName;
    /**
     * The field contain email field.
     */
    private String email;

    /**
     * The default constructor.
     * @param userName Sting user name.
     * @param email String email of user.
     */
    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    /**
     * The getter for field.
     * @return User name.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * The setter for field.
     * @param userName String User name.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * The getter for field.
     * @return User eamil.
     */
    public String getEmail() {
        return email;
    }

    /**
     * The setter for field.
     * @param email String User eamil.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * The method compare two models.
     * @param o Model to compare.
     * @return If equals all fields return true, otherwise flase.
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
        return userName.equals(user.userName)
                && email.equals(user.email);
    }

    /**
     * The method return hashcode.
     * @return int value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(userName, email);
    }
}