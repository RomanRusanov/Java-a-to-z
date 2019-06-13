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
	private Interact interact;
	/**
	 * The field contain instance produce user input from console.
	 */
	private ConsoleInput consoleInput;

	/**
	 * The default constructor.
	 * @param interact instance.
	 */
	public CalcInit(Interact interact) {
		this.interact = interact;
		this.consoleInput = new ConsoleInput();
	}

	/**
	 * The method initiate main execution.
	 */
	public void init() {
		do {
			interact.writeToConsoleMenu();
			interact.takeUserChoose();
			interact.takeArgumentsFromConsole();
			interact.executeAction();
			interact.printResultToConsole();
		} while (!"y".equals(this.consoleInput.ask("Exit?(y)")));
	}
	/**
	 * Main method. Enter point.
	 * @param args arguments.
	 */
	public static void main(String[] args) {
		InteractWrapper interactEng = new InteractEng(new InteractCalc(new Calculator()));
		CalcInit calcInit =  new CalcInit(interactEng);
		calcInit.init();
	}
}
