package ru.rrusanov;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 08.06.2016
 *
 * Class demonstrate simple calculator.
 */
public class CalcInit {

	private InteractCalc interactCalc;

	private ConsoleInput consoleInput;

	public CalcInit(InteractCalc interactCalc, ConsoleInput consoleInput) {
		this.interactCalc = interactCalc;
		this.consoleInput = consoleInput;
	}

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
	 * Main method.
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
