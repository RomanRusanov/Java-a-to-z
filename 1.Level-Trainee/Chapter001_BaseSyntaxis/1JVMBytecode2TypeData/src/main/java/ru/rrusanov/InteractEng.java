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
    private Integer userChoose = -1;
    /**
     * The field contain actions in menu.
     */
    private Map<Integer, Double> actions;

    /**
     * The default constructor.
     * @param engineer instance.
     * @param consoleInput instance.
     */
    public InteractEng(Engineer engineer, ConsoleInput consoleInput) {
        this.engineer = engineer;
        this.consoleInput = consoleInput;
        this.actions = new HashMap<>();
    }
    /**
     * The field contain instance of ConsoleInput class.
     */
    private ConsoleInput consoleInput;

    /**
     * The method print menu to console.
     */
    @Override
    public void writeToConsoleMenu() {
        System.out.printf("Menu with actions choose:%n");
        System.out.printf("1 trigonometric sine of an angle in between 0.0 and pi.%n");
        System.out.printf("2 trigonometric cosine of an angle.%n");
        System.out.printf("3 trigonometric tangent of an angle.%n");
        System.out.printf("4 number raise to the power%n");
    }

    /**
     * The method take and save arguments from console.
     */
    @Override
    public void takeArgumentsFromConsole() {
        firstArg = Double.parseDouble(this.consoleInput.ask("Input first argument - "));
        if (this.userChoose == 4) {
            this.secondArg = Double.parseDouble(this.consoleInput.ask("Input second argument - "));
        }
    }

    /**
     * The method take and save user choose of action from menu.
     */
    @Override
    public void takeUserChoose() {
        this.userChoose = Integer.valueOf(this.consoleInput.ask("Input number of actions"));
    }

    /**
     * The method fill map for each function calculate result.
     */
    public void fillActions() {
        this.actions.put(1, this.engineer.sin(this.firstArg));
        this.actions.put(2, this.engineer.cos(this.firstArg));
        this.actions.put(3, this.engineer.tan(this.firstArg));
        this.actions.put(4, this.engineer.pow(this.firstArg, this.secondArg));
    }
    /**
     * The method exucute action that user choose.
     */
    @Override
    public void executeAction() {
        this.fillActions();
        this.engineer.setResult(this.actions.getOrDefault(this.userChoose, 0.0));
    }

    /**
     * The method print result to console.
     */
    @Override
    public void printResultToConsole() {
        System.out.printf("Result: %f", this.engineer.getResult());
    }
}
