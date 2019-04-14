package ru.rrusanov.sqlruParser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;
import java.util.Properties;
import static ru.rrusanov.trackerSQL.ConnectionRollback.create;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.03.2019
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
            this.connection = create(DriverManager.getConnection(url));
            this.connection.setAutoCommit(false);
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
        try (PreparedStatement ps = this.connection.prepareStatement(
                "create table if not exists vacancy ("
                        + "id integer primary key, "
                        + "name varchar(255), "
                        + "text text, "
                        + "link text "
                        + ");")
        ) {
            try {
                ps.execute();
                this.connection.commit();
            } catch (SQLException e) {
                LOG.error(String.format(
                        "Error executing ps with create table. Version:%d%n SQL Exception:%s",
                        version, e.toString())
                );
            }
        } catch (SQLException e) {
            LOG.error(String.format(
                    "Error get ps from connection for create table. Version:%d%n SQL Exception:%s",
                    version, e.toString())
            );
        }
    }

    public void insertArticleListToDB(List<Article> articleList) {
        for (Article article : articleList) {
            try (PreparedStatement ps = this.connection.prepareStatement(
                "insert into vacancy (name, text, link) values (?, ?, ?)")
            ) {
                String topic = article.getTopic();
                if (this.existArticleNameInBD(article.getTopic())) {
                    topic = "Дубликат! " + topic;
                }
                ps.setString(1, topic);
                ps.setString(2, article.getText());
                ps.setString(3, article.getUrl());
                LOG.info("To vacancy table row added: " + ps.executeUpdate());
                this.connection.commit();
            } catch (SQLException e) {
                try {
                    this.connection.rollback();
                } catch (SQLException e1) {
                    LOG.error(String.format(
                            "Error rollback transaction. After unsuccessfully insert to vacancy table. "
                            + "Version:%d%n SQL Exception:%s", version, e1.toString())
                    );
                }
                LOG.error(String.format(
                        "Error insert list in vacancy table. Version:%d%n SQL Exception:%s",
                        version, e.toString())
                );

            }
        }
    }

    public boolean existArticleNameInBD(String topic) {
        boolean result = false;
        try (PreparedStatement ps = this.connection.prepareStatement(
                "select name from vacancy;")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    if (rs.getString("name").equals(topic)) {
                        result = true;
                    }
                }
            } catch (Exception e) {
                LOG.error("Result set (get data from vacancy table)", version);
            }
        } catch (SQLException e) {
            LOG.error("SQL query (select all articles names from vacancy table)", version);
        }
        return result;
    }


}