package ru.rrusanov.ISP;

import org.junit.Test;

public class MenuInteractionTest {

    @Test
    public void printAllItems() {
        BaseItem item_1 = new BaseItem("item_1", "1");
        BaseItem item_1_1 = new BaseItem("item_1_1", "2");
        BaseItem item_1_1_1 = new BaseItem("item_1_1_1", "3");
        BaseItem item_1_1_2 = new BaseItem("item_1_1_2", "4");
        BaseItem item_1_2 = new BaseItem("item_1_2", "5");
        item_1.addSubMenuItem(item_1_1);
        item_1_1.addSubMenuItem(item_1_1_1);
        item_1_1.addSubMenuItem(item_1_1_2);
        item_1.addSubMenuItem(item_1_2);
        MenuInteraction menuInteraction = new MenuInteraction();
        menuInteraction.printAllItems(item_1,"");
    }
}