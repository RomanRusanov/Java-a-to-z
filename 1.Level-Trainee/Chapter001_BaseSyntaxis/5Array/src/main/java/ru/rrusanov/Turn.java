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
	 *  i - (int) index for loop.
	 *  leftIndex - (int) first element in array. Each iteration ++.
	 *  rightIndex - (int) last element in array.Each iteration --.
	 *  bufferValue - (int) temp value for rotation of elements.
	 * @return array - (int[]) turned array.
	**/
	public int[] back(int[] array) {
		/*
		  Declaration of value.
		*/
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