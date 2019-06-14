package ru.rrusanov.LSP;

import ru.rrusanov.LSP.model.Food;

import java.util.Collection;

public interface Control {

    void processToStore(Collection<Food> foods);
}
