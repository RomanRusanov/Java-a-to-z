/**
 * Class calculate ( a * x2 + b * x + c ) and show how change value 
 * if x = (start...finish) with step 
 * @author Roman Rusanov
 * @param int x
 * @param int start - (first value of x)
 * @param int finish - (final value of x)
 * @param int step - (value step between x...x+1)
 * @since 13.11.2016
 * @version 0.1
**/
package ru.rrusanov;

public class Square {

	public int x = 0;
	public int start = 0;
	public int finish = 20;
	public int step = 2;

	// Calculate return float ( a * x2 + b * x + c )
	public float calculate(int x) {

		int a = 2;
		int b = 3;
		int c = 4;

		return (float)(a * (x * x) + b * x + c);
	}

	// Show result calculate where x betwen start...finish with step
	public void show(int start, int finish, int step) {
		/*int i = start;
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