package ru.rrusanov.BankTransactions;

import java.util.List;
import java.util.Map;

abstract class UserActions extends Bank{
    /**
     * Customer reference.
     */
    private Map<User, List<Account>> customers;
    /**
     * Default constructor.
     */
    public UserActions(){
        this.customers =  super.getCustomers();
    }
}