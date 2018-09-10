package ru.rrusanov.threads.userStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 14.08.2018
 *
 * The UserStoreTest.java class test behavior for UserStore class.
 */
public class UserStoreTest {
    /**
     * The field contain instance of tested class.
     */
    private UserStore userStore = new UserStore();
    /**
     * The field contain user instance.
     */
    private User user1 = new User(100);
    /**
     * The field contain user instance.
     */
    private User user2 = new User(150);
    /**
     * The method before executes before each test.
     */
    @Before
    public void setUp() {
        this.userStore.add(user1);
        this.userStore.add(user2);
    }
    /**
     * Test method add.
     */
    @Test
    public void whenUsersAddThenExistInCollection() {
        Assert.assertTrue(this.userStore.find(user1));
        Assert.assertTrue(this.userStore.find(user2));
    }
    /**
     * Test method delete.
     */
    @Test
    public void whenUserDeleteThenNotPresentedInCollection() {
        Assert.assertTrue(this.userStore.delete(user1));
        Assert.assertTrue(this.userStore.delete(user2));
        Assert.assertFalse(this.userStore.find(user1));
        Assert.assertFalse(this.userStore.find(user2));
    }
    /**
     * The method test transfer in concurrency behavior. If comment section with join, then test fall.
     * @throws InterruptedException join may throw.
     */
    @Test
    public void transfer() throws InterruptedException {
        /**
          The inner class simulate first thread.
         */
        class TransferThreadUser1ToUser2 extends Thread {
            /**
             * The method run then thread executes.
             */
            @Override
            public void run() {
                Assert.assertTrue(userStore.transfer(user1.getId(), user2.getId(), 70));
            }
        }
        /**
          The inner class simulate second thread.
         */
        class TransferThreadUser2ToUser1 extends Thread {
            /**
             * The method run then thread executes.
             */
            @Override
            public void run() {
                userStore.transfer(user2.getId(), user1.getId(), 70);
            }
        }
        // Assertion
        for (int i = 0; i < 100; i++) {
            TransferThreadUser1ToUser2 transferThread1 = new TransferThreadUser1ToUser2();
            TransferThreadUser2ToUser1 transferThread2 = new TransferThreadUser2ToUser1();
            transferThread1.start();
            transferThread2.start();
            // join section.
            transferThread1.join();
            transferThread2.join();
            Assert.assertEquals(100, this.user1.getAmount());
            Assert.assertEquals(150, this.user2.getAmount());
        }
    }
}