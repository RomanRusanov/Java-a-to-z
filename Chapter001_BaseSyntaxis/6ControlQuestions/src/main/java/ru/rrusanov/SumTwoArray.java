package ru.rrusanov;
/** Class return array sum.
* @author Roman Rusanov
* @since 16.12.2016
* @version 0.2
*/
public class SumTwoArray {
	/**
	 * Get merge two sorted arrays.
	 * @param firstArray - (int[]).
	 * @param secondArray - (int[]).
	 * @{value} a, b - (int) index position for array.
	 * @return array - (int[]) Merged first and second arrays elements.
	**/
	public int[] merge(int[] firstArray, int[] secondArray) {
		int[] sumArray = new int[firstArray.length + secondArray.length];
		int a = 0;
		int b = 0;
		while ((a + b) < sumArray.length) {
			if (b >= secondArray.length || a < firstArray.length && firstArray[a] <= secondArray[b]) {
				sumArray[a + b] = firstArray[a];
				a++;
			} else {
				sumArray[a + b] = secondArray[b];
				b++;
			}
		}
		return sumArray;
	}
}