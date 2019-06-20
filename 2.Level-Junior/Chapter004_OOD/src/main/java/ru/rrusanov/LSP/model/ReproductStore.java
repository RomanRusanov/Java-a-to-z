package ru.rrusanov.LSP.model;

import ru.rrusanov.LSP.Store;

import java.util.HashMap;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 20.06.2019
 * <p>
 * The class .
 */
public class ReproductStore implements Store {
    /**
     * The getter for field.
     *
     * @return String.
     */
    @Override
    public String getName() {
        return null;
    }

    /**
     * The method add food to store container.
     *
     * @param food Instance.
     */
    @Override
    public void putInStore(Food food) {

    }

    /**
     * The getter for field.
     *
     * @return HashMap<String, Food> Instance.
     */
    @Override
    public HashMap<String, Food> getAllFood() {
        return null;
    }

    /**
     * The method remove Store from control.
     *
     * @param name Name of store instance.
     * @return if removed return true, otherwise false.
     */
    @Override
    public boolean removeStore(String name) {
        return false;
    }

    /**
     * The method check matched this store for passed food instance.
     *
     * @param food       Instance to check.
     * @param passedTime use system time, or use fixed time for unit test.
     * @return return true if match, otherwise false.
     */
    @Override
    public boolean isConditionMatched(Food food, Long passedTime) {
        FoodWrapper foodWrapper = (FoodWrapper) food;
        return foodWrapper.isCanReproduct();
    }
}
