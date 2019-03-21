package ru.rrusanov.xml_xslt_jdbc;
import org.junit.Before;
import org.junit.Test;
/**
 * Class test behavior StoreXML class.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 12.03.19
 */
public class StoreXMLTest {
    /**
     * The field contain instance Config class.
     */
    private Config config = new Config();
    /**
     * The field contain instance that generate in SQLite DB sequence of rows.
     */
    private StoreSQL storeSQL = new StoreSQL(this.config);
    /**
     * The field contain instance StoreXML class.
     * Convert from collection to xml file.
     */
    private StoreXML storeXML = new StoreXML();

    /**
     * The method execute before each test.
     */
    @Before
    public void setUp() {
        this.storeSQL.createTable();
    }

    /**
     * Test method save.
     */
    @Test
    public void whenMethodPassThenStoreToXml() {
        storeXML.save(storeSQL.load());
    }
}