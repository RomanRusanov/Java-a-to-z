package readfileconfiguration;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * The class check Config.java.
 */
public class ConfigTest {
    /**
     * The test check when file contain pair param=value then config
     * store that pair.
     */
    @Test
    public void whenPairWithoutComment() {
        String path = "data/app.properties";
        Config config = new Config(path);
        config.load();
        assertEquals(
                config.value("hibernate.dialect"),
                "org.hibernate.dialect.PostgreSQLDialect"
        );
        assertEquals(
                config.value("hibernate.connection.username"),
                "postgres"
        );
    }

    /**
     * The test check if try find value that not exist,
     * when trow exception.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void whenPairNotExistThenTrowException() {
        String path = "data/app.properties";
        Config config = new Config(path);
        config.load();
        config.value("##hibernate.connection.driver_class");
    }
}