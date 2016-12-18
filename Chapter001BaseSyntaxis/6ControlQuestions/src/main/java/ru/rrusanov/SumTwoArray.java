package ru.rrusanov;
/** Class return array sum.
* @author Roman Rusanov
* @since 16.12.2016
* @version 0.1
*/
public class SumTwoArray {
	/**
	 * Get sum firstArray and secondArray.
	 * @param firstArray - (int[]).
	 * @param secondArray - (int[]).
	 * @{value} i,j - (int) index for loop.
	 * @return array - (int[]) Sum first and second array elements.
	**/
	public int[] sum(int[] firstArray, int[] secondArray) {
		int[] sumArray = new int[firstArray.length + secondArray.length];
		for (int i = 0, j = 0; i < sumArray.length - 1; i = i + 2, j++) {
			sumArray[i] = firstArray[j];
			sumArray[i + 1] = secondArray[j];
		}
		return sumArray;
	}
}