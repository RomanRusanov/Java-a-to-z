package ru.rrusanov;
/** Class calculate (a*x2+b*x+c) and show how change value if x =(start...finish) with step.
* @author Roman Rusanov
* @param int x
* @param int start - first value of x
* @param int finish - final value of x
* @param int step - value step between x...x+1
* @since 13.11.2016
* @version 0.1
*/
public class Square {
	/** Calculate expression (a*x2+b*x+c).
	* @param x - int x
	* {@value} a - a
	* {@value} b - b
	* {@value} c - c
	* @return float - result of expression a*x2+b*x+c
	*/
	public float calculate(int x) {
		final int a = 2;
		final int b = 3;
		final int c = 4;
		return (float)  (a * (x * x) + b * x + c);
	}

	/** Show result calculate where x betwen start...finish with step.
	 * @param start - int first value of x
	 * @param finish - int last value of x
	 * @param step - int step the value increases at each iteration
	 */
	public void show(int start, int finish, int step) {
		/*
		for (int start; start < finish; start = start + step ) {
			System.out.println("y = " + calculate(start) + " x value = " + start);
		}
		*/
		while (start < finish) {
			System.out.println("y = " + calculate(start) + " x value = " + start);
			start = start + step;
		}
	}
}