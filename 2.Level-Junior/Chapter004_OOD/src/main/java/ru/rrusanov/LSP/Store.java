package ru.rrusanov.LSP;

import ru.rrusanov.LSP.model.Food;
import java.util.HashMap;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 4.06.2019
 *
 * The interface describe store instance.
 */
public interface Store {
    /**
     * The getter for field.
     * @return String.
     */
    String getName();

    /**
     * The method add food to store container.
     * @param food Instance.
     */
    void putInStore(Food food);

    /**
     * The getter for field.
     * @return HashMap<String, Food> Instance.
     */
    HashMap<String, Food> getAllFood();

    /**
     * The method remove Store from control.
     * @param name Name of store instance.
     * @return if removed return true, otherwise false.
     */
    boolean removeFood(String name);

    /**
     * The method check matched this store for passed food instance.
     * @param food Instance to check.
     * @param passedTime use system time, or use fixed time for unit test.
     * @return return true if match, otherwise false.
     */
    boolean isConditionMatched(Food food, Long passedTime);
}
