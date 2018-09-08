package ru.rrusanov.nonBlockCache;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 05.09.2018
 *
 * The class describe base model class.
 */
public class Base {
    /**
     * The field contain id model.
     */
    private int id;
    /**
     * The field contain version model.
     */
    private volatile int version;
    /**
     * The field contain name model.
     */
    private String name;
    /**
     * The default constructor.
     * @param name model.
     */
    public Base(String name) {
        this.version = 0;
        this.name = name;
        this.id = this.name.hashCode() + this.name.length();
    }
    /**
     * The getter for id field.
     * @return int value;
     */
    public int getId() {
        return id;
    }
    /**
     * The getter for version field.
     * @return int value;
     */
    public int getVersion() {
        return version;
    }
    /**
     * The getter for name field.
     * @return String value;
     */
    public String getName() {
        return name;
    }
    /**
     * The setter for id field.
     * @param id int value.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * The setter for version field.
     * @param version int value.
     */
    public void setVersion(int version) {
        this.version = version;
    }
    /**
     * The setter for name field.
     * @param name String value.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * The method return hashcode value.
     * @return int value.
     */
    @Override
    public int hashCode() {
        return 13 * (id + version + name.hashCode());
    }
    /**
     * The method compare to object of base.
     * @param obj object to compare with this.
     * @return if equals return true, otherwise false;
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Base objBase = (Base) obj;
        return this.id == objBase.id && this.version == objBase.version && this.name.equals(objBase.name);
    }
}
