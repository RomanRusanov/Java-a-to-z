package ru.rrusanov.bomberman;


public class Bomberman {
    public static void main(String[] args) {
        new Thread(new Board()).start();
    }
}
