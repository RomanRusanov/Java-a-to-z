package ru.rrusanov.xml_xslt_jdbc;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.util.Properties;
import static org.junit.Assert.assertEquals;
/**
 * Class test behavior Config class.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 06.03.19
 */
public class ConfigTest {
    /**
     * The field contain properties of connection to db.
     */
    private final Properties values = new Properties();

    /**
     * The method execute before each test.
     */
    @Before
    public void setUp() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("app.propertiesSqlLite")) {
            this.values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException("Config from file: app.propertiesSqlLite not loaded. " + e);
        }
    }

    /**
     * Test init method.
     */
    @Test
    public void whenPropertiesSetThenReturnThem() {
        assertEquals("sqlite.db", this.values.getProperty("fileDB"));
        assertEquals("jdbc:sqlite:", this.values.getProperty("url"));
        assertEquals("./db/", this.values.getProperty("pathToDB"));
        assertEquals("user", this.values.getProperty("username"));
        assertEquals("password", this.values.getProperty("password"));
    }
}