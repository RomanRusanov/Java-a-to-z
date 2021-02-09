/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 09.02.2021
 * email roman9628@gmail.com
 * This class, depend of class Store.
 */
public class StartUI {
    /**
     * The filed contain instance on which depend.
     */
    private Store store;
    /**
     * The filed contain default input.
     */
    private ConsoleInput input;

    /**
     * The default constructor.
     * @param store Instance of depend instance.
     * @param input Default input.
     */
    public StartUI(Store store, ConsoleInput input) {
        this.store = store;
        this.input = input;
    }

    /**
     * The method add String to collection.
     * @param value String.
     */
    public void add(String value) {
        store.add(value);
    }

    /**
     * Print all String from collection.
     */
    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }

    public String getStringFromConsole(String questionMessage) {
        return this.input.ask(questionMessage);
    }
}