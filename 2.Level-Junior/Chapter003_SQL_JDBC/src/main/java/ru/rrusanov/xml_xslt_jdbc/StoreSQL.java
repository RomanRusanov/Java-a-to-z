package ru.rrusanov.xml_xslt_jdbc;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

public class StoreSQL implements AutoCloseable {

    private final Config config;

    private Connection connect;

    public StoreSQL(Config config) {
        this.config = config;
    }

    public void generate(int size) {

    }

    public List<Entry> load() {
        return Collections.EMPTY_LIST;
    }
    /**
     * Closes this resource, relinquishing any underlying resources.
     * This method is invoked automatically on objects managed by the
     * {@code try}-with-resources statement.
     * @throws Exception if this resource cannot be closed
     */
    @Override
    public void close() throws Exception {
        if (this.connect != null) {
            this.connect.close();
        }
    }
}
