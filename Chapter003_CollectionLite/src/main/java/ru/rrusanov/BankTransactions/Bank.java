package ru.rrusanov.BankTransactions;

import java.util.List;
import java.util.Map;

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
    private Map<User, List<Account>> customers;

    /**
     * Getter for customers field.
     * @return customers field/
     */
    public Map<User, List<Account>> getCustomers() {
        return customers;
    }

}
