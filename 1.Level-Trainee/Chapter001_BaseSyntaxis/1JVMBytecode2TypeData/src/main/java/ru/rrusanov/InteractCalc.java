package ru.rrusanov;

import java.util.HashMap;
import java.util.Map;

/**
 * The class describe interact user and Calculator class, user input data from console.
 */
public class InteractCalc implements Interact {
    /**
     * The field contain first argument in operation.
     */
    private double firstArg;
    /**
     * The field contain second argument in operation.
     */
    private double secondArg;
    /**
     * The field contain instance of Calculator class.
     */
    private Calculator calculator;
    /**
     * The field contain value that user choose.
     */
    private String userChoose;
    /**
     * The field contain instance of ConsoleInput class.
     */
    private ConsoleInput consoleInput = new ConsoleInput();
    /**
     * The field contain all actions in calculator.
     */
    private Map<String, Action> actions = new HashMap();

    /**
     * The default constructor.
     * @param calculator instance.
     */
    public InteractCalc(Calculator calculator) {
        this.calculator = calculator;
        this.initFunc();
    }

    /**
     * The getter for actions field.
     * @return Map.
     */
    public Map<String, Action> getActions() {
        return this.actions;
    }

    @Override
    public void setUserChoose(String value) {
        this.userChoose = value;
    }

    /**
     * The method add actions in map.
     */
    private void initFunc() {
        this.actions.put("+", this::add);
        this.actions.put("-", this::sub);
        this.actions.put("/", this::div);
        this.actions.put("*", this::mult);
        this.actions.put("p", this::previous);
    }

    /**
     * The method call add function.
     * @return Double.
     */
    private Double add() {
        this.calculator.add(this.firstArg, this.secondArg);
        return this.calculator.getResult();
    }

    /**
     * The method call subtract function.
     * @return Double.
     */
    private Double sub() {
        this.calculator.subtract(this.firstArg, this.secondArg);
        return this.calculator.getResult();
    }

    /**
     * The method call div function.
     * @return Double.
     */
    private Double div() {
        this.calculator.div(this.firstArg, this.secondArg);
        return this.calculator.getResult();
    }

    /**
     * The method call multiple function.
     * @return Double.
     */
    private Double mult() {
        this.calculator.multiple(this.firstArg, this.secondArg);
        return this.calculator.getResult();
    }

    /**
     * The method use previous result as first argument and call function (add, sub, div, mult) on second argument.
     * @return Double.
     */
    private Double previous() {
        this.firstArg = this.calculator.getResult();
        this.writeToConsoleMenu();
        this.takeUserChoose();
        this.actions.getOrDefault(this.userChoose, () -> System.out.println("Not correct input!")).action();
        return this.calculator.getResult();
    }
    /**
     * The method print menu to console.
     */
    public void writeToConsoleMenu() {
        System.out.printf("Menu with actions choose:%n");
        System.out.printf("+ | add%n");
        System.out.printf("- | subtract%n");
        System.out.printf("/ | division%n");
        System.out.printf("* | multiple%n");
        System.out.printf("p | use previous result as first argument%n");
    }

    /**
     * The method take and save arguments from console.
     */
    public void takeArgumentsFromConsole() {
        firstArg = Double.parseDouble(this.consoleInput.ask("Input first argument - "));
        secondArg = Double.parseDouble(this.consoleInput.ask("Input second argument - "));
    }

    /**
     * The method take and save user choose of action from menu.
     */
    public void takeUserChoose() {
        this.userChoose = this.consoleInput.ask("Input number of actions");
    }

    /**
     * The method execute action that user choose.
     * @param action action that user choose.
     */
    public void executeAction(String action) {
        this.actions.getOrDefault(action, () -> System.out.println("Incorrect input!")).action();
    }

    /**
     * The method print result to console.
     */
    public void printResultToConsole() {
        System.out.printf("Result: %f", this.calculator.getResult());
    }
}
