package ru.rrusanov.store;
import ru.rrusanov.store.Store.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StoreTest {

    private Store store = new Store();

    private ArrayList<User> currentList = new ArrayList<>();

    private ArrayList<User> previousList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        User user1 = store.new User("Ivan");
        User user2 = store.new User("Olga");
        User user3 = store.new User("Vladimir");
        User user4 = store.new User("Dmitri");
        User user5 = store.new User("Anna");

        previousList.add(user1);
        previousList.add(user2);
        previousList.add(user3);
        currentList.add(user4);
        currentList.add(user5);
    }

    @Test
    public void diff() {
        Info info = store.diff(previousList, currentList);
    }

    @Test
    public void addedUser() {
    }

    @Test
    public void changedUser() {
    }

    @Test
    public void removedUser() {
    }
}