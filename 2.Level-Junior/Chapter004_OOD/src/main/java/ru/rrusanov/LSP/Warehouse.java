package ru.rrusanov.LSP;

import ru.rrusanov.LSP.model.Food;

import java.util.HashMap;

public class Warehouse implements Store {

    private HashMap<String, Food> container = new HashMap<>();

    private String name;

    public Warehouse(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void putInStore(Food food) {
        this.container.put(food.getName(), food);
    }

    @Override
    public HashMap<String, Food> getAllFood() {
        return this.container;
    }

    @Override
    public boolean removeFromStore(String name) {
        return this.container.remove(name, this.container.get(name));
    }

    @Override
    public boolean isConditionMatched(Food food, Long passedTime) {
        boolean result = false;
        Long currentTime = passedTime == 0L ? System.currentTimeMillis(): passedTime;
        long createTime = food.getCreateDate().getTimeInMillis();
        Long expireTime = food.getExpireDate().getTimeInMillis();
        double percent75 = (expireTime - createTime) * 0.75;
        if (expireTime - currentTime > percent75) {
            result = true;
        }
        return result;
    }
}
