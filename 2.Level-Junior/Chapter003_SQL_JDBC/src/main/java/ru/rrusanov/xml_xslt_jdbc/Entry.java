package ru.rrusanov.xml_xslt_jdbc;

import java.util.Objects;

public class Entry {

    private int field;


    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return field == entry.field;
    }

    @Override
    public int hashCode() {
        return Objects.hash(field);
    }
}
