package ru.rrusanov.sqlruParser;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class contain configuration connection to SQLite db, cron scheduler parameters.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.03.19
 */
public class Config {
    /**
     * The field contain properties of connection to db.
     */
    private final Properties config = new Properties();
    /**
     * The default constructor.
     * Initiate connection.
     */
    public Config(String configFile) {
        this.init(configFile);
    }

    /**
     * Getter for properties.
     * @return properties.
     */
    public Properties getConfig() {
        return config;
    }
    /**
     * The method load properties from file example (app.propertiesParser).
     */
    public void init(String configFile) {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream(configFile)) {
            config.load(in);
        } catch (Exception e) {
            throw new IllegalStateException("Config from file: app.propertiesParser not loaded. " + e);
        }
    }
}