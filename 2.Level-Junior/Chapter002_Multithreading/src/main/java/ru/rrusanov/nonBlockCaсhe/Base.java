package ru.rrusanov.nonBlockCaсhe;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 05.09.2018
 *
 * The class describe base model class.
 */
public class Base {

    private int id;

    private volatile int version;

    private String name;

    public Base(String name) {
        this.id = this.name.hashCode() + this.name.length();
        this.version = 0;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 13 * (id + version + name.hashCode());
    }

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
