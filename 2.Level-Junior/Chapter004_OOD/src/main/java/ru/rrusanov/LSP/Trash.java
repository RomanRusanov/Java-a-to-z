package ru.rrusanov.LSP;

import ru.rrusanov.LSP.model.Food;

import java.util.HashMap;

public class Trash implements Store {

    private HashMap<String, Food> container = new HashMap<>();

    private String name;

    public Trash(String name) {
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
    public Food getFood(String name) {
        return null;
    }

    @Override
    public HashMap<String, Food> getAllFood() {
        return null;
    }

    @Override
    public boolean removeFromStore(String name) {
        return this.container.remove(name, this.container.get(name));
    }

    @Override
    public boolean isConditionMatched(Food food) {
        boolean result = false;
        Long currentTime = System.currentTimeMillis();
        Long expireTime = food.getExpireDate().getTimeInMillis();
        if (currentTime < expireTime) {
            result = true;
        }
        return result;
    }
}
