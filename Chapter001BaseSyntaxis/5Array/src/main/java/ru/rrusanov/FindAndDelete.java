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
	 * @{value} i,i1 - (int) index for loop.
	 * @return array - (String[]) array without duplicate.
	**/
	public String[] stringArray(String[] array) {
		int duplicateCount = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length - 1; j++) {

				if (array[i].equals(array[i < array.length - 2 ? j : i + 1])) {
					duplicateCount++;
					System.out.println(duplicateCount);
					for (int i1 = j; i1 < array.length - 1; i1++) {
						array[i1] = array[i1 + 1];
					}
				}
			}
		}
		return copyOf(array, array.length);
	}
}