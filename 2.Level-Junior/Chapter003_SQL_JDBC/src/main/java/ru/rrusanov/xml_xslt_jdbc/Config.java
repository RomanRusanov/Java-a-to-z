package ru.rrusanov.xml_xslt_jdbc;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * Class create connection to SQLite db.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 06.03.19
 */
public class Config {
    /**
     * The field contain properties of connection to db.
     */
    private final Properties values = new Properties();
    /**
     * Logger.
     */
    private static final Logger LOG = LogManager.getLogger(Config.class.getName());
    /**
     * Version for Logger.
     */
    private int version = 1;
    /**
     * The field contain instance connection to db.
     */
    private Connection connection;

    /**
     * The default constructor.
     * Initiate connection.
     */
    public Config() {
        this.init();
    }

    /**
     * The method load properties from file app.propertiesSqlLite.
     */
    public void init() {
        if (this.connection == null) {
            try (InputStream in = Config.class.getClassLoader().getResourceAsStream("app.propertiesSqlLite")) {
                values.load(in);
            } catch (Exception e) {
                throw new IllegalStateException("Config from file: app.propertiesSqlLite not loaded. " + e);
            }
        }
    }

    /**
     * Method create instance of connection of db if it not exist yet.
     * @return True if connection create. Otherwise false.
     */
    public boolean initConnectionToSQLiteDB() {
        String url = this.values.getProperty("url") + this.values.getProperty("pathToDB")
                + this.values.getProperty("fileDB");
        try {
            this.connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            LOG.error(String.format("Connection by passed url: %s version: %s", url, version));
        }
        return this.connection != null;
    }

    /**
     * The method return connection instance to DB.
     * @return connection.
     */
    public Connection getConnection() {
        this.initConnectionToSQLiteDB();
        return connection;
    }
}