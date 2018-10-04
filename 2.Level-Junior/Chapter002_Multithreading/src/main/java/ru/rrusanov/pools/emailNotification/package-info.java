/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 3.10.2018
 *
 *  User.java class explain user state.
 *   public String getName() The method getter for name field.
 *   public String getEmail() The method getter for email field.
 *   public boolean equals(Object obj) The method compare to user object.
 *   public int hashCode() The method return hash value for user instance.
 *
 *  EmailNotification.java class implement behavior logic sending emails to users.
 *    public void emailTo(User user) The method make template subject and bode, and run method send.
 *    public void close() The method terminate thread pool.
 *    public ExecutorService getPool() The getter for field.
 */
package ru.rrusanov.pools.emailNotification;