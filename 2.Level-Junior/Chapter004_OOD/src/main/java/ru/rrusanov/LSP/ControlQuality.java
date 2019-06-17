package ru.rrusanov.LSP;

import ru.rrusanov.LSP.model.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ControlQuality implements Control {
    /**
     * The field contain all stores.
     */
    private Map stores = new HashMap<String, Store>();

    /**
     * The method distributes foods between stores.
     * @param foods Collection contain food.
     */
    @Override
    public void processToStore(Collection<Food> foods) {
        for (Food food: foods) {
            for (Store currStore : ((Iterable<Store>) this.stores.values())) {
                if (currStore.isConditionMatched(food, 0L)) {
                    currStore.putInStore(food);
                    break;
                }
            }
        }
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
