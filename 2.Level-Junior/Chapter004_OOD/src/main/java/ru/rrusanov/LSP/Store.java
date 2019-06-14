package ru.rrusanov.LSP;

import ru.rrusanov.LSP.model.Food;

import java.util.HashMap;

public interface Store {

    String getName();

    void putInStore(Food food);

    Food getFood(String name);

    HashMap<String, Food> getAllFood();

    boolean removeFromStore(String name);

    boolean isConditionMatched(Food food);
}
