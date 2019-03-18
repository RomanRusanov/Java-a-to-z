package ru.rrusanov.xml_xslt_jdbc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import static junit.framework.TestCase.assertTrue;
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
     * The instance contain class for tests.
     */
    private final Config config = new Config();

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
     * The method execute after each test.
     * @throws SQLException try close connection may throw.
     */
    @After
    public void closeConnection() throws SQLException {
        this.config.getConnection().close();
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

    /**
     * Test initConnectionToSQLiteDB method.
     */
    @Test
    public void whenMethodThenConnectionCreate() {
        assertTrue(this.config.initConnectionToSQLiteDB());
    }
}