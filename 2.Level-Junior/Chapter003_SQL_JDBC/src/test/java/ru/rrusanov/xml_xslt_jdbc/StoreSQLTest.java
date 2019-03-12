package ru.rrusanov.xml_xslt_jdbc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.*;

public class StoreSQLTest {

    private StoreSQL storeSQL;

    private Config config;

    @Before
    public void setUp() {
        config = new Config();
        storeSQL = new StoreSQL(config);
    }

    @After
    public void closeConnection() throws SQLException{
        this.config.getConnection().close();
    }

    @Test
    public void tableExist() {
        Assert.assertTrue(this.storeSQL.tableExist("entry"));
        Assert.assertFalse(this.storeSQL.tableExist("entry1"));
    }

    @Test
    public void createTable() {
        this.storeSQL.deleteTable();
        Assert.assertFalse(this.storeSQL.tableExist("entry"));
        this.storeSQL.createTable();
        assertTrue(this.storeSQL.tableExist("entry"));
    }

    @Test(timeout = 2000)
    public void generate() throws SQLException {
        int expect = 1000000;
        this.storeSQL.generate(expect);
        PreparedStatement ps = this.config.getConnection().prepareStatement("select count(*) from entry;");
        ResultSet rs = ps.executeQuery();
        rs.next();
        int rowCount = rs.getInt(1);
        assertEquals(rowCount, expect);
    }

    @Test
    public void load() {
        this.storeSQL.generate(10);
        assertEquals(this.storeSQL.load().size(), 10);
    }
}