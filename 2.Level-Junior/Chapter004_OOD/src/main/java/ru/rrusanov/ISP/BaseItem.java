package ru.rrusanov.ISP;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.07.2019
 * <p>
 * The class describe menu item instance.
 */
public class BaseItem implements Item {

    /**
     * The field contain collection that contain sub MenuItems instance.
     */
    private List<BaseItem> children;

    /**
     * The field contain string that user must input, for activation this menu item.
     */
    private String hotKey;
    /**
     * The field contain name of menu.
     */
    private String name;

    /**
     * The default constructor.
     * @param name Sting value name.
     * @param hotkey String value for hot key.
     */
    public BaseItem(String name, String hotkey) {
        this.setName(name);
        this.hotKey = hotkey;
        this.children = new LinkedList<>();
    }
    /**
     * The method execute menu item some work. It run when user choose this menu.
     */
    public void action() {
        System.out.println("Execute action for menu" + this.name);
    }
    /**
     * The getter for field.
     * @return string.
     */
    public String getHotKey() {
        return this.hotKey;
    }

    /**
     * The method check contain this menu some submenu.
     * @return if contain return true, otherwise false.
     */
    public boolean isMenuItemContainChildren() {
        return !this.children.isEmpty();
    }

    /**
     * The getter for field.
     * @return String value.
     */
    public String getName() {
        return name;
    }

    /**
     * The setter for field.
     * @param name String value.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The method add to submenu passed instance.
     * @param item instance menu.
     * @return if added to collection return true, otherwise false.
     */
    public boolean addSubMenuItem(BaseItem item) {
        return this.children.add(item);
    }

    /**
     * The method return collection instance with all submenu.
     * @return Collection instance.
     */
    public List<BaseItem> getChildren() {
        return this.children;
    }

    /**
     * The method override equals method from object.
     * @param o Instance to compare.
     * @return If instance equals return true, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseItem baseItem = (BaseItem) o;
        return Objects.equals(children, baseItem.children)
                && hotKey.equals(baseItem.hotKey)
                && name.equals(baseItem.name);
    }

    /**
     * The method return hashcode this instance.
     * @return Int value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(children, hotKey, name);
    }

    /**
     * The method override toString method.
     * @return Correct view instance in String representation.
     */
    @Override
    public String toString() {
        return "BaseItem{"
                + ", hotKey='" + hotKey + '\''
                + ", name='" + name + '\''
                + '}';
    }
}