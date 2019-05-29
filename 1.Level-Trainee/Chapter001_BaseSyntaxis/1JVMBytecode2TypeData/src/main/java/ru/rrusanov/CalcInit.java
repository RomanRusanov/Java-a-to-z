package ru.rrusanov;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 08.06.2016
 *
 * Class demonstrate simple calculator, and use Single Responsibility Principal.
 */
public class CalcInit {
	/**
	 * The field contain instance interact with calculator class.
	 */
	private InteractCalc interactCalc;
	/**
	 * The field contain instance produce user input from console.
	 */
	private ConsoleInput consoleInput;

	/**
	 * The default constructor.
	 * @param interactCalc instance.
	 * @param consoleInput instance.
	 */
	public CalcInit(InteractCalc interactCalc, ConsoleInput consoleInput) {
		this.interactCalc = interactCalc;
		this.consoleInput = consoleInput;
	}

	/**
	 * The method initiate main execution.
	 */
	public void init() {
		do {
			interactCalc.writeToConsoleMenu();
			interactCalc.takeUserChoose();
			interactCalc.takeArgumentsFromConsole();
			interactCalc.executeAction();
			interactCalc.printResultToConsole();
		} while (!"y".equals(this.consoleInput.ask("Exit?(y)")));
	}

	/**
	 * Main method. Enter point.
	 * @param args arguments.
	 */
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		ConsoleInput consoleInput = new ConsoleInput();
		InteractCalc interactCalc = new InteractCalc(calculator, consoleInput);
		CalcInit calcInit = new CalcInit(interactCalc, consoleInput);
		calcInit.init();
	}
}
