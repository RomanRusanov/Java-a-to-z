package ru.rrusanov.store;
import org.junit.Assert;
import ru.rrusanov.store.Store.User;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 26.07.2018
 *
 * The class test Store and inner class User.
 */
public class StoreTest {
    /**
     * The field contains instance of tested class.
     */
    private Store store = new Store();
    /**
     * The field contains current list.
     */
    private ArrayList<User> currentList = new ArrayList<>();
    /**
     * The field contains previous list.
     */
    private ArrayList<User> previousList = new ArrayList<>();
    /**
     * The field contains user stored previous list.
     */
    private User user1 = store.new User("Ivan");
    /**
     * The field contains user stored previous list.
     */
    private User user2 = store.new User("Olga");
    /**
     * The field contains user stored previous list.
     */
    private User user3 = store.new User("Vladimir");
    /**
     * The field contains user stored current list.
     */
    private User user4 = store.new User("Dmitri");
    /**
     * The field contains user stored current list.
     */
    private User user5 = store.new User("Anna");
    /**
     * The field contains user stored current list. That user be changed name to imitate edited User instance.
     */
    private User user6 = store.new User("Vika");
    /**
     * The field contains instance that stored what changes be between current and previous list.
     */
    private Info info;
    /**
     * The method executes before each tests.
     */
    @Before
    public void setUp() {
        this.previousList.add(user1);
        this.previousList.add(user2);
        this.previousList.add(user3);
        this.currentList.add(user4);
        this.currentList.add(user5);
        this.currentList.add(user6);
        this.user6.setId(user2.getId());
        info = store.diff(previousList, currentList);

    }
    /**
     * The test check method addUser().
     */
    @Test
    public void whenUsersNotInPreviousListThenItAddedToCurrent() {
        Assert.assertTrue(info.getAdded().contains(user4));
        Assert.assertTrue(info.getAdded().contains(user5));
        Assert.assertTrue(info.getAdded().contains(user6));
    }
    /**
     * The test check method changedUser().
     */
    @Test
    public void whenIdSameAndNameNotThenUserBeChanged() {
        Assert.assertTrue(info.getChanged().contains(user6));
    }
    /**
     * The test check method removedUser().
     */
    @Test
    public void whenUsersNotInCurrentListThenItRemoved() {
        Assert.assertTrue(info.getRemoved().contains(user1));
        Assert.assertTrue(info.getRemoved().contains(user2));
        Assert.assertTrue(info.getRemoved().contains(user3));
    }
}