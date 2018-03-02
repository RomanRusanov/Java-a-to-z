package ru.rrusanov.bankTransactions;

import static java.util.Objects.hash;

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
    private double value;
    /**
     * Requisites for bank account.
     */
    private String requisites;

    /**
     * Getter for value field.
     * @return double value.
     */
    public double getValue() {
        return value;
    }

    /**
     * Setter for value.
     * @param value Set value.
     */
    public void setValue(double value) {
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
    /**
     * Override equals method.
     * @param obj object to compare.
     * @return boolean if equal true, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Account temp = (Account) obj;
        return temp.getRequisites().equals(this.getRequisites());
    }

    /**
     * Override hashCode() method.
     * @return int hash sum of all fields instance.
     */
    @Override
    public int hashCode() {
        return hash(this.requisites);
    }
}
