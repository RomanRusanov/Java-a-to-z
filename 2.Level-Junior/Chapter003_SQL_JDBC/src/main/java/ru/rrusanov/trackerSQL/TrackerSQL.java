package ru.rrusanov.trackerSQL;

import ru.rrusanov.ITracker;
import ru.rrusanov.Input;
import ru.rrusanov.models.Item;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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
     * @return boolean
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

    }

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
