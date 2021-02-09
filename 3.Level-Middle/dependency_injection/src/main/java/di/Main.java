package di;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 09.02.2021
 * email roman9628@gmail.com
 * The class demonstrate how context work.
 */
public class Main {
    /**
     * The main method.
     * @param args Args string.
     */
    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(ConsoleInput.class);
        context.reg(StartUI.class);

        StartUI ui = context.get(StartUI.class);

        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();
        String userName = ui.getStringFromConsole("Enter your name, please:");
        System.out.println(userName);
    }
}