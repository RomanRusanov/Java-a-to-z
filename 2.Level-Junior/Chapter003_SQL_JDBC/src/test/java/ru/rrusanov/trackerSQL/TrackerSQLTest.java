package ru.rrusanov.trackerSQL;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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

}