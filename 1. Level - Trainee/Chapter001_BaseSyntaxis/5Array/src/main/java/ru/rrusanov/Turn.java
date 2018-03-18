package ru.rrusanov;
/** Class turn array elements by change index.
* @author Roman Rusanov
* @since 29.11.2016
* @version 0.1
*/
public class Turn {
	/**
	 * Turn back each elements of array.
	 * @param array - (int[]) for turn.
	 * @{value} i - (int) index for loop.
	 * @{value} leftIndex - (int) first element in array. Each iteration ++.
	 * @{value} rightIndex - (int) last element in array.Each iteration --.
	 * @{value} bufferValue - (int) temp value for rotation of elements.
	 * @return array - (int[]) turned array.
	**/
	public int[] back(int[] array) {
		/**
		 * Declaration of value.
		**/
		int leftIndex;
		int rightIndex = array.length - 1;
		int bufferValue;

		for (leftIndex = 0; rightIndex >= leftIndex; leftIndex++) {
			bufferValue = array[rightIndex];
			array[rightIndex] = array[leftIndex];
			array[leftIndex] = bufferValue;
			rightIndex--;
		}
		return array;
	}
}