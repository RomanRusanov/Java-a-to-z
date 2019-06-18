package ru.rrusanov.LSP;

import ru.rrusanov.LSP.model.Food;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 4.06.2019
 *
 * The class describe ControlQuality instance.
 */
public class ControlQuality implements Control {
    /**
     * The field contain all stores.
     */
    private Map stores = new HashMap<String, Store>();
    /**
     * The field contain long value for test instance. If instance equals 0L then be use system time in milliseconds.
     */
    private Long timeForTest;

    /**
     * The constructor.
     * @param test if pass true, when be used 1560760137273L value for timeForTest field to provide unit test.
     *             if pass false, when use system time for current time.
     */
    public ControlQuality(boolean test) {
        this.timeForTest = test ? 1560760137273L : 0L; // 2019, Calendar.JUNE, 17
    }

    /**
     * The method distributes foods between stores.
     * @param foods Collection contain food.
     */
    @Override
    public void processToStore(Collection<Food> foods) {
        for (Food food: foods) {
            for (Store currStore : ((Iterable<Store>) this.stores.values())) {
                if (currStore.isConditionMatched(food, this.timeForTest)) {
                    currStore.putInStore(food);
                    break;
                }
            }
        }
    }

    /**
     * The getter for field.
     * @param name Name of store.
     * @return Store instance.
     */
    @Override
    public Store getStore(String name) {
        return (Store) this.stores.get(name);
    }

    /**
     * The method get all food from all possible store and clear stores.
     * @return Collection contain all foods.
     */
    public Collection<Food> getAllFoods() {
        ArrayList<Food> result = new ArrayList<>();
        for (Store currStore : (Iterable<Store>) this.stores.values()) {
            result.addAll(currStore.getAllFood().values());
            currStore.getAllFood().clear();
        }
        return result;
    }

    /**
     * The method relocate all foods by store(check expire date).
     */
    public void relocateFoods() {
        processToStore(this.getAllFoods());
    }

    /**
     * The method add store to control.
     * @param store store class.
     */
    public void addStore(Store store) {
        this.stores.put(store.getName(), store);
    }
}