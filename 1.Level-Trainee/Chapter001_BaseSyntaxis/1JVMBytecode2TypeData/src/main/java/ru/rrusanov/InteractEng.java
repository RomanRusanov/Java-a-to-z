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
public class InteractEng extends InteractWrapper {
    /**
     * The field contain wrapped instance.
     */
    private Interact interact;
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
    private ConsoleInput consoleInput = new ConsoleInput();
    /**
     * The filed contain state use this calculator or wrapped instance.
     */
    private boolean actionExist = false;

    /**
     * The default constructor.
     * @param interact instance.
     */
    public InteractEng(Interact interact) {
        this.interact = interact;
        this.engineer = new Engineer();
        this.initFunc();
    }

    /**
     * The method add actions in map.
     */
    public void initFunc() {
        this.actions.put("s", this::sin);
        this.actions.put("c", this::cos);
        this.actions.put("t", this::tang);
        this.actions.put("o", this::pow);
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
        this.interact.writeToConsoleMenu();
        System.out.printf("Menu with actions choose:%n");
        System.out.printf("s | trigonometric sine of an angle in between 0.0 and pi.%n");
        System.out.printf("c | trigonometric cosine of an angle.%n");
        System.out.printf("t | trigonometric tangent of an angle.%n");
        System.out.printf("o | number raise to the power%n");
    }

    /**
     * The method take and save arguments from console.
     */
    @Override
    public void takeArgumentsFromConsole() {
        if (this.actionExist) {
            firstArg = Double.parseDouble(this.consoleInput.ask("Input first argument - "));
            if (this.userChoose.equals("o")) {
                this.secondArg = Double.parseDouble(this.consoleInput.ask("Input second argument - "));
            }
        } else {
            this.interact.takeArgumentsFromConsole();
        }
    }

    /**
     * The method take and save user choose of action from menu.
     */
    @Override
    public void takeUserChoose() {
        this.userChoose = this.consoleInput.ask("Input number of actions ");
        this.checkActionExist();
        if (!this.actionExist) {
            this.setUserChoose(this.userChoose);
        }
    }

    /**
     * The method check what instance calculator to use.
     */
    public void checkActionExist() {
        this.actionExist = this.actions.containsKey(this.userChoose);
    }

    /**
     * The method execute action that user choose.
     */
    @Override
    public void executeAction() {
        if (this.actionExist) {
            this.actions.get(this.userChoose).action();
        } else {
            this.interact.executeAction();
        }
    }

    /**
     * The method print result to console.
     */
    @Override
    public void printResultToConsole() {
        if (this.actionExist) {
            System.out.printf("Result: %f", this.engineer.getResult());
        } else {
            this.interact.printResultToConsole();
        }

    }

    @Override
    public Map<String, Action> getActions() {
        Map<String, Action> result;
        if (this.actionExist) {
            result = this.actions;
        } else {
            result = this.interact.getActions();
        }
        return result;
    }

    @Override
    public void setUserChoose(String value) {
        if (this.actionExist) {
            this.userChoose = value;
        } else {
            this.interact.setUserChoose(value);
        }
    }
}