package ru.rrusanov.xml_xslt_jdbc;
import java.io.InputStream;
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
     * The default constructor.
     * Initiate connection.
     */
    public Config() {
        this.init();
    }

    /**
     * Getter for properties.
     * @return properties.
     */
    public Properties getValues() {
        return values;
    }
    /**
     * The method load properties from file app.propertiesSqlLite.
     */
    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("app.propertiesSqlLite")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException("Config from file: app.propertiesSqlLite not loaded. " + e);
        }
    }
}