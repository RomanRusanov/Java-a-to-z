package ru.rrusanov.BankTransactions;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 28.02.2018
 *
 * Class test Bank class.
 */
public class BankTest {

    @Test
    public void getCustomers() {
    }

    @Test
    public void addUser() {
    }

    @Test
    public void deleteUser() {
    }
    /**
     * Test for method addAccountToUser().
     */
    @Test
    public void thenPassAccountToAddWhenAccountAddedInCollection() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "IvanPassport");
        Account account1 = new Account(250, "account1");
        Account account2 = new Account(50, "account2");
        bank.addUser(user1);
        bank.addAccountToUser("IvanPassport", account1);
        bank.addAccountToUser("IvanPassport", account2);
        HashMap<User, ArrayList<Account>> customers = bank.getCustomers();
        int sizeAccountsArray = customers.get(user1).size();
        Assert.assertThat(sizeAccountsArray, is(2));
    }
    /**
     * Test for method deleteAccountToUser().
     */
    @Test
    public void thenPassAccountToDeleteWhenAccountRemoveFromCollection() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "IvanPassport");
        Account account1 = new Account(250, "account1");
        Account account2 = new Account(50, "account2");
        bank.addUser(user1);
        bank.addAccountToUser("IvanPassport", account1);
        bank.addAccountToUser("IvanPassport", account2);
        HashMap<User, ArrayList<Account>> customers = bank.getCustomers();
        bank.deleteAccountFromUser("IvanPassport", account1);
        int sizeAccountsArray = customers.get(user1).size();
        Assert.assertThat(sizeAccountsArray, is(1));
    }
    /**
     * Test for method getUserAccounts().
     */
    @Test
    public void thenUserExistWhenReturnAccountList() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "IvanPassport");
        Account account1 = new Account(250, "account1");
        Account account2 = new Account(50, "account2");
        bank.addUser(user1);
        bank.addAccountToUser("IvanPassport", account1);
        bank.addAccountToUser("IvanPassport", account2);
        HashMap<User, ArrayList<Account>> customers = bank.getCustomers();
        List<Account> result = bank.getUserAccounts("IvanPassport");
        List<Account> expect = Arrays.asList(account1, account2);
        Assert.assertThat(result, is(expect));
    }
}