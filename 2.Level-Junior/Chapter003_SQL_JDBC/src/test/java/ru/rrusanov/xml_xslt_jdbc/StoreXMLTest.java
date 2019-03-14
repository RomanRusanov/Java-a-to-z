package ru.rrusanov.xml_xslt_jdbc;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class StoreXMLTest {

    private StoreXML storeXML = new StoreXML();

    private Config config = new Config();

    private StoreSQL storeSQL = new StoreSQL(this.config);

    @Before
    public void setUp() {
        this.storeSQL.generate(5);
    }

    @Test
    public void save() {
        storeXML.save(storeSQL.load());
    }
}