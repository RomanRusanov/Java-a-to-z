package ru.rrusanov.bankTransactions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.02.2018
 *
 * Class define Bank.
 */
public class Bank {
    /**
     * Collection customers contain users and account this users. Each user may have more than one account.
     */
    private HashMap<User, ArrayList<Account>> customers;
    /**
     * Default constructor.
     */
    public Bank() {
        this.customers = new HashMap<>();
    }
    /**
     * Getter for customers field.
     * @return customers field/
     */
    public HashMap<User, ArrayList<Account>> getCustomers() {
        return customers;
    }
    /**
     * Method add user to collection customers.
     * @param user User to adding.
     */
    public void addUser(User user) {
        customers.put(user, null);
    }
    /**
     * Method delete user from collection customers.
     * @param user User to delete.
     */
    public void deleteUser(User user) {
        customers.remove(user);
    }

    /**
     * Method add account to specific user.
     * @param passport Specific user to find.
     * @param account Account to adding user by matching passport field.
     */
    public void addAccountToUser(String passport, Account account) {
        this.customers.keySet().stream()
            .filter(key -> key.getPassport().equals(passport))  // get User
            .map(key -> this.customers.get(key))                // get ArrayList<Account>
            .forEach(arrListAcc ->                              // add in collection
                this.customers.putIfAbsent(this.findUser(passport), update.apply(arrListAcc, account)
            )
        );
    }
    /**
     * Function use in addAccountToUser method.
     */
    BiFunction<ArrayList<Account>, Account, ArrayList<Account>> update = ((list, account) -> {
        /**
         * Function check if ArrayList<Account> equals null, then create new instance ArrayList<Account> and when add
         * account instance in ArrayList. Otherwise add instance account in existing ArrayList.
         */
        ArrayList<Account> result;
        result = new ArrayList<>();
        if (list != null) {
            result = list;
        }
        result.add(account);
        return result;
    });
    /**
     * Method delete account from specific user.
     * @param passport Specific user to find.
     * @param account Account to deleting user by matching passport field.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        this.customers.keySet().stream()
                .filter(key -> key.getPassport().equals(passport))  // get User
                .map(key -> this.customers.get(key))                // get AccountArrayList<Account>
                .forEach(acc -> acc.remove(account));               // delete in collection
    }

    /**
     * Method return all accounts of specific user.
     * @param passport Specific user to find.
     * @return List of accounts user by matching passport field.
     */
    public List<Account> getUserAccounts(String passport) {
        return this.customers.keySet().stream()
                .filter(key -> key.getPassport().equals(passport))  // get User
                .map(key -> this.customers.get(key))                // get ArrayList<Account>
                .findFirst().get();                                 // return ArrayList<Account>
    }

    /**
     * Method transfer money from source user to destination user.
     * @param srcPassport source user use passport to identity.
     * @param srcRequisite source account use requisites to identity.
     * @param destPassport destination user use passport to identity.
     * @param destRequisite destination account use requisites to identity.
     * @param amount sum money to transfer source to destination.
     * @return If successful return true. If money source account not enough return false.
     */
    public boolean transferMoney(String srcPassport,
                                 String srcRequisite,
                                 String destPassport,
                                 String destRequisite,
                                 double amount) {
        boolean result = false;
        List<Account> accountListSrc = this.getUserAccounts(srcPassport);
        Account srcAccount = this.findAccount(accountListSrc, srcRequisite);
        if (srcAccount.getValue() >= amount) {
            List<Account> accountListDest = this.getUserAccounts(destPassport);
            Account destAccount = this.findAccount(accountListDest, destRequisite);
            srcAccount.setValue(srcAccount.getValue() - amount);
            destAccount.setValue(destAccount.getValue() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Method return user if an exist in customers collection.
     * @param passport Unique string for users.
     * @return User if exist, otherwise return User(name"-1", passport"-1").
     */
    public User findUser(String passport) {
        return this.customers.keySet().stream()
                .filter(key -> key.getPassport().equals(passport))  // get User
                .findFirst().get();                                 // return User
    }

    /**
     * Method return account that contain passed requisites.
     * @param accountList Collection accounts to find.
     * @param requisite Unique string in account.
     * @return math account.
     */
    public Account findAccount(List<Account> accountList, String requisite) {
        return accountList.stream()
                .filter(acc -> acc.getRequisites().equals(requisite))   // get Account
                .findFirst().get();                                     // return Account
    }
}
