package ru.rrusanov.xml_xslt_jdbc;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.*;

public class ConfigTest {

    private final Properties values = new Properties();

    private final Config config = new Config();


    @Before
    public void setUp() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("app.propertiesSqlLite")) {
            this.values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException("Config from file: app.propertiesSqlLite not loaded. " + e);
        }
    }

    @Test
    public void init() {
        assertEquals("sqlite.db", this.values.getProperty("fileDB"));
        assertEquals("jdbc:sqlite:", this.values.getProperty("url"));
        assertEquals("./db/", this.values.getProperty("pathToDB"));
        assertEquals("user", this.values.getProperty("username"));
        assertEquals("password", this.values.getProperty("password"));
    }

    @Test
    public void initConnectionToSqliteDB() {
        assertTrue(this.config.initConnectionToSqliteDB());
    }
}