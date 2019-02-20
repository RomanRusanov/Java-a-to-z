package ru.rrusanov.trackerSQL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.rrusanov.ITracker;
import ru.rrusanov.Input;
//import ru.rrusanov.Tracker;
import ru.rrusanov.log4j2.UsageLog4j2;
import ru.rrusanov.models.Item;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 */
public class TrackerSQL implements ITracker, AutoCloseable {
    /**
     *
     */
    private Connection connection;
    /**
     *
     */
    private HashMap<String, String> tables;
    /**
     *
     */
    private static final Logger LOG = LogManager.getLogger(UsageLog4j2.class.getName());

    /**
     * The method check connection to db.
     * @return true if connection exist, otherwise false.
     */
    public boolean init() {
       try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
           Properties config = new Properties();
           config.load(in);
           Class.forName(config.getProperty("driver-class-name"));
           this.connection = DriverManager.getConnection(
                   config.getProperty("url"),
                   config.getProperty("username"),
                   config.getProperty("password")
           );
       } catch (Exception e) {
           throw new IllegalStateException(e);
       }
       return this.connection != null;
    }
    /**
     * Closes this resource, relinquishing any underlying resources.
     * This method is invoked automatically on objects managed by the
     * {try}-with-resources statement.
     *
     * @throws Exception if this resource cannot be closed
     */
    @Override
    public void close() throws Exception {
        this.connection.close();
    }

//    /**
//     * The method check exist table in database.
//     * @param tableName
//     * @return
//     * @throws SQLException
//     */
//    public boolean tableExist(String tableName) {
//        boolean tExists = false;
//        if (this.init()) {
//            try (ResultSet rs = this.connection.getMetaData().getTables(null, null, tableName, null)) {
//                while (rs.next()) {
//                    String tName = rs.getString("TABLE_NAME");
//                    if (tName != null && tName.equals(tableName)) {
//                        tExists = true;
//                        break;
//                    }
//                }
//            } catch (Exception e) {
//                LOG.error(e.getMessage(), e);
//            } finally {
//                try {
//                    this.close();
//                } catch (Exception e) {
//                    LOG.error(e.getMessage(), e);
//                }
//            }
//        }
//        return tExists;
//    }

    @Override
    public Item add(Item item) {
        return null;
    }

    @Override
    public void update(Item itemUpdate) {

    }

    @Override
    public void delete(Item item) {

    }

    @Override
    public ArrayList<Item> findAll() {
        return null;
    }

    @Override
    public ArrayList<Item> findByName(String key) {
        return null;
    }

    @Override
    public Item findById(String id) {
        return null;
    }

    @Override
    public void printToConsoleItem(ArrayList<Item> item) {

    }

    @Override
    public void fieldsUpdate(Item item, Input input) {

    }
}
