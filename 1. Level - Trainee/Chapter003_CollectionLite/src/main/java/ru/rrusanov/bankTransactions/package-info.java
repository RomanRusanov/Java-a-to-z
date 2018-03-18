/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.02.2018
 *
 * bankTransactions package
 *
 * Bank.java
 *  void addUser(User user) Method add user to collection customers.
 *  void deleteUser(User user) Method delete user from collection customers.
 *  void addAccountToUser(String passport, Account account) Method add account to specific user.
 *  void deleteAccountFromUser(String passport, Account account) Method delete account from specific user.
 *  List<Account> getUserAccounts(String passport) Method return all accounts of specific user.
 *  boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount)
 *      Method transfer money from source user to destination user.
 *  User findUser(String passport) Method return user if an exist in customers collection.
 *  Account findAccount(List<Account> accountList, String requisite) Method return account that contain passed requisites.
 *
 * User.java
 *  String getName() Getter for name field.
 *  void setName(String name) Setter for name field.
 *  String getPassport() Getter for passport field.
 *  void setPassport(String passport) Setter for passport field.
 *  boolean equals(Object obj) Override equals method.
 *  int hashCode() Override hashCode() method.
 *
 * Account.java
 *  double getValue() Getter for value field.
 *  void setValue(double value) Setter for value.
 *  String getRequisites() Getter for requisites field.
 *  void setRequisites(String requisites) Setter for requisites field.
 *  boolean equals(Object obj) Override equals method.
 *  int hashCode() Override hashCode() method.
 */
package ru.rrusanov.bankTransactions;