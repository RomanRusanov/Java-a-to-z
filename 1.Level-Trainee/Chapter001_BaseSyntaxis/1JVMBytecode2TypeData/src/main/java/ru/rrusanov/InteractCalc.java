package ru.rrusanov;

/**
 * The class describe interact user and Calculator class, user input data from console.
 */
public class InteractCalc {
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
    private Integer userChoose;
    /**
     * The field contain instance of ConsoleInput class.
     */
    private ConsoleInput consoleInput;

    /**
     * The default constructor.
     * @param calculator instance.
     * @param consoleInput instance.
     */
    public InteractCalc(Calculator calculator, ConsoleInput consoleInput) {
        this.calculator = calculator;
        this.consoleInput = consoleInput;
    }

    /**
     * The method print menu to console.
     */
    public void writeToConsoleMenu() {
        System.out.printf("Menu with actions choose:%n");
        System.out.printf("1 add%n");
        System.out.printf("2 subtract%n");
        System.out.printf("3 division%n");
        System.out.printf("4 multiple%n");
        System.out.printf("5 use previous result as first argument%n");
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
        this.userChoose = Integer.valueOf(this.consoleInput.ask("Input number of actions"));
    }

    /**
     * The method exucute action that user choose.
     */
    public void executeAction() {
        if (this.userChoose == 1) {
            this.calculator.add(this.firstArg, this.secondArg);
        }
        if (this.userChoose == 2) {
            this.calculator.subtract(this.firstArg, this.secondArg);
        }
        if (this.userChoose == 3) {
            this.calculator.div(this.firstArg, this.secondArg);
        }
        if (this.userChoose == 4) {
            this.calculator.multiple(this.firstArg, this.secondArg);
        }
        if (this.userChoose == 5) {
            this.takeUserChoose();
            this.firstArg = this.calculator.getResult();
            this.executeAction();
        }
    }

    /**
     * The method print result to console.
     */
    public void printResultToConsole() {
        System.out.printf("Result: %f", this.calculator.getResult());
    }
}
