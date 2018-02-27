package ru.rrusanov.BankTransactions;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.02.2018
 *
 * Class define Account of users.
 */
public class Account {
    /**
     * Default constructor.
     * @param value Sum of money for account.
     * @param requisites Bank requisites for account.
     */
    public Account(int value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Value for money sum this account.
     */
    private int value;
    /**
     * Requisites for bank account.
     */
    private String requisites;

    /**
     * Getter for value field.
     * @return int value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Setter for value.
     * @param value Set value.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Getter for requisites field.
     * @return String requisites for this account.
     */
    public String getRequisites() {
        return requisites;
    }

    /**
     * Setter for requisites field.
     * @param requisites String to set field.
     */
    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }
}
