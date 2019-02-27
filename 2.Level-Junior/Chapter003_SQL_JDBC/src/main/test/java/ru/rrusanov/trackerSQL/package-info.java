/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 07.02.2019
 *
 * TrackerSQLTest Class test Tracker.java.
 * Methods:
 *  public void setUp() The method execute before each test.
 *  public void whenConnectionCreateThenReturnTrue() The method check connection to db.
 *  public void whenItemCreateThenItExist() Test if item create then it exist. add() Method behavior check.
 *  public void whenItemsExistThenReturnItemsId() Test if items exist in db. findAll Method behavior check.
 *  public void whenItemPresentThenReturnItemId()
 *   Test if item with specific name exist in db when return id. findByName() Method behavior check.
 *  public void whenItemWithIdExistThenReturnTrue()
 *   Test if item with specific item_id exist in db when return true. findById() Method behavior check.
 *  public void whenPassedIdAndItemThenThatItemIdUpdatedInBD()
 *   Test if passed item_id and item, when item whit what id in bd update data from passed item.
 *
 */
package ru.rrusanov.trackerSQL;