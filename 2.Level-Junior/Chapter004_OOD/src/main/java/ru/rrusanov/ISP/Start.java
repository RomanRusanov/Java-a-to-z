package ru.rrusanov.ISP;
import ru.rrusanov.tracker.ConsoleInput;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 18.07.2019
 * <p>
 * The class Start app.
 */
public class Start {
    /**
     * The method contain instance to take user choose from console.
     */
    private ConsoleInput consoleInput = new ConsoleInput();
    /**
     * The field contain instance menu.
     */
    private BaseItem item1 = new BaseItem("item_1", "1");
    /**
     * The field contain instance menu.
     */
    private BaseItem item11 = new BaseItem("item_1_1", "2");
    /**
     * The field contain instance menu.
     */
    private BaseItem item111 = new BaseItem("item_1_1_1", "3");
    /**
     * The field contain instance menu.
     */
    private BaseItem item112 = new BaseItem("item_1_1_2", "4");
    /**
     * The field contain instance menu.
     */
    private BaseItem item12 = new BaseItem("item_1_2", "5");
    /**
     * The field contain instance menu.
     */
    private MenuInteraction menuInteraction = new MenuInteraction();

    /**
     * The main enter point to app.
     * @param args arguments passed from console.
     */
    public static void main(String[] args) {
        Start start = new Start();
        start.init();
    }

    /**
     * The method initiate main execution.
     */
    public void init() {
        item1.addSubMenuItem(item11);
        item11.addSubMenuItem(item111);
        item11.addSubMenuItem(item112);
        item1.addSubMenuItem(item12);
        do {
            menuInteraction.printAllItems(item1, "");
            String userChoose = consoleInput.ask("Choose hotkey in round bracket to activate menu(?)");
            BaseItem menuChoosen = menuInteraction.findHotKey(item1, userChoose);
            menuChoosen.action();
        } while (!"y".equals(this.consoleInput.ask("Exit?(y)")));
    }
}