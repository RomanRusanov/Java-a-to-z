package ru.rrusanov.xml_xslt_jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
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
        this.clearTable();
        try (PreparedStatement ps = this.connect.prepareStatement("insert into entry (field) values (?);")) {
            this.connect.setAutoCommit(false);
            for (int i = 0; i < size; i++){
                ps.setInt(1, i);
                ps.execute();
            }
            this.connect.commit();
            this.connect.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                this.connect.rollback();
            } catch (SQLException e1) {
                LOG.error(String.format(
                    "Error rollback transaction. After unsuccessfully insert to entry table. Version:%d"
                    + "%n SQL Exception:%s", version, e1.toString())
                );
            }
            LOG.error(String.format(
                "Error generate sequence rows in entry table. Version:%d%n SQL Exception:%s", version, e.toString())
            );
        }
    }

    public void clearTable() {
        try (PreparedStatement ps = this.connect.prepareStatement("delete from entry;")) {
                ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error(String.format(
                "Error clear entry table. Delete all rows in table. Version:%d%n SQL Exception:%s", version, e.toString())
            );
            e.printStackTrace();
        }
    }

    public List<Entry> load() {
        LinkedList<Entry> result = new LinkedList<>();
        try (PreparedStatement ps = this.config.getConnection().prepareStatement("select * from entry;")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Entry(rs.getInt("field")));
            }
        } catch (SQLException e) {
            LOG.error(String.format(
                "Error load entry in list. Select all rows in table entry. "
                + "Version:%d%n SQL Exception:%s", version, e.toString())
            );
        }
        return result;
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
            LOG.error(String.format(
                "Error checking exist table in db. Version:%d%n SQL Exception:%s", version, e.toString())
            );
        }
        return result;
    }

    public void createTable() {
        try (PreparedStatement ps = this.connect.prepareStatement(
                "create table if not exists entry (field integer);")) {
            try {
                ps.execute();
            } catch (SQLException e) {
                LOG.error(String.format(
                    "Error executing ps with create table. Version:%d%n SQL Exception:%s", version, e.toString())
                );
            }
        } catch (SQLException e) {
            LOG.error(String.format(
                "Error get ps from connection for create table. Version:%d%n SQL Exception:%s", version, e.toString())
            );
        }
    }

    public void deleteTable() {
        try (PreparedStatement ps = this.connect.prepareStatement(
                "drop table entry;")) {
            try {
                ps.execute();
            } catch (SQLException e) {
                LOG.error(String.format(
                    "Error executing ps with drop table. Version:%d%n SQL Exception:%s", version, e.toString())
                );
            }
        } catch (SQLException e) {
            LOG.error(String.format(
                "Error get ps from connection for drop table. Version:%d%n SQL Exception:%s", version, e.toString())
            );
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
