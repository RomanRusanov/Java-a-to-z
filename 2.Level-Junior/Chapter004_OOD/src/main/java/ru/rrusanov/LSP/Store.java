package ru.rrusanov.LSP;

import ru.rrusanov.LSP.model.Food;

import java.util.HashMap;

public interface Store {

    public boolean putInStore(Food food);

    public Food getFood(String name);

    public HashMap<String, Food> getAllFood();
}
