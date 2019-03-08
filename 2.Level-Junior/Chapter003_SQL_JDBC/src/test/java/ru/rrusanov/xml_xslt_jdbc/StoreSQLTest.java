package ru.rrusanov.xml_xslt_jdbc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void closeConnection() {
        try {
            this.config.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
}