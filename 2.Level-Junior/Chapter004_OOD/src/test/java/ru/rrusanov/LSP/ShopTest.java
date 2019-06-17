package ru.rrusanov.LSP;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.rrusanov.LSP.model.Food;
import ru.rrusanov.LSP.model.Milk;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.CoreMatchers.is;

public class ShopTest {
    
    private Shop shop;

    private Food food;

    private Long timeForTest;

    @Before
    public void setUp(){
        this.shop = new Shop("TestShop");
        this.food = new Milk("Milk Russian field",
                new GregorianCalendar(2019, Calendar.JUNE, 25),
                new GregorianCalendar(2019, Calendar.JUNE, 17),
                80.50,
                (byte) 0);
        this.timeForTest = 1560760137273L; // 2019, Calendar.JUNE, 17
    }

    @Test
    public void isConditionMatched() {
        Assert.assertThat(shop.isConditionMatched(this.food, this.timeForTest), is (true));
    }

}