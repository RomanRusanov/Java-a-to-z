package ru.rrusanov;
import static java.util.Arrays.copyOf;
/** Class Find duplicated element at array and delete them.
* @author Roman Rusanov
* @since 7.12.2016
* @version 0.2
*/
public class FindAndDelete {
	/**
	 * Find in array duplicated elements.
	 * @param array - (String[]) for rotate.
	 *  i,j,i1 - (int) index for loop.
	 *  duplicateCount - (int) count duplicate elements in array.
	 * @return array - (String[]) array without duplicate.
	**/
	public String[] stringArray(String[] array) {
		int duplicateCount = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length - 1 - duplicateCount; j++) {
				while (array[i].equals(array[j])) {
					if (array.length - 1 - j >= 0) {
						System.arraycopy(array, j + 1, array, j, array.length - 1 - j);
					}
					duplicateCount++;
				}
			}
		}
		return copyOf(array, array.length - 1 - duplicateCount);
	}
}