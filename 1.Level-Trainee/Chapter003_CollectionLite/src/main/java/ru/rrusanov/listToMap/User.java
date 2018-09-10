package ru.rrusanov.listToMap;

import java.util.Random;

/**
 * Class contain state of user: id, name, city.
 */
public class User {
    /**
     * Id of user.
     */
    private int id;
    /**
     * Name of user.
     */
    private String name;
    /**
     * City where user locate.
     */
    private String city;
    /**
     * Default constructor.
     * @param name Name of user.
     * @param city Location of user.
     */
    public User(String name, String city) {
        this.name = name;
        this.city = city;
        this.id = generateId();
    }
    /**
     * Generate random id.
     * @return int id.
     */
    public int generateId() {
        Random random = new Random();
        return random.nextInt(100000);
    }
    /**
     * Getter for id field.
     * @return Id of user.
     */
    public int getId() {
        return this.id;
    }
    /**
     * Getter for name field.
     * @return Id of user.
     */
    public String getName() {
        return name;
    }
    /**
     * Getter for city field.
     * @return Id of user.
     */
    public String getCity() {
        return city;
    }
}
