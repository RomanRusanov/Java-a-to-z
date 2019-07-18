package ru.rrusanov.ISP;

import java.util.Iterator;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.07.2019
 * <p>
 * The class describe interaction menu items with logic.
 */
public class MenuInteraction {
    /**
     * The field contain start indent symbol for each menu items.
     * For next level menu be added --
     */
    private String indent = "";
    /**
     * The fild contain line separator for new line.
     */
    private static final String NEW_LINE = System.lineSeparator();

    /**
     * The method print to console all items with contain root item.
     * @param root Root item.
     * @param indent indent for next level menu.
     */
    public void printAllItems(BaseItem root, String indent) {
        System.out.printf("%s%s (%s)%s", indent, root.getName(), root.getHotKey(), NEW_LINE);
        if (root.isMenuItemContainChildren()) {
            this.indent = this.indent + "--";
            Iterator<BaseItem> itemIterator = root.getChildren().iterator();
            while (itemIterator.hasNext()) {
                printAllItems(itemIterator.next(), this.indent);
            }
            this.indent = this.indent.substring(this.indent.length() - 2);
        }
    }

    /**
     * The method find matched instance menu item by hot key.
     * @param root Root item.
     * @param hotkey Sting value.
     * @return Instance item menu.
     */
    public BaseItem findHotKey(BaseItem root, String hotkey) {
        BaseItem result = null;
        if (root.getHotKey().equals(hotkey)) {
            return root;
        }
        if (root.isMenuItemContainChildren()) {
            Iterator<BaseItem> itemIterator = root.getChildren().iterator();
            while (itemIterator.hasNext()) {
                result = findHotKey(itemIterator.next(), hotkey);
                if (result != null) {
                    break;
                }
            }
        }
        return result;
    }
}
