package ru.rrusanov.seaBattle;

public interface Ship {

    int getNumberPointsOnBoard();

    Directions getDirectionOnBoard();

    int getMaxValueShipOnBoard();

    int getID();
}
