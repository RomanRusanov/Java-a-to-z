package userstorage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * The class check behavior UserStorage.java.
 */
class UserStorageTest {
    /**
     * The field contain instance of test class.
     */
    private UserStorage userStorage;
    /**
     * The field contain instance user1.
     */
    private User user1;
    /**
     * The field contain instance user2.
     */
    private User user2;

    /**
     * The method execute before each test.
     */
    @BeforeEach
    public void setup() {
        userStorage = new UserStorage();
        user1 = new User(1, 150);
        user2 = new User(2, 100);
        userStorage.add(user1);
        userStorage.add(user2);
    }
    /**
     * The test check method transfer.
     */
    @Test
    public void whenAmountTransferThenAmountChange() {
        userStorage.transfer(user1.getId(), user2.getId(), 100);
        assertEquals(50, user1.getAmount());
        assertEquals(200, user2.getAmount());
    }

    /**
     * The test check if user with unique id exist in storage
     * when can't add user with that id.
     */
    @Test
    public void whenUserExistThenAddReturnFalse() {
        assertFalse(userStorage.add(new User(1, 100)));
    }

    /**
     * The test check if user update when storage contain new user.
     */
    @Test
    void whenUpdateUserWhenInStoragePresentNewInstanceUser() {
        User user3 = new User(1, 180);
        userStorage.update(user3);
        assertFalse(userStorage.isUserExist(user1));
    }

    /**
     * The test check if remove user when it not present in storage.
     */
    @Test
    void whenDeleteUserThenItNotExistInStorage() {
        User user4 = new User(4, 1080);
        userStorage.delete(user4);
        assertFalse(userStorage.isUserExist(user4));
    }
}