package ru.rrusanov.LSP;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
public class ShopTest {
    /**
     * The field contain instance tested class.
     */
    private Shop shop;
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
        this.shop = new Shop("TestShop");
        this.food = new Milk("Milk Russian field",
                new GregorianCalendar(2019, Calendar.JUNE, 25),
                new GregorianCalendar(2019, Calendar.JUNE, 10),
                80.50,
                (byte) 0);
        this.timeForTest = 1560760137273L; // 2019, Calendar.JUNE, 17
    }

    /**
     * The test check isConditionMatched method.
     */
    @Test
    public void whenConditionMatchedThenReturnTrue() {
        Assert.assertThat(shop.isConditionMatched(this.food, this.timeForTest), is(true));
    }
}