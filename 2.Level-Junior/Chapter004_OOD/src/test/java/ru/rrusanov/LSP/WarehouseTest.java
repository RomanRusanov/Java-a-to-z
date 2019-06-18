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
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 18.06.2019
 *
 * The class test Shop class.
 */
public class WarehouseTest {
    /**
     * The field contain instance tested class.
     */
    private Warehouse warehouse;
    /**
     * The field contain instance food class.
     */
    private Food food;
    /**
     * The field contain fixed value current time.
     */
    private Long timeForTest;

    /**
     * The method executes before each test.
     */
    @Before
    public void setUp() {
        this.warehouse = new Warehouse("TestWarehouse");
        this.food = new Milk("Milk Russian field",
                    new GregorianCalendar(2019, Calendar.JUNE, 25),
                    new GregorianCalendar(2019, Calendar.JUNE, 17),
                    80.50,
                    (byte) 0);
        this.timeForTest = 1560760137273L; // 2019, Calendar.JUNE, 17
    }

    /**
     * The test check putInStore method.
     */
    @Test
    public void whenPassFoodThenItExistInContainer() {
        this.warehouse.putInStore(food);
        Assert.assertThat(this.warehouse.getAllFood().containsValue(food), is(true));
    }

    /**
     * The test check getAllFood method.
     */
    @Test
    public void whenCallGetAllFoodThenReturnAllFoodsInContainerStore() {
        this.warehouse.putInStore(food);
        this.warehouse.putInStore(new Milk());
        this.warehouse.putInStore(new Bread());
        this.warehouse.putInStore(new Butter());
        Assert.assertThat(this.warehouse.getAllFood().size(), is(4));
    }

    /**
     * The test check removeFromStore method.
     */
    @Test
    public void whenPassFoodRemoveFromStoreThenFoodDeleteFromContainer() {
        this.warehouse.putInStore(food);
        this.warehouse.removeStore("Milk Russian field");
        Assert.assertThat(this.warehouse.getAllFood().containsValue(food), is(false));
    }

    /**
     * The test check isConditionMatched method.
     */
    @Test
    public void whenConditionMatchedThenReturnTrue() {
        Assert.assertThat(warehouse.isConditionMatched(this.food, this.timeForTest), is(true));
    }
}