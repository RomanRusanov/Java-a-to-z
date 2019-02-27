/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 07.02.2019
 *
 * TrackerSQL.java Class implements Tracker that use postgres database to store data.
 * Methods:
 *  public boolean init() The method check connection to db.
 *  public void close() Closes this resource, relinquishing any underlying resources.
 *  public Item add(Item item) The methods add item to the database.
 *  public void replace(String id, Item item) The method replace fields data item.
 *  public void delete(Item item) The method delete item from db.
 *  public ArrayList<Item> findAll() The Method return all items.
 *  public ArrayList<Item> findByName(String key) The method takes a string and looks for it in the items table by field title.
 *  public ArrayList<Item> sqlToComments(PreparedStatement ps, ArrayList<Item> result)
 *   The method take preparedStatement, ArrayList collection that before added data from item table, and add comment
 *   to item from comments table.
 *  public ArrayList<Item> sqlToItem(PreparedStatement ps)
 *   The method take PreparedStatement and take result after sql query complete, after that insert data from db into
 *   item that store to collection that be returned.
 *  public Item findById(String id) The method takes a string and looks for it in the table items by item_id,
 *   returns the item which has that id.
 *  public void printToConsoleItem(ArrayList<Item> item) Print items to console.
 *  public String convert(long millis) Convert value millisecond to string date and time.
 *  public long convert(String userInputDate) Convert string value date and time.
 *  public void fieldsUpdate(Item item, Input input) Update fields (name, description, date time, comment) of new value.
 *  public void update(Item itemUpdate) The method from old implementation that used Collections to store items.
 *
 * StartUI.java Class Run UI with Menu.
 * Methods:
 *  public void init() Initialize Menu.
 *  static void main(String[] args) Add instance the input, invoke init().
 */
package ru.rrusanov.trackerSQL;