package ru.rrusanov.xml_xslt_jdbc;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
public class Entries {

    private List<Entry> entry;

    public Entries(List<Entry> entry) {
        this.entry = entry;
    }
    public Entries() {
        this.entry = null;
    }
    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }
}
