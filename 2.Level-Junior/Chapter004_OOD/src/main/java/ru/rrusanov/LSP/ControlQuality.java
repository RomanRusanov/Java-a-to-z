package ru.rrusanov.LSP;

import ru.rrusanov.LSP.model.Food;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ControlQuality implements Control {

    private Map stores = new HashMap<String, Store>();

    @Override
    public void processToStore(Collection<Food> foods) {
        for (Food food: foods) {
            Iterator<Store> iterator = ((Iterable<Store>) this.stores.values()).iterator();
            while (iterator.hasNext()) {
                Store currStore = iterator.next();
                if (currStore.isConditionMatched(food)) {
                    currStore.putInStore(food);
                    break;
                }
            }
        }
    }

    public void checkStores() {
        for (Store currStore : (Iterable<Store>) this.stores.values()) {

        }
    }

    public void addStore(Store store) {
        this.stores.put(store.getName(), store);
    }
}
