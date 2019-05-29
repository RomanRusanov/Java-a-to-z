package ru.rrusanov;

import java.util.Scanner;

public class InteractCalc {

    private double firstArg;

    private double secondArg;


    private Calculator calculator;

    private Integer userChoose;

    private ConsoleInput consoleInput;

    public InteractCalc(Calculator calculator, ConsoleInput consoleInput) {
        this.calculator = calculator;
        this.consoleInput = consoleInput;
    }

    public void writeToConsoleMenu() {
        System.out.printf("Menu with actions choose:%n");
        System.out.printf("1 add%n");
        System.out.printf("2 subtract%n");
        System.out.printf("3 division%n");
        System.out.printf("4 multiple%n");
        System.out.printf("5 use previous result as first argument%n");
    }

    public void takeArgumentsFromConsole() {
        firstArg = Double.parseDouble(this.consoleInput.ask("Input first argument - "));
        secondArg = Double.parseDouble(this.consoleInput.ask("Input second argument - "));
    }

    public void takeUserChoose() {
        this.userChoose = Integer.valueOf(this.consoleInput.ask("Input number of actions"));
    }

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

    public void printResultToConsole() {
        System.out.printf("Result: %f", this.calculator.getResult());
    }
}
