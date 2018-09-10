package ru.rrusanov;
/** Class for rotation of square array.
* @author Roman Rusanov
* @since 5.12.2016
* @version 0.1
*/
public class Rotate {
	/**
	 * Rotate array elements 90 degrees clockwise.
	 * @param array - (int[][]) for rotate.
	 *  i,j - (int) index for loop.
	 * @return array - (int[][]) array after rotate.
	**/
	public int[][] clockwise(int[][] array) {
		/*
		  Declaration and initialization of the new array to be rotated.
		*/
		int[][] newArray = new int[array.length][array.length];
		/*
		  Finding new elements and assign the rotated array.
		*/
		for (int i = 0; i  < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				newArray[i][j] = array[array.length - 1 - j][i];
			}
		}
		return newArray;
	}
}