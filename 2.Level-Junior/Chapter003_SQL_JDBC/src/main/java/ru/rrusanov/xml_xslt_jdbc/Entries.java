package ru.rrusanov.xml_xslt_jdbc;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
/**
 * Class describe entries.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 06.03.19
 */
@XmlRootElement
public class Entries {
    /**
     * The field contain entries.
     */
    private List<Entry> entry;

    /**
     * Constructor add entries.
     * @param entry collection to store.
     */
    public Entries(List<Entry> entry) {
        this.entry = entry;
    }

    /**
     * Default constructor.
     */
    public Entries() {
        this.entry = null;
    }

    /**
     * Getter for field.
     * @return collection of entries.
     */
    public List<Entry> getEntry() {
        return entry;
    }

    /**
     * Setter for field.
     * @param entry collection of entries.
     */
    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }
}