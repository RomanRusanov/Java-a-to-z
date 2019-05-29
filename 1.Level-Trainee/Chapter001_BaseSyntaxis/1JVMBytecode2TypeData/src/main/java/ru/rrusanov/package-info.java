/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 08.06.2016
 *
 * Calculator.java simple calculator.
 *   void add(double first, double second) Addition operation.
 *   void subtract(double first, double second) Subtraction operation.
 *   void div(double first, double second) Division operation.
 *   void multiple(double first, double second) Multiple operation.
 *   double getResult() Getter for result value.
 *
 * CalcInit.java Class demonstrate simple calculator, and use Single Responsibility Principal.
 *  public CalcInit(InteractCalc interactCalc, ConsoleInput consoleInput) The default constructor.
 *  public static void main(String[] args) Main method. Enter point.
 *
 * ConsoleInput.java A class implements an input from console.
 *  public String ask(String question) Input from console to string value.
 *
 * InteractCalc.java The class describe interact user and Calculator class, user input data from console.
 *  public InteractCalc(Calculator calculator, ConsoleInput consoleInput) The default constructor.
 *  public void writeToConsoleMenu() The method print menu to console.
 *  public void takeArgumentsFromConsole() The method take and save arguments from console.
 *  public void takeUserChoose() The method take and save user choose of action from menu.
 *  public void executeAction() The method exucute action that user choose.
 *  public void printResultToConsole() The method print result to console.
 */
package ru.rrusanov;