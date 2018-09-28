// A simple semaphore example. 
package ru.rrusanov.pools.exampleFromSchildt.semaphore;
import java.util.concurrent.*;

class SemDemo {

    public static void main(String args[]) {
        Semaphore sem = new Semaphore(1);

        new IncThread(sem, "A");
        new DecThread(sem, "B");

    }
}