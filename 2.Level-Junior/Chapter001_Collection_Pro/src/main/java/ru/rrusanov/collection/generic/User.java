package ru.rrusanov.collection.generic;
import java.util.Objects;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.05.2018
 *
 * User class.
 */
public class User extends Base {
    /**
     * Default constructor.
     *
     * @param id unique id.
     */
    User(String id) {
        super(id);
    }
    /**
     * Method Getter return id.
     * @return id string.
     */
    @Override
    public String getId() {
        return super.getId();
    }
    /**
     * The method compare User object by field id.
     * @param obj object to compare.
     * @return boolean result.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return user.getId().equals(this.getId());
    }
    /**
     * The method return hash of that object.
     * @return int hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
