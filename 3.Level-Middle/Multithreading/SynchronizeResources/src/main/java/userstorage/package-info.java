/**
 * User.java The class describe User.
 *  User(int id, int amount) The default constructor.
 *  synchronized int getId() The getter for field.
 *  synchronized int getAmount() The getter for field.
 *  synchronized void setAmount(int amount) The setter for field.
 *  boolean equals(Object o) The method check equals two instance.
 *  public int hashCode() The method generate hashcode.
 * UserStorage.java The class describe structure that storage User instance.
 *  synchronized boolean add(User user) The method add user to collection.
 *  synchronized boolean update(User user) The method update user to collection.
 *  synchronized boolean delete(User user) The method delete user in collection.
 *  synchronized boolean isUserExist(User user) The method check
 *   contain user in storage.
 *  synchronized boolean transfer(int fromId, int toId, int amount)
 *   The method transfer amount value from user to user.
 *
 */
package userstorage;