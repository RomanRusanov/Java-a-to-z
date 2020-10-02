package nonblockingcache;

import java.util.Objects;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 01.10.2020
 * email roman9628@gmail.com
 * The class describe model that cache store.
 */
class Base {
    /**
     * The id unique value. Key for map.
     */
    private int id;
    /**
     * The field contain count version. Counter increment +1 when model update.
     */
    private int version;
    /**
     * The field contain string that store model base.
     */
    private String data;

    /**
     * The default constructor.
     * @param id Model id.
     * @param version Version.
     * @param data Stored data.
     */
    Base(int id, int version, String data) {
        this.id = id;
        this.version = version;
        this.data = data;
    }

    /**
     * The getter for field.
     * @return Id.
     */
    public int getId() {
        return id;
    }

    /**
     * The setter for field.
     * @param id Int value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * The getter for field.
     * @return Version.
     */
    public int getVersion() {
        return version;
    }

    /**
     * The setter for field.
     * @param version Int value.
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * The getter for field.
     * @return Data.
     */
    public String getData() {
        return data;
    }

    /**
     * The setter for field.
     * @param data String value.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * The method compare models.
     * @param o Passed object.
     * @return If equals by all fields then return true, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Base base = (Base) o;
        return id == base.id
                && version == base.version
                && Objects.equals(data, base.data);
    }

    /**
     * The method generate hashcode.
     * @return Hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, version, data);
    }

    /**
     * The method override correct string representation.
     * @return String.
     */
    @Override
    public String toString() {
        return "Base{"
                + "id=" + id
                + ", version=" + version
                + ", data='" + data + '\''
                + '}';
    }
}