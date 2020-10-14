package completablefuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 12.10.2020
 * email roman9628@gmail.com
 * The class take from parse collection and insert in DB.
 */
public class ToDB implements AutoCloseable {
    /**
     * The instance with logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ToDB.class.getName());
    /**
     * The field contain instance connection to database.
     */
    private Connection connection;
    /**
     * The field contain instance with config params pairs.
     */
    private final Config config;

    /**
     * The default constructor.
     * @param config Config instance.
     * @param rollback If we dont need apply change in DB for test when pass true.
     *                 If we want commit all transaction to db pass false.
     */
    public ToDB(Config config, boolean rollback) {
        this.config = config;
        if (rollback) {
            try {
                this.connection = ConnectionRollback.create(this.initConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            this.connection = this.initConnection();
        }
    }

    /**
     * The method get current connection for test.
     * @return Connection instance.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * The method create connection to db.
     * @return Connection.
     */
    public Connection initConnection() {
        Connection result = null;
        try {
            Class.forName(config.value("driver-class-name"));
            result = DriverManager.getConnection(
                    config.value("url"),
                    config.value("username"),
                    config.value("password")
            );
        } catch (SQLException | ClassNotFoundException e) {
            LOG.error("Error! init connection to db.", e);
        }
        if (result == null) {
            LOG.error("Connection to DB = NULL");
        }
        return result;
    }

    /**
     * The method start async process. Take from Parse collection countries,
     * and insert each country in country table records from each countries
     * insert in participants table.
     * @return Void.
     */
    public CompletableFuture<Boolean> insertInDB() {
        return CompletableFuture.supplyAsync(() -> {
            LOG.info(String.format("Start insert to DB."));
            Integer countryId = -1;
            for (Map.Entry<String, String[]> entry : Parser.getEntrySet()) {
                String country = entry.getKey();
                String[] records = entry.getValue();
                // insert in country table.
                try (PreparedStatement ps = this.connection.prepareStatement(
                        "insert into country (title) values (?) returning country_id;")) {
                    ps.setString(1, country);
                    ResultSet rs = ps.executeQuery();
                    rs.next();
                    countryId = rs.getInt(1);
                } catch (SQLException e) {
                    LOG.error("Insert in country table failed.", e);
                }
                // insert in participant table.
                for (String record : records) {
                    try (PreparedStatement ps = this.connection.prepareStatement(
                            "insert into participants "
                                    + "(first_name, last_name, rating, country_id) "
                                    + "values (?, ?, ?, ?);")) {
                        ps.setString(1, Parser.getFirstName(record));
                        ps.setString(2, Parser.getLastName(record));
                        ps.setInt(3, Integer.parseInt(Parser.getRatingValue(record)));
                        ps.setInt(4, countryId);
                        ps.executeUpdate();
                    } catch (SQLException e) {
                        LOG.error("Insert in participant table failed.", e);
                    }
                }
            }
            LOG.info("Complete insert to DB.");
            return true;
        });
    }

    /**
     * Closes connection resource.
     *
     * @throws Exception if this resource cannot be closed
     */
    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            LOG.error("Can't close connection to DB.", e);
        }
    }
}