package ru.rrusanov.LSP;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.rrusanov.LSP.model.Bread;
import ru.rrusanov.LSP.model.Butter;
import ru.rrusanov.LSP.model.Food;
import ru.rrusanov.LSP.model.Milk;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.CoreMatchers.is;

public class WarehouseTest {

    private Warehouse warehouse;

    private Food food;

    private Long timeForTest;

    @Before
    public void setUp(){
        this.warehouse = new Warehouse("TestWarehouse");
        this.food = new Milk("Milk Russian field",
                    new GregorianCalendar(2019, Calendar.JUNE, 25),
                    new GregorianCalendar(2019, Calendar.JUNE, 17),
                    80.50,
                    (byte) 0);
        this.timeForTest = 1560760137273L; // 2019, Calendar.JUNE, 17
    }

    @Test
    public void putInStore() {
        this.warehouse.putInStore(food);
        Assert.assertThat(this.warehouse.getAllFood().containsValue(food), is(true));
    }

    @Test
    public void getAllFood() {
        this.warehouse.putInStore(food);
        this.warehouse.putInStore(new Milk());
        this.warehouse.putInStore(new Bread());
        this.warehouse.putInStore(new Butter());
        Assert.assertThat(this.warehouse.getAllFood().size(), is(3));
    }

    @Test
    public void removeFromStore() {
        this.warehouse.putInStore(food);
        this.warehouse.removeFromStore("Milk Russian field");
        Assert.assertThat(this.warehouse.getAllFood().containsValue(food), is(false));
    }

    @Test
    public void isConditionMatched() {
        Assert.assertThat(warehouse.isConditionMatched(this.food, this.timeForTest), is (true));
    }
}