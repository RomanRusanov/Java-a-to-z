package ru.rrusanov.ISP;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 29.07.2019
 * <p>
 * The interface describe menu.
 */
public interface Menu {

    /**
     * The method print to console all items with contain root item.
     * @param root Root item.
     * @param indent indent for next level menu.
     */
    void printAllItems(Item root, String indent);

    /**
     * The method find matched instance menu item by hot key.
     * @param root Root item.
     * @param hotkey Sting value.
     * @return Instance item menu.
     */
    Item findHotKey(Item root, String hotkey);
}
