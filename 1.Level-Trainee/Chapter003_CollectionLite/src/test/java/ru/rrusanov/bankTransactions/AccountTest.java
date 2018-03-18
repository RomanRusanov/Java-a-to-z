package ru.rrusanov.bankTransactions;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.02.2018
 *
 * Class test Account class.
 */
public class AccountTest {
    /**
     * Test for method getValue().
     */
    @Test
    public void thenAccountExistWhenReturnValueField() {
        Account account = new Account(250, "sb12");
        double result = account.getValue();
        Assert.assertThat(250.0, is(result));
    }

    /**
     * Test for method setValue().
     */
    @Test
    public void thenValueUpdatedWhenReturnNewValueField() {
        Account account = new Account(250, "sb12");
        account.setValue(350);
        double result = account.getValue();
        Assert.assertThat(350.0, is(result));
    }

    /**
     * Test for method getRequisites().
     */
    @Test
    public void thenAccountExistWhenReturnRequisitesField() {
        Account account = new Account(250, "sb12");
        String result = account.getRequisites();
        Assert.assertThat("sb12", is(result));
    }

    /**
     * Test for method setRequisites().
     */
    @Test
    public void thenRequisitesUpdatedWhenReturnNewRequisitesField() {
        Account account = new Account(250, "sb12");
        account.setRequisites("sb15");
        String result = account.getRequisites();
        Assert.assertThat("sb15", is(result));
    }
    /**
     * Test for method equals().
     */
    @Test
    public void thenInstanceEqualsWhenReturnTrue() {
        Account account1 = new Account(250, "sb14");
        Account account2 = new Account(0, "sb14");
        Assert.assertEquals(account1, account2);
    }

    /**
     * Test for method hashCode().
     */
    @Test
    public void thenInstanceEqualsWhenHashCodeEquals() {
        Account account1 = new Account(250, "sb14");
        Account account2 = new Account(0, "sb14");
        int account1Hash = account1.hashCode();
        int account2Hash = account2.hashCode();
        Assert.assertEquals(account1Hash, account2Hash);
        account2 = new Account(350, "sb15");
        account2Hash = account2.hashCode();
        Assert.assertNotEquals(account1Hash, account2Hash);
    }
}