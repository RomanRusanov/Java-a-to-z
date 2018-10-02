package ru.rrusanov.pools.exampleFromSchildt.phaser;

import java.util.concurrent.Phaser;

class PhaserDemo {
    public static void main(String args[]) {
        // One parties main Thread.
        Phaser phsr = new Phaser(1);
        int curPhase;

        System.out.println("Starting");

        new Thread(new MyThread(phsr, "A")).start();
        new Thread(new MyThread(phsr, "B")).start();
        new Thread(new MyThread(phsr, "C")).start();

        // Wait for all threads to complete phase one.
        curPhase = phsr.getPhase();
        System.out.println(phsr.arriveAndAwaitAdvance());

        System.out.println("Phase " + curPhase + " Complete");

        // Wait for all threads to complete phase two.
        curPhase =  phsr.getPhase();
        System.out.println(phsr.arriveAndAwaitAdvance());
        System.out.println("Phase " + curPhase + " Complete");

        curPhase =  phsr.getPhase();
        System.out.println(phsr.arriveAndAwaitAdvance());
        System.out.println("Phase " + curPhase + " Complete");

        // Deregister the main thread.
        phsr.arriveAndDeregister();

        if(phsr.isTerminated()) {
            System.out.println("The Phaser is terminated");
            System.out.println(phsr.getPhase());
        }
    }
}  