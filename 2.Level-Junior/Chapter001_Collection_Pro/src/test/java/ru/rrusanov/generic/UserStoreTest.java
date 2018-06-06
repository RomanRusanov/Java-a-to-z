package ru.rrusanov.generic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 06.06.2018
 *
 * Class test UserStore.java class.
 */
public class UserStoreTest {
    /**
     * Instance UserStore.
     */
    private UserStore<User> userStore = new UserStore<>();
    /**
     * Instance new User.
     */
    private User expect = new User("13");
    /**
     * Section execute before each tests.
     */
    @Before
    public void setUp() {
        userStore.add(expect);
    }
    /**
     * Test replace one user to other.
     */
    @Test (expected = userNotFoundException.class)
    public void thenReplaceUserWhenOldValueNotExist() {
    userStore.replace("13", new User("3"));
    userStore.findById("13");
    }
    /**
     * Test add & findById method.
     */
    @Test
    public void thenUserExistWhenReturnUser()  {
        Base result = userStore.findById("13");
        Assert.assertEquals(expect, result);
    }
    /**
     * Test if user not found must throw exception.
     */
    @Test (expected = userNotFoundException.class)
    public void thenUserNotFoundThrowException()  {
        User expectForException = new User("10");
        userStore.add(expectForException);
        Base result = userStore.findById("11");
        Assert.assertEquals(expectForException, result);
    }
}