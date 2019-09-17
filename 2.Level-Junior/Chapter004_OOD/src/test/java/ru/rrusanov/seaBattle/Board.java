package ru.rrusanov.seaBattle;

import java.util.Map;

public interface Board {

    public int getMaxXDimensionBoard();

    public int getMaxYDimensionBoard();

    public void addShipOnBoard(Ship ship);

    public void removeShipFromBoard(Point point);

    public Map<Integer,Ship> getAllShips();

    public boolean checkPoint(Point point);
}
