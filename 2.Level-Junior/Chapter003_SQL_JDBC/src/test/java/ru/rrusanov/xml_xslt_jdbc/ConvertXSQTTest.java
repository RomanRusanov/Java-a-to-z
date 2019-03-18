package ru.rrusanov.xml_xslt_jdbc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.sql.SQLException;
/**
 * Class test behavior ConvertXSQT class.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 14.03.19
 */
public class ConvertXSQTTest {
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
     * The field contain instance that convert xml to other xml structure.
     */
    private ConvertXSQT convertXSQT = new ConvertXSQT();

    /**
     * The method execute before each test.
     */
    @Before
    public void setUp() {
        this.storeSQL.generate(1000000);
        this.storeXML.save(this.storeSQL.load());
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
     * Test method convert.
     */
    @Test
    public void whenPassXmlAndSchemeThenGetAnotherXML() {
        String slash = File.separator;
        File source = new File("." + slash + "files" + slash + "file.xml");
        File dest = new File("." + slash + "files" + slash + "convertedFile.xml");
        File scheme = new File("." + slash + "files" + slash + "scheme.xsl");
        this.convertXSQT.convert(source, dest, scheme);
    }

    /**
     * Test method parse.
     */
    @Test
    public void whenPassXmlThenGetSumAllElements() {
        String slash = File.separator;
        File source = new File("." + slash + "files" + slash + "file.xml");
        File dest = new File("." + slash + "files" + slash + "convertedFile.xml");
        File scheme = new File("." + slash + "files" + slash + "scheme.xsl");
        this.convertXSQT.convert(source, dest, scheme);
        this.convertXSQT.parse(dest);
    }
}