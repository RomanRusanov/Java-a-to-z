package ru.rrusanov.pools.exampleFromSchildt.phaser;
import java.util.concurrent.Phaser;

class MyThread implements Runnable {
    Phaser phsr;
    String name;

    MyThread(Phaser p, String n) {
        phsr = p;
        name = n;
        // Add this thread(parties) to phaser. If comment next line need psvm method in phaser constructor
        // change 1 to 4 and explicit indicate, we use 4 thread in this phaser.
        phsr.register();
    }

    public void run() {

        System.out.println("Thread " + name + " Beginning Phase One");
        phsr.arriveAndAwaitAdvance(); // Signal arrival.
        // Pause a bit to prevent jumbled output. This is for illustration
        // only. It is not required for the proper opration of the phaser.
        try {
            Thread.sleep(10);
        } catch(InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread " + name + " Beginning Phase Two");
        phsr.arriveAndAwaitAdvance(); // Signal arrival.

        // Pause a bit to prevent jumbled output. This is for illustration
        // only. It is not required for the proper opration of the phaser.
        try {
            Thread.sleep(10);
        } catch(InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread " + name + " Beginning Phase Three");
        phsr.arriveAndDeregister(); // Signal arrival and deregister.
    }
}