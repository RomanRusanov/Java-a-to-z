package ru.rrusanov;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 30.05.2019
 *
 * The class describe interact user and Engineer class, user input data from console.
 */
public class InteractEng implements Interact {
    /**
     * The field contain first argument in operation.
     */
    private double firstArg = 0;
    /**
     * The field contain second argument in operation.
     */
    private double secondArg = 0;
    /**
     * The field contain instance of Engineer class.
     */
    private Engineer engineer;
    /**
     * The field contain value that user choose.
     */
    private String userChoose = "";
    /**
     * The field contain all actions in engineer calculator.
     */
    private Map<String, Action> actions = new HashMap<>();
    /**
     * The field contain instance of ConsoleInput class.
     */
    private ConsoleInput consoleInput;

    /**
     * The default constructor.
     * @param engineer instance.
     * @param consoleInput instance.
     */
    public InteractEng(Engineer engineer, ConsoleInput consoleInput) {
        this.engineer = engineer;
        this.consoleInput = consoleInput;
        this.initFunc();

    }

    /**
     * The method add actions in map.
     */
    public void initFunc() {
        this.actions.put("s", this::sin);
        this.actions.put("c", this::cos);
        this.actions.put("t", this::tang);
        this.actions.put("p", this::pow);
    }

    /**
     * The method call sin function.
     * @return Double.
     */
    private Double sin() {
        this.engineer.sin(this.firstArg);
        return this.engineer.getResult();
    }

    /**
     * The method call cos function.
     * @return Double.
     */
    private Double cos() {
        this.engineer.cos(this.firstArg);
        return this.engineer.getResult();
    }

    /**
     * The method call tang function.
     * @return Double.
     */
    private Double tang() {
        this.engineer.tan(this.firstArg);
        return this.engineer.getResult();
    }

    /**
     * The method call pow function.
     * @return Double.
     */
    private Double pow() {
        this.engineer.pow(this.firstArg, this.secondArg);
        return this.engineer.getResult();
    }
    /**
     * The method print menu to console.
     */
    @Override
    public void writeToConsoleMenu() {
        System.out.printf("Menu with actions choose:%n");
        System.out.printf("s | trigonometric sine of an angle in between 0.0 and pi.%n");
        System.out.printf("c | trigonometric cosine of an angle.%n");
        System.out.printf("t | trigonometric tangent of an angle.%n");
        System.out.printf("p | number raise to the power%n");
    }

    /**
     * The method take and save arguments from console.
     */
    @Override
    public void takeArgumentsFromConsole() {
        firstArg = Double.parseDouble(this.consoleInput.ask("Input first argument - "));
        if (this.userChoose.equals("p")) {
            this.secondArg = Double.parseDouble(this.consoleInput.ask("Input second argument - "));
        }
    }

    /**
     * The method take and save user choose of action from menu.
     */
    @Override
    public void takeUserChoose() {
        this.userChoose = this.consoleInput.ask("Input number of actions ");
    }

    /**
     * The method exucute action that user choose.
     */
    @Override
    public void executeAction() {
        this.actions.getOrDefault(this.userChoose, () -> System.out.println("Incorrect input!")).action();
    }

    /**
     * The method print result to console.
     */
    @Override
    public void printResultToConsole() {
        System.out.printf("Result: %f", this.engineer.getResult());
    }
}
