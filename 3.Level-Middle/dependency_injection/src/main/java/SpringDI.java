import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 09.02.2021
 * email roman9628@gmail.com
 * The class describe example DI with Spring.
 */
public class SpringDI {
    /**
     * The main method.
     * @param args Args string.
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Store.class);
        context.register(ConsoleInput.class);
        context.register(StartUI.class);
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();
        String userName = ui.getStringFromConsole("Enter your name, please:");
        System.out.println(userName);
    }
}