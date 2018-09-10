package ru.rrusanov;
/** Class sorts an array by the method of permutation(bubble algoritm).
* @author Roman Rusanov
* @since 1.12.2016
* @version 0.1
*/
public class Sort {
	/**
	 * Turn back each elements of array.
	 * @param array - (int[]) for sort.
	 *  i,j - (int) index for loop.
	 *  bufferArrayValue - (int) temp value for rotation of elements.
	 * @return array - (int[]) turned array.
	**/
	public int[] bubble(int[] array) {
		/*
		  Declaration of value.
		 */
		int bufferArrayValue;
		/*
		  Loop for sort array.
		 */
		for (int j = 0; j + 1 < array.length; j++) {
			for (int i = 0; i + 1 < array.length; i++) {
				if (array[i] > array[i + 1]) {
					bufferArrayValue = array[i + 1];
					array[i + 1] = array[i];
					array[i] = bufferArrayValue;
				}
			}
		}
		return array;
	}
}