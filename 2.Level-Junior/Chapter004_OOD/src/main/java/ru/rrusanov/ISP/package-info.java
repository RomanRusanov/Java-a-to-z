/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 03.07.2019
 *
 * Start.java The class Start app.
 *  public static void main(String[] args) The main enter point to app.
 *  public void init() The method initiate main execution.
 *
 * BaseItem.java The class describe menu item instance.
 *  public BaseItem(String name, String hotkey) The default constructor.
 *  void action() The method execute menu item some work. It run when user choose this menu.
 *  public String getHotKey() The getter for field.
 *  public boolean isMenuItemContainChildren() The method check contain this menu some submenu.
 *  public String getName() The getter for field.
 *  public void setName(String name) The setter for field.
 *  public boolean addSubMenuItem(BaseItem item) The method add to submenu passed instance.
 *  public List<BaseItem> getChildren() The method return collection instance with all submenu.
 *  public boolean equals(Object o) The method override equals method from object.
 *  public int hashCode() The method return hashcode this instance.
 *  public String toString() The method override toString method.
 *
 * MenuInteraction.java The class describe interaction menu items with logic.
 *  public void printAllItems(BaseItem root, String indent)The method print to console all items with contain root item.
 *  public BaseItem findHotKey(BaseItem root, String hotkey) The method find matched instance menu item by hot key.
 *
 * Menu.java The interface describe menu.
 *  void printAllItems(BaseItem root, String indent)The method print to console all items with contain root item.
 *  BaseItem findHotKey(BaseItem root, String hotkey) The method find matched instance menu item by hot key.
 *
 * Item.java The interface describe item.
 *  void action() The method execute menu item some work. It run when user choose this menu.
 *  String getHotKey() The getter for field.
 *  boolean isMenuItemContainChildren() The method check contain this menu some submenu.
 *  String getName() The getter for field.
 *  void setName(String name) The setter for field.
 *  boolean addSubMenuItem(BaseItem item) The method add to submenu passed instance.
 *  List<BaseItem> getChildren() The method return collection instance with all submenu.
 */
package ru.rrusanov.ISP;