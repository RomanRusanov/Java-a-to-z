package ru.rrusanov.trackerSQL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.rrusanov.ITracker;
import ru.rrusanov.Input;
import ru.rrusanov.log4j2.UsageLog4j2;
import ru.rrusanov.models.Item;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

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
                "insert into item (item_id, title, description, state_id, category_id, date_create) values (?, ?, ?, ?, ?, ?);")) {
            ps.setDouble(1, Double.parseDouble(item.getId()));
            ps.setString(2, item.getName());
            ps.setString(3, item.getDescription());
            ps.setInt(4, 1);
            ps.setInt(5, 1);
            ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
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

    /**
     *
     * @return
     */
    @Override
    public ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList<>();
        try (PreparedStatement ps = this.connection.prepareStatement(
                "select * from item;")) {
            result = this.sqlToItem(ps);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     *
     * @param key String for find in array
     * @return
     */
    @Override
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        try (PreparedStatement ps = this.connection.prepareStatement(
                "select * from item where title = ?;")) {
            ps.setString(1, key);
            result = this.sqlToItem(ps);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     *
     * @param ps
     * @return
     */
    public ArrayList<Item> sqlToItem(PreparedStatement ps) {
        ArrayList<Item> result = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Item item = new Item(String.valueOf(rs.getBigDecimal("item_id")));
                item.setName(rs.getString("title"));
                item.setDescription(rs.getString("description"));
                item.setCreate(rs.getTimestamp("date_create").getTime());
                result.add(item);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }
    
    @Override
    public Item findById(String id) {
        return null;
    }

    @Override
    public void printToConsoleItem(ArrayList<Item> item) {
        for (Item i:item) {
            System.out.printf("---------------------------------------%n "
                            + "ID: %s%n "
                            + "name: %s%n "
                            + "date: %s%n "
                            + "description: %s%n "
                            + "---------------------------------------%n",
                    i.getId(),
                    i.getName(),
                    this.convert(i.getCreate()),
                    i.getDescription()
            );
        }
    }
    /**
     * Convert value millisecond to string date and time example (31.12.1970 23:59:59).
     * @param millis vaule in milliseconds
     * @return string date and time "31.12.1970 23:59:59"
     */
    public String convert(long millis) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("Russia/Moscow"));
        cal.setTimeInMillis(millis);
        return new SimpleDateFormat("dd.MM.yy HH:mm:ss").format(cal.getTime());
    }

    @Override
    public void fieldsUpdate(Item item, Input input) {

    }
}
