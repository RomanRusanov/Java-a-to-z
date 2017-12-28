package ru.rrusanov;
/** Exersice 4.2 Create a program that calculates the factorial.
 * @author Roman Rusanov
 * @since 19.11.2016
 * @version 0.1
 */
public class Factorial {
	/** The calculates the value of the function factorial.
	 * @param n - the last value(int) up to which to calculate the factorial of
	 * @return result - the value(long) of the function factorial
	 * {@value} i - index of iteration for loop
	 */
	public long calculate(int n) {
		if (n > 0) {
			long result = 1;
			for (int i = 1; i <= n; i++ ) {
				result *= i;
			}
			return result;
		} else {
			System.out.println("ERROR! Function factorial can be calculated only for positive integers.");
			return -1;
		}
	}
}