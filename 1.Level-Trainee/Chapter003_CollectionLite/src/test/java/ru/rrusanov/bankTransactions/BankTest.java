package ru.rrusanov.bankTransactions;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 28.02.2018
 *
 * Class test Bank class.
 */
public class BankTest {
    /**
     * Test for method getCustomers().
     */
    @Test
    public void thenBankInstantiateWhenReferenceCustomersNotNull() {
        Bank bank = new Bank();
        Assert.assertNotNull(bank.getCustomers());
    }
    /**
     * Test for method addUser().
     */
    @Test
    public void thenUserAddedWhenCollectionNotEmpty() {
        Bank bank = new Bank();
        HashMap<User, ArrayList<Account>> customers = bank.getCustomers();
        User user1 = new User("Ivan", "IvanPassport");
        Assert.assertTrue(customers.isEmpty());
        bank.addUser(user1);
        Assert.assertFalse(customers.isEmpty());
    }
    /**
     * Test for method deleteUser().
     */
    @Test
    public void thenUserDeleteWhenItRemoveFromCollection() {
        Bank bank = new Bank();
        HashMap<User, ArrayList<Account>> customers = bank.getCustomers();
        User user1 = new User("Ivan", "IvanPassport");
        bank.addUser(user1);
        Assert.assertFalse(customers.isEmpty());
        bank.deleteUser(user1);
        Assert.assertTrue(customers.isEmpty());
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
        List<Account> result = bank.getUserAccounts("IvanPassport");
        List<Account> expect = Arrays.asList(account1, account2);
        Assert.assertThat(result, is(expect));
    }
    /**
     * Test for method transferMoney().
     */
    @Test
    public void thenMoneyEnoughForTransferWhenReturnTrue() {
        String srcPassport = "IvanPassport";
        String srcRequisite = "sb14";
        String destPassport = "VladimirPassport";
        String destRequisite = "sb16";
        double amount = 150;
        Bank bank = new Bank();
        bank.addUser(new User("Ivan",  srcPassport));
        bank.addUser(new User("Vladimir", destPassport));
        Account account1 = new Account(250, srcRequisite);
        Account account2 = new Account(250, destRequisite);
        bank.addAccountToUser(srcPassport, account1);
        bank.addAccountToUser(destPassport, account2);
        Assert.assertTrue(bank.transferMoney(srcPassport, srcRequisite, destPassport, destRequisite, amount));
        Assert.assertThat(account1.getValue(), is(100.0));
        Assert.assertThat(account2.getValue(), is(400.0));
        Assert.assertFalse(bank.transferMoney(srcPassport, srcRequisite, destPassport, destRequisite, amount));
    }
}