package ru.rrusanov.trackerSQL;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 *
 */
public class TrackerSQLTest {
    /**
     *
     */
    private TrackerSQL trackerSQL;

    /**
     *
     */
    @Before
    public void setUp() {
        this.trackerSQL = new TrackerSQL();
    }
    /**
     *
     */
    @Test
    public void checkConnection() {
        TrackerSQL sql = this.trackerSQL;
        assertThat(sql.init(), is(true));
    }

    /**
     *
     */
    @Test
    public void tableExist() {
        try {
            assertTrue(trackerSQL.tableExist("role"));
            assertTrue(trackerSQL.tableExist("attached"));
            assertTrue(trackerSQL.tableExist("state"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}