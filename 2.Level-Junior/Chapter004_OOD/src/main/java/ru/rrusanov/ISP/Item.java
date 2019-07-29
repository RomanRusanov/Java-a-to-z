package ru.rrusanov.ISP;

import java.util.List;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 29.07.2019
 * <p>
 * The interface describe item.
 */
public interface Item {
    /**
     * The method execute menu item some work. It run when user choose this menu.
     */
    void action();
    /**
     * The method check contain this menu some submenu.
     * @return if contain return true, otherwise false.
     */
    boolean isMenuItemContainChildren();
    /**
     * The method add to submenu passed instance.
     * @param item instance menu.
     * @return if added to collection return true, otherwise false.
     */
    boolean addSubMenuItem(BaseItem item);
    /**
     * The method return collection instance with all submenu.
     * @return Collection instance.
     */
    List<BaseItem> getChildren();
    /**
     * The getter for field.
     * @return string.
     */
    String getHotKey();
    /**
     * The getter for field.
     * @return String value.
     */
    String getName();
}
