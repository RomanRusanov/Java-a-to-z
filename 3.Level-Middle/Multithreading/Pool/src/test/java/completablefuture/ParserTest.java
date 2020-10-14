package completablefuture;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

/**
 * The class test behavior Parse.java.
 */
class ParserTest {
    /**
     * The temporary folder for test.
     */
    @TempDir
    static Path sharedTempDir;
    /**
     * The config instance.
     */
    private static final Config CONFIG = new Config(Path.of("data/app.properties"));
    /**
     * The test instance.
     */
    private ToDB toDb;
    /**
     * The test instance.
     */
    private ToServer toServer;
    /**
     * The test instance.
     */
    private ToFiles toFiles;
    /**
     * The test instance.
     */
    private Parser parser;
    /**
     * The field contain connection to DB.
     */
    private Connection connection;

    /**
     * The method execute before all tests.
     */
    @BeforeAll
    public static void setup() {
        CONFIG.load();
        CONFIG.updateValue("path", sharedTempDir.toString());
        CONFIG.updateValue("source", "data/source.txt");
    }

    /**
     * The method execute before each test.
     */
    @BeforeEach
    public void beforeEachTest() {
        this.toDb = new ToDB(CONFIG, true);
        this.connection = this.toDb.getConnection();
        this.toServer = new ToServer(CONFIG);
        this.toFiles = new ToFiles(CONFIG);
        this.parser = new Parser(toServer, toDb, toFiles, CONFIG);
    }

    /**
     * The test chek behavior all async process:
     * - assertTimeout(Duration.ofMinutes(5) - if test work more than 5 minutes, its wrong.
     * - assertEquals(1000, new File(sharedTempDir.toString()).list().length)
     *      ToFiles - after complete async work must create 1000 files txt in temp folder.
     * - assertEquals(1000, this.countAddedCountries(this.connection));
     * - assertEquals(1000000, this.countAddedParticipants(this.connection));
     *      ToDB - after complete async work must full two tables(country, participants) in
     *      DB(competition). Table country must have 1000 records, table participants 1000000 records.
     * - assertEquals(1000, this.toServer.getCollectionSize());
     *      ToServer - after complete async work local collection (countriesFromParser) must
     *      have size 1000 records all countries.
     */
    @Test
    void parserProcessTest() {
        assertTimeout(Duration.ofMinutes(5), () -> {
            System.out.println(sharedTempDir);
            parser.reader();
            parser.init();
            while (!parser.isWorkComplete()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            assertEquals(1000, new File(sharedTempDir.toString()).list().length);
            assertEquals(1000, this.countAddedCountries(this.connection));
            assertEquals(1000000, this.countAddedParticipants(this.connection));
            assertEquals(1000, this.toServer.getCollectionSize());
        });
    }

    /**
     * The method create query to DB. Check how many records
     * in table "participants" was added.
     * @param connection Connection to db instance.
     * @return Numbers records.
     */
    public Integer countAddedParticipants(Connection connection) {
        Integer result = -1;
        try (PreparedStatement ps = connection.prepareStatement(
                "select count(*) from participants;")) {
            ResultSet rs = ps.executeQuery();
            rs.next();
            result = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * The method create query to DB. Check how many records
     * in table "country" was added.
     * @param connection Connection to db instance.
     * @return Numbers records.
     */
    public Integer countAddedCountries(Connection connection) {
        Integer result = -1;
        try (PreparedStatement ps = connection.prepareStatement(
                "select count(*) from country;")) {
            ResultSet rs = ps.executeQuery();
            rs.next();
            result = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}