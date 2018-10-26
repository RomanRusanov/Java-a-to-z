package ru.rrusanov.switcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

import static org.junit.Assert.*;

public class ContainerTest {

    private Container container = new Container();

    private ReentrantLock lock = new ReentrantLock(true);

    @Before
    public void setUp() {

    }

    @Test
    public void add() {
    }

    @Test
    public void getStoredString() {
    }

    @Test
    public void isSame() {
    }

    @Test
    public void switcher() {
        new Thread(new Creator(lock, container, 1)).start();
        new Thread(new Creator(lock, container, 2)).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String expect = "1111111111222222222211111111112222222222111111111122222222221111111111222222222211111111112222222222";
        Assert.assertEquals(expect, this.container.getStoredString().toString());
    }
}