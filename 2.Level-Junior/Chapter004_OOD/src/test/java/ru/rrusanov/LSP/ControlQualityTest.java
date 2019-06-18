package ru.rrusanov.LSP;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.rrusanov.LSP.model.Bread;
import ru.rrusanov.LSP.model.Butter;
import ru.rrusanov.LSP.model.Food;
import ru.rrusanov.LSP.model.Milk;
import ru.rrusanov.LSP.model.Yougurt;
import java.util.ArrayList;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.is;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 18.06.2019
 *
 * The class test ControlQuality class.
 */
public class ControlQualityTest {
    /**
     * The field contain instance tested class.
     */
    private ControlQuality controlQuality;
    /**
     * The field contain store instance.
     */
    private Warehouse warehouse;
    /**
     * The field contain store instance.
     */
    private Shop shop;
    /**
     * The field contain store instance.
     */
    private Trash trash;
    /**
     * The field contain collection that contain foods instance.
     */
    private Collection<Food> foods;

    /**
     * The method executes before each test.
     */
    @Before
    public void setUp() {
        this.controlQuality = new ControlQuality(true);
        this.warehouse = new Warehouse("WarehouseTest");
        this.shop = new Shop("ShopTest");
        this.trash = new Trash("TrashTest");
        this.controlQuality.addStore(warehouse);
        this.controlQuality.addStore(shop);
        this.controlQuality.addStore(trash);
        this.foods = new ArrayList<>();
        foods.add(new Bread());
        foods.add(new Butter());
        foods.add(new Milk());
        foods.add(new Yougurt());
    }

    /**
     * The test check processToStore method.
     */
    @Test
    public void whenProcessToStoreCalledThenAllFoodsRelocateToStore() {
        this.controlQuality.processToStore(foods);
        Assert.assertThat(this.warehouse.getAllFood().containsKey("Milk Prostokvashino"), is(true));
        Assert.assertThat(this.shop.getAllFood().containsKey("Yogurt Kolomenski"), is(true));
        Assert.assertThat(this.trash.getAllFood().containsKey("Butter Valio"), is(true));
        Assert.assertThat(this.trash.getAllFood().containsKey("Bread Darnicki"), is(true));
    }

    /**
     * The test check getAllFoods method.
     */
    @Test
    public void whenGetAllFoodsCalledThenAllFoodsAddToCollectionAndStoresClear() {
        this.controlQuality.processToStore(foods);
        this.controlQuality.getAllFoods();
        Assert.assertThat(this.warehouse.getAllFood().size(), is(0));
        Assert.assertThat(this.shop.getAllFood().size(), is(0));
        Assert.assertThat(this.trash.getAllFood().size(), is(0));
        Assert.assertThat(this.trash.getAllFood().size(), is(0));
    }

    /**
     * The test check relocateFoods method.
     */
    @Test
    public void whenRelocateFoodsCalledThenAllStoresClearAndFoodsRelocateToStore() {
        this.controlQuality.processToStore(foods);
        this.controlQuality.relocateFoods();
        Assert.assertThat(this.warehouse.getAllFood().containsKey("Milk Prostokvashino"), is(true));
        Assert.assertThat(this.shop.getAllFood().containsKey("Yogurt Kolomenski"), is(true));
        Assert.assertThat(this.trash.getAllFood().containsKey("Butter Valio"), is(true));
        Assert.assertThat(this.trash.getAllFood().containsKey("Bread Darnicki"), is(true));
    }

    /**
     * The test check addStore method.
     */
    @Test
    public void whenAddStorePassedStoreThenStoreAddedToControl() {
        Assert.assertThat(this.controlQuality.getStore("WarehouseTest"), is(this.warehouse));
        Assert.assertThat(this.controlQuality.getStore("ShopTest"), is(this.shop));
        Assert.assertThat(this.controlQuality.getStore("TrashTest"), is(this.trash));
    }
}