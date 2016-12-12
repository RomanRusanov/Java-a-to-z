package ru.rrusanov;
import static java.util.Arrays.copyOf;
/** Class Find duplicated element at array and delete them.
* @author Roman Rusanov
* @since 7.12.2016
* @version 0.1
*/
public class FindAndDelete {
	/**
	 * Find in array duplicated elements.
	 * @param array - (String[]) for rotate.
	 * @{value} i,j,i1 - (int) index for loop.
	 * @return array - (String[]) array without duplicate.
	**/
	public String[] stringArray(String[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length - 2; j++) {
				while (array[i].equals(array[j])) {
					for (int i1 = j; i1 < array.length - 1; i1++) {
						array[i1] = array[i1 + 1];
					}
					array = copyOf(array, array.length - 1);
				}
			}
		}
		array = copyOf(array, array.length - 1);
		return array;
	}
}