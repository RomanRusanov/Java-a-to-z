package ru.rrusanov.pools.exampleFromSchildt.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new Thread(new LockThread(lock, "A")).start();
        new Thread(new LockThread(lock, "B")).start();
    }
}

//A shared resource.
class Shared {
    static int count = 0;
}

class LockThread implements Runnable {
    String name;
    ReentrantLock lock;

    LockThread(ReentrantLock lock, String name) {
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Starting " + this.name);
        try {
            //First lock count.
            System.out.println(this.name + " is waiting to lock count.");
            this.lock.lock();
            System.out.println(this.name + " is locking count.");
            Shared.count++;
            System.out.println(this.name + ": " + Shared.count);

            //Allow a context switch.
            System.out.println(this.name + " is sleeping.");
            Thread.sleep(1000);
        }catch(InterruptedException exc){
            System.out.println(exc);
        } finally {
            //Unlock.
            System.out.println(this.name + " is unlocking count.");
            lock.unlock();
        }
    }
}