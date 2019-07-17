package ru.rrusanov.ISP;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.07.2019
 * <p>
 * The class .
 */
public class BaseItem extends MenuItem {

    public BaseItem(String name) {
        this.setName(name);
    }
    /**
     * The method execute menu item some work. It run when user choose this menu.
     */
    @Override
    void action() {

    }
}
