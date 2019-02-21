package ru.rrusanov.trackerSQL;

import org.junit.Before;
import org.junit.Test;
import ru.rrusanov.models.Item;

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

    /**
     *
     */
    @Test
    public void add() {
        Item item = new Item("add1", "Description1", System.currentTimeMillis(), "Comment1");
        this.trackerSQL.add(item);
    }
}