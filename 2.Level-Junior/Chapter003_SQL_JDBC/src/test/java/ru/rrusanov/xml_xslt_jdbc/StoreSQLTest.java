package ru.rrusanov.xml_xslt_jdbc;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class test behavior StoreSQL class.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 06.03.19
 */
public class StoreSQLTest {
    /**
     * The field contain instance Config class.
     */
    private Config config;
    /**
     * The instance contain class for tests.
     */
    private StoreSQL storeSQL;

    /**
     * The method execute before each test.
     */
    @Before
    public void setUp() {
        this.config = new Config();
        this.storeSQL = new StoreSQL(config);
        this.storeSQL.createTable();
    }

    /**
     * Test method tableExist.
     */
    @Test
    public void whenTableExistThenReturnTrue() {
        this.storeSQL.createTable();
        assertTrue(this.storeSQL.tableExist("entry"));
        Assert.assertFalse(this.storeSQL.tableExist("entry1"));
        this.storeSQL.deleteTable();
    }

    /**
     * Test method createTable.
     */
    @Test
    public void whenTableCreateThenReturnTrue() {
        this.storeSQL.deleteTable();
        Assert.assertFalse(this.storeSQL.tableExist("entry"));
        this.storeSQL.createTable();
        assertTrue(this.storeSQL.tableExist("entry"));
    }

    /**
     * Test method generate. Test can't executes more then 2000 milliseconds.
     * 1 000 000 rows must insert less 2 seconds.
     * @throws SQLException Prepare statement may throw.
     */
    @Test(timeout = 2000)
    public void whenRowsGeneratedThenRowCountEquals() throws SQLException {
        int expect = 1000000;
        this.storeSQL.createTable();
        this.storeSQL.generate(expect);
        assertEquals(this.storeSQL.countAllRows(), expect);
    }

    /**
     * Test method load.
     */
    @Test
    public void whenEntryLoadedThenSizeEquals() {
        this.storeSQL.createTable();
        this.storeSQL.generate(10);
        assertEquals(this.storeSQL.load().size(), 10);
    }

    /**
     * Test initConnectionToSQLiteDB method.
     */
    @Test
    public void whenMethodCallThenConnectionCreate() {
        assertTrue(this.storeSQL.initConnectionToSQLiteDB(this.config.getValues()));
    }
}