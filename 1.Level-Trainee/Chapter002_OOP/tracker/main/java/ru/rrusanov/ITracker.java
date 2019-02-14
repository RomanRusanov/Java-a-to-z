package ru.rrusanov;

import ru.rrusanov.models.Item;

import java.util.ArrayList;

public interface ITracker {
    Item add(Item item);
    void update(Item itemUpdate);
    void delete(Item item);
    ArrayList<Item> findAll();
    ArrayList<Item> findByName(String key);
    Item findById(String id);
    void printToConsoleItem(ArrayList<Item> item);
    void fieldsUpdate(Item item, Input input);
}
