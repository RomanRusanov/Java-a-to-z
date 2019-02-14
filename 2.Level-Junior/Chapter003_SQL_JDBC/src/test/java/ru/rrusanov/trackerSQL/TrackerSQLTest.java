package ru.rrusanov.trackerSQL;

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
    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }
}