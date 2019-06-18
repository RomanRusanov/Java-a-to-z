package ru.rrusanov.LSP;

import ru.rrusanov.LSP.model.Food;
import java.util.Collection;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 13.06.2019
 *
 * The interface describe control instance.
 */
public interface Control {
    /**
     * The method move foods to stores.
     * @param foods Collection that contain foods.
     */
    void processToStore(Collection<Food> foods);

    /**
     * The getter for field.
     * @param name Name of store.
     * @return Store instance.
     */
    Store getStore(String name);
}
