package ru.rrusanov.LSP;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.rrusanov.LSP.model.FoodWrapper;
import ru.rrusanov.LSP.model.Milk;
import ru.rrusanov.LSP.model.MilkReproduct;

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
public class Warehouse2Test {
    /**
     * The field contain instance tested class.
     */
    private Warehouse warehouse;
    /**
     * The field contain instance tested class.
     */
    private Warehouse2 warehouse2;
    /**
     * The field contain instance food class.
     */
    private FoodWrapper food;
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
        this.warehouse2 = new Warehouse2(warehouse, "TestWarehouse2");
        this.timeForTest = 1560760137273L; // 2019, Calendar.JUNE, 17 Current date
        for (int i = 0; i < 11; i++) {
            // Put in store 10 foods.
            warehouse.putInStore(new MilkReproduct(new Milk("Milk Russian field" + i,
                                        new GregorianCalendar(2019, Calendar.JUNE, 15), // Expire date
                                        new GregorianCalendar(2019, Calendar.JUNE, 10), // Create date
                                        80.50,
                                        (byte) 0)));
        }
        this.food = new MilkReproduct(new Milk("Milk Russian field",
                new GregorianCalendar(2019, Calendar.JULY, 30), // Expire date
                new GregorianCalendar(2019, Calendar.JUNE, 10), // Create date
                80.50,
                (byte) 0));
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
        Assert.assertThat(this.warehouse.getAllFood().size(), is(12));
    }

    /**
     * The test check removeFromStore method.
     */
    @Test
    public void whenPassFoodRemoveFromStoreThenFoodDeleteFromContainer() {
        this.warehouse.putInStore(food);
        this.warehouse.removeFood("Milk Russian field");
        Assert.assertThat(this.warehouse.getAllFood().containsValue(food), is(false));
    }

    /**
     * The test check isConditionMatched method.
     */
    @Test
    public void whenConditionMatchedThenReturnTrue() {
        Assert.assertThat(warehouse2.isConditionMatched(this.food, this.timeForTest), is(true));
    }
}