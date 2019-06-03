package ru.rrusanov.LSP;

import ru.rrusanov.LSP.model.Food;

import java.util.HashMap;

public class Trash implements Store {
    @Override
    public boolean putInStore(Food food) {
        return false;
    }

    @Override
    public Food getFood(String name) {
        return null;
    }

    @Override
    public HashMap<String, Food> getAllFood() {
        return null;
    }
}
