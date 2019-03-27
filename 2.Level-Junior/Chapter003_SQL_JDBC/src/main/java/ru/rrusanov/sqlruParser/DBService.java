package ru.rrusanov.sqlruParser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.03.2019
 *
 *
 */
public class DBService implements AutoCloseable {
    /**
     * The field contain instance connection to database.
     */
    private Connection connection;
    /**
     * Logger.
     */
    private static final Logger LOG = LogManager.getLogger(DBService.class.getName());
    /**
     * Version for Logger.
     */
    private int version = 1;

    public DBService(Config config) {
        this.initConnectionToSQLiteDB(config.getValues());
        this.createTable();
    }

    /**
     * Method create instance of connection of db if it not exist yet.
     *
     * @param values Configuration db(pathToDb + file.db, url db, username, password).
     * @return True if connection create. Otherwise false.
     */
    public boolean initConnectionToSQLiteDB(Properties values) {
        String url = values.getProperty("url")
                + values.getProperty("pathToDB")
                + values.getProperty("fileDB");
        try {
            this.connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            LOG.error(String.format("Connection by passed url: %s version: %s", url, version));
        }
        return this.connection != null;
    }

    /**
     * Closes this resource, relinquishing any underlying resources.
     * This method is invoked automatically on objects managed by the
     * {@code try}-with-resources statement.
     *
     * @throws Exception if this resource cannot be closed
     */
    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            this.connection.close();
        }
    }

    /**
     * The method create table vacancy in DB.
     */
    public void createTable() {
        try (PreparedStatement ps = this.connection.prepareStatement
                (
                        "create table if not exists vacancy ("
                                + "id serial not null primary key, "
                                + "name varchar(255), "
                                + "text BLOB, "
                                + "link BLOB "
                                + ");"
                )
        ) {
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


}
