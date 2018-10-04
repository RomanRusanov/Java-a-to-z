package ru.rrusanov.pools.emailNotification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 3.10.2018
 *
 * The class test EmailNotification.java behavior.
 */
public class EmailNotificationTest {
    /**
     * The instance of tested class.
     */
    private EmailNotification emailNotification;
    /**
     * Section executes before each test.
     */
    @Before
    public void setUp() {
        emailNotification = new EmailNotification();
    }
    /**
     * Test shutdown close.
     */
    @Test
    public void whenCloseCallThenPoolTerminate() {
        emailNotification.close();
        Assert.assertTrue(emailNotification.getPool().isShutdown());
    }
}