package ru.rrusanov.xml_xslt_jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class StoreSQL implements AutoCloseable {

    private final Config config;

    private Connection connect;

    private static final Logger LOG = LogManager.getLogger(StoreSQL.class.getName());

    private int version = 1;

    public StoreSQL(Config config) {
        this.config = config;
        this.connect = this.config.getConnection();
    }

    public void generate(int size) {

    }

    public List<Entry> load() {
        return Collections.EMPTY_LIST;
    }

    public boolean tableExist(String tableName) {
        boolean result = false;
        try (ResultSet rs = this.connect.getMetaData().getTables(null, null, "%", null)) {
            while (rs.next()) {
                if (rs.getString(3).equals(tableName)) {
                    result = true;
                }
            }
        } catch (SQLException e) {
            LOG.error(String.format("Error checking exist table in db. Version:%d", version));
        }
        return result;
    }

    public void createTable() {
        try (PreparedStatement ps = this.connect.prepareStatement(
                "create table entry (integer field);")) {
            try {
                ps.execute();
            } catch (SQLException e) {
                LOG.error("Error executing ps with create table. Version:%d", version);
            }

        } catch (SQLException e) {
            LOG.error("Error get ps from connection for create table. Version:%d", version);
        }
    }

    public void deleteTable() {
        try (PreparedStatement ps = this.connect.prepareStatement(
                "drop table entry;")) {
            try {
                ps.execute();
            } catch (SQLException e) {
                LOG.error("Error executing ps with drop table. Version:%d", version);
            }

        } catch (SQLException e) {
            LOG.error("Error get ps from connection for drop table. Version:%d", version);
        }
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
