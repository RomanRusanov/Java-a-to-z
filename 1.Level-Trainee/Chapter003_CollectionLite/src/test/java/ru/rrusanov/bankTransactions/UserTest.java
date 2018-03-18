package ru.rrusanov.bankTransactions;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.02.2018
 *
 * Class test User class.
 */
public class UserTest {
    /**
     * Test for method getName().
     */
    @Test
    public void thenUserExistWhenReturnFieldName() {
        User user1 = new User("Ivan", "12345");
        String result = user1.getName();
        Assert.assertThat(result, is("Ivan"));
    }

    /**
     * Test for method setName().
     */
    @Test
    public void thenNameChangedWhenNameFieldUpdated() {
        User user1 = new User("Ivan", "12345");
        user1.setName("Mihail");
        String result = user1.getName();
        Assert.assertThat(result, is("Mihail"));
    }

    /**
     * Test for method getPassport().
     */
    @Test
    public void thenUserExistWhenReturnFieldPassport() {
        User user1 = new User("Ivan", "12345");
        String result = user1.getPassport();
        Assert.assertThat(result, is("12345"));
    }

    /**
     * Test for method setPassport().
     */
    @Test
    public void thenNameChangedWhenPassportFieldUpdated() {
        User user1 = new User("Ivan", "12345");
        user1.setPassport("54321");
        String result = user1.getPassport();
        Assert.assertThat(result, is("54321"));
    }

    /**
     * Test for method equals().
     */
    @Test
    public void thenInstanceEqualsWhenReturnTrue() {
        User user1 = new User("Ivan", "12345");
        User user2 = new User("Ivan", "12345");
        Assert.assertEquals(user1, user2);
    }

    /**
     * Test for method hashCode().
     */
    @Test
    public void thenInstanceEqualsWhenHashCodeEquals() {
        User user1 = new User("Ivan", "12345");
        User user2 = new User("Ivan", "12345");
        int user1Hash = user1.hashCode();
        int user2Hash = user2.hashCode();
        Assert.assertEquals(user1Hash, user2Hash);
        user2 = new User("Mikhail", "12345");
        user2Hash = user2.hashCode();
        Assert.assertNotEquals(user1Hash, user2Hash);
    }
}