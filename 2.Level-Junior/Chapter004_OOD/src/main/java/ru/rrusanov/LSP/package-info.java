/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 18.06.2019
 *
 * Control.java The interface describe control instance.
 *  void processToStore(Collection<Food> foods) The method move foods to stores.
 *  Store getStore(String name) The getter for field.
 *
 * ControlQuality.java The class describe ControlQuality instance.
 *  public ControlQuality(boolean test) The constructor.
 *  public void processToStore(Collection<Food> foods) The method distributes foods between stores.
 *  public Store getStore(String name) The getter for field.
 *  public Collection<Food> getAllFoods() The method get all food from all possible store and clear stores.
 *  public void relocateFoods() The method relocate all foods by store(check expire date).
 *  public void addStore(Store store) The method add store to control.
 *
 * Store.java The interface describe store instance.
 *  public String getName() The getter for field.
 *  public void putInStore(Food food) The method add food to store container.
 *  public HashMap<String, Food> getAllFood() The getter for field.
 *  public boolean removeFood(String name) The method remove food from.
 *  public boolean isConditionMatched(Food food, Long passedTime)
 *   The method check matched this store for passed food instance.
 *
 * Warehouse.java The class describe Warehouse store instance.
 *  public Warehouse(String name) The constructor.
 *  public String getName() The getter for field.
 *  public void putInStore(Food food) The method add food to store container.
 *  public HashMap<String, Food> getAllFood() The getter for field.
 *  public boolean removeFood(String name) The method remove food from.
 *  public boolean isConditionMatched(Food food, Long passedTime)
 *   The method check matched this store for passed food instance.
 *
 * Trash.java The class describe Trash store instance.
 *  public Trash(String name) The constructor.
 *  public String getName() The getter for field.
 *  public void putInStore(Food food) The method add food to store container.
 *  public HashMap<String, Food> getAllFood() The getter for field.
 *  public boolean removeFood(String name) The method remove food from.
 *  public boolean isConditionMatched(Food food, Long passedTime)
 *   The method check matched this store for passed food instance.
 *
 * Shop.java The class describe Shop store instance.
 *  public Shop(String name) The constructor.
 *  public String getName() The getter for field.
 *  public void putInStore(Food food) The method add food to store container.
 *  public HashMap<String, Food> getAllFood() The getter for field.
 *  public boolean removeFood(String name) The method remove food from.
 *  public boolean isConditionMatched(Food food, Long passedTime)
 *   The method check matched this store for passed food instance.
 */
package ru.rrusanov.LSP;