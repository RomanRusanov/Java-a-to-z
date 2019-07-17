package ru.rrusanov.ISP;

import java.util.List;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 04.07.2019
 * <p>
 * The class describe .
 */
public abstract class MenuItem {
    /**
     * The field contain name of menu;
     */
    private String name;
    /**
     * The field contain collection that contain sub MenuItems instance.
     */
    private List<MenuItem> children;
    /**
     * The field contain string that user must input, for activation this menu item.
     */
    private String hotKey;

    /**
     * The method execute menu item some work. It run when user choose this menu.
     */
    abstract void action();

    /**
     * The getter for field.
     * @return string.
     */
    public String getHotKey(){
        return this.hotKey;
    }

    /**
     * The method check contain this menu some submenu.
     * @return if contain return true, otherwise false.
     */
    public boolean isMenuItemContainChildren() {
        return this.children.isEmpty();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addSubMenuItem(MenuItem item) {
        return this.children.add(item);
    }
}