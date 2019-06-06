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
	 * Main method. Enter point.
	 * @param args arguments.
	 */
	public static void main(String[] args) {
		InteractEng interactEng = new InteractEng(new Engineer());
		InteractCalc interactCalc = new InteractCalc(new Calculator());
		InteractWrapper interactWrapper = new InteractWrapper();
		interactWrapper.addInteract(interactCalc);
		interactWrapper.addInteract(interactEng);
		interactWrapper.executeAction();
	}
}
