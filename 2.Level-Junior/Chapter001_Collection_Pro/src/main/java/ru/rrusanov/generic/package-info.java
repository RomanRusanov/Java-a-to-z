/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 06.06.2018
 *
 *  AbstractStore.java Universal store class.
 *   void add(T model) Method add model to collection.
 *   boolean replace(String id, T model) The method replace new value model to existing id.
 *   public Base findById(String id) throws UserNotFoundException, RoleNotFoundException The method find in collection model by id string.
 *
 *  Base.java Base class.
 *   String getId() The method Getter return id.
 *
 *  Role.java Role class.
 *   String getId() The method Getter return id.
 *   boolean equals(Object obj) The method compare Role object by field id.
 *   int hashCode() The method return hash of that object.
 *
 *  NotFoundException.java If id not presented in store.
 *   NotFoundException(String msg) Constructor return to parent string with exception.
 *
 *  RoleStore.java Collection Role class.
 *   void add(T model) Method add model to collection.
 *   boolean replace(String id, T model) The method replace new value model to existing id.
 *   public Base findById(String id) throws UserNotFoundException, RoleNotFoundException The method find in collection model by id string.
 *
 *  Store.java Interface Store.
 *   void add(T model) Method add model to collection.
 *   boolean replace(String id, T model) The method replace new value model to existing id.
 *   public Base findById(String id) throws UserNotFoundException, RoleNotFoundException The method find in collection model by id string.
 *
 *  User.java User class.
 *   String getId() The method Getter return id.
 *   boolean equals(Object obj) The method compare Role object by field id.
 *   int hashCode() The method return hash of that object.
 *
 *  UserStore.java Collection User class.
 *   void add(T model) Method add model to collection.
 *   boolean replace(String id, T model) The method replace new value model to existing id.
 *   public Base findById(String id) throws UserNotFoundException, RoleNotFoundException The method find in collection model by id string.
 */
package ru.rrusanov.generic;