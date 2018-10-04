package ru.rrusanov.bomberman;

import java.util.concurrent.locks.ReentrantLock;

public class Board {

    private final ReentrantLock[][] board = new ReentrantLock[10][10];

    private Hero hero = new Hero(new Cell(0, 0));

    public boolean move(Cell source, Cell dist) {
        return false;
    }
}
