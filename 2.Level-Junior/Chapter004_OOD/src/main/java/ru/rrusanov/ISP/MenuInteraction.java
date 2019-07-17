package ru.rrusanov.ISP;

import java.util.Iterator;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.07.2019
 * <p>
 * The class .
 */
public class MenuInteraction {

    private String indent = "";

    public void printAllItems(BaseItem item, String indent) {
        System.out.println(indent + item.getName());
        if (item.isMenuItemContainChildren()) {
            this.indent = this.indent + "--";
            Iterator<BaseItem> itemIterator = item.getChildren().iterator();
            while (itemIterator.hasNext()) {
                printAllItems(itemIterator.next(),this.indent);
            }
            this.indent = this.indent.substring(this.indent.length() - 2);
        }
    }
}
