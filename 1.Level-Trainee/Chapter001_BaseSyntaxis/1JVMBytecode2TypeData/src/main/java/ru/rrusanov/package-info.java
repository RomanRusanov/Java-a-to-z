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
 *  public void init() The method initiate main execution.
 *
 * ConsoleInput.java A class implements an input from console.
 *  public String ask(String question) Input from console to string value.
 *
 * InteractCalc.java The class describe interact user and Calculator class, user input data from console.
 *  public InteractCalc(Calculator calculator, ConsoleInput consoleInput) The default constructor.
 *  private void initFunc() The method add actions in map.
 *  private Double add()The method call add function.
 *  private Double sub() The method call subtract function.
 *  private Double div() The method call div function.
 *  private Double mult() The method call multiple function.
 *  private Double previous()
 *   The method use previous result as first argument and call function (add, sub, div, mult) on second argument.
 *  public void writeToConsoleMenu() The method print menu to console.
 *  public void takeArgumentsFromConsole() The method take and save arguments from console.
 *  public void takeUserChoose() The method take and save user choose of action from menu.
 *  public void executeAction() The method exucute action that user choose.
 *  public void printResultToConsole() The method print result to console.
 *
 * Interact.java The interface describe what methods must be implemented.
 *  void writeToConsoleMenu() The method print menu to console.
 *  void takeArgumentsFromConsole() The method take and save arguments from console.
 *  void takeUserChoose() The method take and save user choose of action from menu.
 *  void executeAction() The method exucute action that user choose.
 *  void printResultToConsole() The method print result to console.
 *  void setUserChoose(String value)The setter for field.
 *
 * InteractEng.java Class engineer calculator.
 *  public InteractCalc(Engineer engineer, ConsoleInput consoleInput) The default constructor.
 *  private void initFunc() The method add actions in map.
 *  private Double sin()The method call sin function.
 *  private Double cos() The method call cos function.
 *  private Double tang() The method call tang function.
 *  private Double pow() The method call pow function.
 *  public void writeToConsoleMenu() The method print menu to console.
 *  public void takeArgumentsFromConsole() The method take and save arguments from console.
 *  public void takeUserChoose() The method take and save user choose of action from menu.
 *  public void executeAction() The method exucute action that user choose.
 *  public void printResultToConsole() The method print result to console.
 *  public void checkActionExist() The method check what instance calculator to use.
 *
 * InteractWrapper.java The abstract class describe decorator methods.
 *  void writeToConsoleMenu() The method print menu to console.
 *  void takeArgumentsFromConsole() The method take and save arguments from console.
 *  void takeUserChoose() The method take and save user choose of action from menu.
 *  void executeAction() The method exucute action that user choose.
 *  void printResultToConsole() The method print result to console.
 *  void setUserChoose(String value)The setter for field.
 */
package ru.rrusanov;