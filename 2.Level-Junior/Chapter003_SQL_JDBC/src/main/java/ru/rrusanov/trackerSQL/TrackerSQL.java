package ru.rrusanov.trackerSQL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.rrusanov.ITracker;
import ru.rrusanov.Input;
import ru.rrusanov.Tracker;
import ru.rrusanov.log4j2.UsageLog4j2;
import ru.rrusanov.models.Item;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
     *
     * @return boolean
     */
    public TrackerSQL() {
        super();
        this.tables = new HashMap<>();
        this.fillTablesCollection();
    }

    /**
     *
     */
    public void fillTablesCollection() {
        // role table
        this.tables.put("role",
            "create table role(" +
            "role_id serial primary key," +
            "title varchar(100));"
        );
        // ruls table
        this.tables.put("ruls", "" +
            "create table ruls(" +
            "ruls_id serial primary key," +
            "title varchar(100));"
        );
        // users table
        this.tables.put("users",
            "create table users(" +
            "user_id serial primary key," +
            "last_name varchar(50) not null," +
            "first_name varchar(50) not null," +
            "midle_name varchar(50) not null," +
            "role_id int not null," +
            "constraint role_role_id_fk" +
            "foreign key (role_id)" +
            "references role (role_id));"
        );
        // role_ruls table
        this.tables.put("role_ruls",
            "create table role_ruls(" +
            "role_id int not null," +
            "constraint role_role_id_fk" +
            "foreign key (role_id)" +
            "references role (role_id)," +
            "ruls_id int not null," +
            "constraint ruls_ruls_id_fk" +
            "foreign key (ruls_id)" +
            "references ruls (ruls_id));"
        );
        // state table
        this.tables.put("state",
            "create table state(" +
            "state_id serial primary key," +
            "title varchar(50));"
        );
        // category table
        this.tables.put("category",
            "create table category(" +
            "category_id serial primary key," +
            "title varchar(50));"
        );
        // item table
        this.tables.put("item",
            "create table item(" +
            "item_id serial primary key," +
            "title varchar(100)," +
            "description text," +
            "state_id int not null," +
            "constraint state_state_id_fk" +
            "foreign key (state_id)" +
            "references state (state_id)," +
            "category_id int not null," +
            "constraint category_category_id_fk" +
            "foreign key (category_id)" +
            "references category (category_id)," +
            "constraint item_item_id_fk" +
            "foreign key (item_id)" +
            "references users (user_id));"
        );
        // attached table
        this.tables.put("attached",
            "create table attached(" +
            "attached_id serial primary key," +
            "item_id int not null," +
            "path_to_file varchar(256) not null," +
            "constraint item_item_id_fk" +
            "foreign key (item_id)" +
            "references item(item_id));"
        );
        // comments table
        this.tables.put("comments",
            "create table comments(" +
            "coment_id serial primary key," +
            "item_id int not null," +
            "comments text," +
            "constraint item_item_id_fk" +
            "foreign key (item_id)" +
            "references item (item_id));"
        );
    }
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

    /**
     * The method check exist table in database.
     * @param tableName
     * @return
     * @throws SQLException
     */
    public boolean tableExist(String tableName) {
        boolean tExists = false;
        if (this.init()) {
            try (ResultSet rs = this.connection.getMetaData().getTables(null, null, tableName, null)) {
                while (rs.next()) {
                    String tName = rs.getString("TABLE_NAME");
                    if (tName != null && tName.equals(tableName)) {
                        tExists = true;
                        break;
                    }
                }
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            } finally {
                try {
                    this.close();
                } catch (Exception e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
        return tExists;
    }

    /**
     * The method .
     * @return
     */
    public void checkStructure(){

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
