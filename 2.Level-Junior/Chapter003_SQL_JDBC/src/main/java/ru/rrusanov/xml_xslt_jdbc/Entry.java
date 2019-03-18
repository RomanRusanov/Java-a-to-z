package ru.rrusanov.xml_xslt_jdbc;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
/**
 * Class describe entry.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 06.03.19
 */
@XmlRootElement
public class Entry {
    /**
     * The field contain entry value.
     */
    private int field;

    /**
     * The constructor create entry with passed value.
     * @param field value.
     */
    public Entry(int field) {
        this.field = field;
    }

    /**
     * The default constructor.
     */
    public Entry() {
    }

    /**
     * Getter for field.
     * @return value to get.
     */
    public int getField() {
        return field;
    }

    /**
     * Setter for field.
     * @param field value.
     */
    @XmlElement
    public void setField(int field) {
        this.field = field;
    }

    /**
     * The method compare to entry obj.
     * @param o obj to compare.
     * @return if equals return true, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entry entry = (Entry) o;
        return field == entry.field;
    }

    /**
     * The method return hashcode of entry.
     * @return int hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(field);
    }
}