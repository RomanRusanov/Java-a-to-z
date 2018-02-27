package ru.rrusanov.BankTransactions;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.02.2018
 *
 * Class test Account class.
 */
public class AccountTest {
    /**
     * Test for getValue.
     */
    @Test
    public void thenAccountExistWhenReturnValueField() {
        Account account = new Account(250, "sb12");
        int result = account.getValue();
        Assert.assertThat(250, is(result));
    }

    /**
     * Test for setValue.
     */
    @Test
    public void thenValueUpdatedWhenReturnNewValueField() {
        Account account = new Account(250, "sb12");
        account.setValue(350);
        int result = account.getValue();
        Assert.assertThat(350, is(result));
    }

    /**
     * Test for getRequisites.
     */
    @Test
    public void thenAccountExistWhenReturnRequisitesField() {
        Account account = new Account(250, "sb12");
        String result = account.getRequisites();
        Assert.assertThat("sb12", is(result));
    }

    /**
     * Test for setRequisites.
     */
    @Test
    public void thenRequisitesUpdatedWhenReturnNewRequisitesField() {
        Account account = new Account(250, "sb12");
        account.setRequisites("sb15");
        String result = account.getRequisites();
        Assert.assertThat("sb15", is(result));
    }
}