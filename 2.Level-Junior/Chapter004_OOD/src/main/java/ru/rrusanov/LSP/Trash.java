package ru.rrusanov.LSP;

import ru.rrusanov.LSP.model.Food;
import java.util.HashMap;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 4.06.2019
 *
 * The class describe Trash store instance.
 */
public class Trash implements Store {
    /**
     * The field contain all foods instance.
     */
    private HashMap<String, Food> container = new HashMap<>();
    /**
     * The field contain name store.
     */
    private String name;

    /**
     * The constructor.
     * @param name Instance name.
     */
    public Trash(String name) {
        this.name = name;
    }

    /**
     * The getter for field.
     * @return String.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * The method add food to store container.
     * @param food Instance.
     */
    @Override
    public void putInStore(Food food) {
        this.container.put(food.getName(), food);
    }

    /**
     * The getter for field.
     * @return HashMap<String, Food> Instance.
     */
    @Override
    public HashMap<String, Food> getAllFood() {
        return this.container;
    }

    /**
     * The method remove food from.
     *
     * @param name Name of food instance.
     * @return if removed return true, otherwise false.
     */
    @Override
    public boolean removeFood(String name) {
        return this.container.remove(name, this.container.get(name));
    }

    /**
     * The method check matched this store for passed food instance.
     * @param food Instance to check.
     * @param passedTime use system time, or use fixed time for unit test.
     * @return return true if match, otherwise false.
     */
    @Override
    public boolean isConditionMatched(Food food, Long passedTime) {
        boolean result = false;
        Long currentTime = passedTime == 0L ? System.currentTimeMillis() : passedTime;
        Long expireTime = food.getExpireDate().getTimeInMillis();
        if (currentTime > expireTime) {
            result = true;
        }
        return result;
    }
}