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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private static final Logger LOG = LogManager.getLogger(UsageLog4j2.class.getName());

    /**
     *
     */
    public TrackerSQL() {
        this.init();
    }

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
     */
    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps = this.connection.prepareStatement(
                "insert into item (item_id, title, description, state_id, category_id) values (?, ?, ?, ?, ?);"
        )
        ) {
            ps.setInt(1, 1);
            ps.setString(2, item.getName());
            ps.setString(3, item.getDescription());
            ps.setInt(4, 1);
            ps.setInt(5, 1);
            try (ResultSet rs = ps.executeQuery()) {
                //checkstyle
                System.out.println();
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return item;
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
