package ru.rrusanov.trackerSQL;

import org.junit.Before;
import org.junit.Test;
import ru.rrusanov.tracker.model.Item;
import java.util.ArrayList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
/**
 * Class test Tracker.java.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 26.02.19
 */
public class TrackerSQLTest {
    /**
     * The instance of the class being tested.
     */
    private TrackerSQL trackerSQL;
    /**
     * The method execute before each test.
     */
    @Before
    public void setUp() {
        this.trackerSQL = new TrackerSQL();
    }
    /**
     * The method check connection to db.
     */
    @Test
    public void whenConnectionCreateThenReturnTrue() {
        TrackerSQL sql = this.trackerSQL;
        assertThat(sql.init(), is(true));
    }
    /**
     * Test if item create then it exist. add() Method behavior check.
     */
    @Test
    public void whenItemCreateThenItExist() {
        String titleItem = "Тема заявки в тесте";
        String descriptionItem = "Описание заявки в тесте";
        String comment = "Коментарий 1 к заявке в тесте";
        Long dateCreate = System.currentTimeMillis();
        Item expect = new Item(titleItem, descriptionItem, dateCreate, comment);
        this.trackerSQL.add(expect);
        Item result = this.trackerSQL.findByName("Тема заявки в тесте").get(0);
        assertEquals(result, expect);
        this.trackerSQL.delete(expect);
    }
    /**
     * Test if items exist in db. findAll Method behavior check.
     */
    @Test
    public void whenItemsExistThenReturnItemsId() {
        ArrayList<Item> allItems = this.trackerSQL.findAll();
        assertEquals(allItems.get(0).getId(), "1");
        assertEquals(allItems.get(1).getId(), "2");
    }
    /**
     * Test if item with specific name exist in db when return id. findByName() Method behavior check.
     */
    @Test
    public void whenItemPresentThenReturnItemId() {
        ArrayList<Item> itemByName = this.trackerSQL.findByName("заявка2");
        assertEquals(itemByName.get(0).getId(), "2");

    }
    /**
     * Test if item with specific item_id exist in db when return true. findById() Method behavior check.
     */
    @Test
    public void whenItemWithIdExistThenReturnTrue() {
        Item expect = new Item("5555");
        expect.setName("Тема заявки в тесте");
        expect.setDescription("Описание заявки в тесте");
        expect.setComment("Коментарий 1 к заявке в тесте");
        expect.setCreate(System.currentTimeMillis());
        this.trackerSQL.add(expect);
        assertEquals(this.trackerSQL.findById("5555"), expect);
        this.trackerSQL.delete(expect);
    }
    /**
     * Test if passed item_id and item, when item whit what id in bd update data from passed item.
     */
    @Test
    public void whenPassedIdAndItemThenThatItemIdUpdatedInBD() {
        Item existItem = new Item("7777");
        existItem.setName("Тема заявки в тесте");
        existItem.setDescription("Описание заявки в тесте");
        existItem.setComment("Коментарий 1 к заявке в тесте");
        existItem.setCreate(System.currentTimeMillis());
        Item newItem = new Item("9999");
        newItem.setName("Обновленная тема");
        newItem.setDescription("Обновленное описанин в заявке");
        newItem.setComment("Обновленный комментарий");
        this.trackerSQL.add(existItem);
        this.trackerSQL.replace("7777", newItem);
        assertEquals(newItem.getName(), this.trackerSQL.findById("7777").getName());
        assertEquals(newItem.getDescription(), this.trackerSQL.findById("7777").getDescription());
        assertEquals(newItem.getComment(), this.trackerSQL.findById("7777").getComment());
        this.trackerSQL.delete(existItem);
    }
}