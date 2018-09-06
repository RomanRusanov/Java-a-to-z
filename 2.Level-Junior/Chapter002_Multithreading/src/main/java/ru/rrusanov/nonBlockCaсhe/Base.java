package ru.rrusanov.nonBlockCash;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 05.09.2018
 *
 * The class describe base model class.
 */
public class Base {

    private int id;

    private int version;

    private String name;

    @Override
    public int hashCode() {
        return 13 * (id + version + (name.hashCode() == 0 ? null 0 : 1));
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
