package ru.rrusanov;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 08.06.2016
 *
 * Class demonstrate simple calculator.
 */
public class CalcInit {
	/**
	 * Main method.
	 * @param args arguments.
	 */
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		//
		int first = 5;
		int second = 5;
		calc.add(first, second);
		System.out.printf("%d + %d = %.0f ", first, second, calc.getResult());
		//
		calc.subtract(first, second);
		System.out.printf("%d - %d = %.0f ", first, second, calc.getResult());
		//
		calc.div(first, second);
		System.out.printf("%d / %d = %.0f ", first, second, calc.getResult());
		//
		calc.multiple(first, second);
		System.out.printf("%d * %d = %.0f ", first, second, calc.getResult());
	}
}
