package ru.rrusanov.xml_xslt_jdbc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
/**
 * Class generate in SQLite DB sequence of rows.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 06.03.19
 */
public class StoreSQL implements AutoCloseable {
    /**
     * The field contain instance that create connection to SQLite db.
     */
    private final Config config;
    /**
     * The field contain connection to SQLite db.
     */
    private Connection connect;
    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(StoreSQL.class.getName());
    /**
     * Version for Logger.
     */
    private int version = 1;

    /**
     * The deafault constructor.
     * @param config instance that create connection to SQLite db.
     */
    public StoreSQL(Config config) {
        this.config = config;
        this.initConnectionToSQLiteDB(config.getValues());
    }

    /**
     * The method generate sequence of rows in db.
     * @param size sequence from 0 to size value.
     */
    public void generate(int size) {
        this.clearTable();
        try (PreparedStatement ps = this.connect.prepareStatement("insert into entry (field) values (?);")) {
            this.connect.setAutoCommit(false);
            for (int i = 0; i < size; i++) {
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

    /**
     * The method clear table entry from all rows.
     */
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

    /**
     * The method load from DB to collection all entry that exist in table entry.
     * @return LinkedList with that contain all entrees.
     */
    public List<Entry> load() {
        LinkedList<Entry> result = new LinkedList<>();
        try (PreparedStatement ps = this.connect.prepareStatement("select * from entry;")) {
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

    /**
     * The method check exist table in db.
     * @param tableName Sting table name.
     * @return If exist return true, otherwise false.
     */
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

    /**
     * The method create table entry in DB.
     */
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

    /**
     * The method delete entry table from DB.
     */
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
    /**
     * Method create instance of connection of db if it not exist yet.
     * @param values Configuration db(pathToDb + file.db, url db, username, password).
     * @return True if connection create. Otherwise false.
     */
    public boolean initConnectionToSQLiteDB(Properties values) {
        String url = values.getProperty("url") + values.getProperty("pathToDB")
                + values.getProperty("fileDB");
        try {
            this.connect = DriverManager.getConnection(url);
        } catch (SQLException e) {
            LOG.error(String.format("Connection by passed url: %s version: %s", url, version));
        }
        return this.connect != null;
    }

    /**
     * The method count all rows in table.
     * @return number of rows.
     */
    public int countAllRows() {
        int result = 0;
        try (PreparedStatement ps = this.connect.prepareStatement(
                "select count(*) from entry;")) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    result = rs.getInt(1);
                }
            } catch (SQLException e) {
                LOG.error(String.format(
                        "Error get result set(count all entries in table). Version:%d%n SQL Exception:%s",
                            version, e.toString())
                );
            }
        } catch (SQLException e) {
            LOG.error(String.format(
                    "Error executing prepare statement with count all rows in table. Version:%d%n SQL Exception:%s",
                        version, e.toString())
            );
        }
        return result;
    }
}