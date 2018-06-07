package ru.rrusanov.generic;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.05.2018
 *
 * Base class.
 */
public abstract class Base {
    /**
     * The ID field.
     */
    private final String id;
    /**
     * Default constructor.
     * @param id unique id.
     */
    protected Base(String id) {
        this.id = id;
    }
    /**
     * The method Getter return id.
     * @return id string.
     */
    public String getId() {
        return id;
    }
}