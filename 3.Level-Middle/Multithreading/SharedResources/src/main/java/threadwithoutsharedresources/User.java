package threadwithoutsharedresources;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.09.2020
 * email roman9628@gmail.com
 * The class describe User instance.
 */
public class User {
    /**
     * The field contain unique id.
     */
    private int id;
    /**
     * The filed contain string name.
     */
    private String name;

    /**
     * The method create new instance of User.
     * @param name Name string.
     * @return Instance class.
     */
    public static User of(String name) {
        User user = new User();
        user.name = name;
        return user;
    }

    /**
     * The getter.
     * @return Int value.
     */
    public int getId() {
        return id;
    }

    /**
     * The setter.
     * @param id Int value.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * The getter.
     * @return Name.
     */
    public String getName() {
        return name;
    }

    /**
     * The setter.
     * @param name String.
     */
    public void setName(String name) {
        this.name = name;
    }
}