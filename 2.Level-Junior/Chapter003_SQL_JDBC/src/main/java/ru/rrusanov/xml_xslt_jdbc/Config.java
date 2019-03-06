package ru.rrusanov.xml_xslt_jdbc;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Config {

    private final Properties values = new Properties();

    private static final Logger LOG = LogManager.getLogger(Config.class.getName());

    private int version = 1;

    private Connection connection;

    public Config() {
        this.init();
    }

    public void init() {
        if (this.connection == null) {
            try (InputStream in = Config.class.getClassLoader().getResourceAsStream("app.propertiesSqlLite")) {
                values.load(in);
            } catch (Exception e) {
                throw new IllegalStateException("Config from file: app.propertiesSqlLite not loaded. " + e);
            }
        }
    }

    public boolean initConnectionToSqliteDB() {
        String url = this.values.getProperty("url") + this.values.getProperty("pathToDB")+ this.values.getProperty("fileDB");
        try {
            this.connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            LOG.error(String.format("Connection by passed url: %s version: %s", url, version));
        }
        return this.connection != null;
    }

    public Connection getConnection() {
        this.initConnectionToSqliteDB();
        return connection;
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}
